package compat.core.loader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.InvokeDynamicInsnNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.LocalVariableNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.MultiANewArrayInsnNode;
import org.objectweb.asm.tree.TryCatchBlockNode;
import org.objectweb.asm.tree.TypeInsnNode;

import compat.core.layer.CompatibilityLayer;

public class CompatibilityClassTransformer {
	ClassNode classNode;
	List<String> fields = new ArrayList<>();
	private final CompatibilityLayer layer;

	public CompatibilityClassTransformer(CompatibilityLayer layer, byte[] data) {
		this.layer = layer;
		ClassReader classReader = new ClassReader(data);
		classNode = new ClassNode();
		classReader.accept(classNode, ClassReader.SKIP_FRAMES);
		for (FieldNode field : classNode.fields) {
			fields.add(field.name);
		}
	}

	public String getThisClass() {
		return classNode.name;
	}

	public List<String> getFields() {
		return fields;
	}

	public String getSuperClass() {
		return classNode.superName;
	}

	public String[] getInterfaces() {
		return classNode.interfaces.toArray(new String[0]);
	}

	public boolean isClassException(String name) {
		if (name.startsWith("java/")) {
			if (name.startsWith("java/lang/reflect/")) {
				return false; // We must handle reflection attempts and redirect accordingly...
			}
			return true;
		}

		if (name.startsWith("javax/"))
			return true;

		if (name.startsWith("org/lwjgl/"))
			return true;

		if (name.startsWith("org/apache/"))
			return true;

		if (name.startsWith("com/google/"))
			return true;

		if (name.startsWith("com/mojang/authlib/"))
			return true;

		return false;
	}

	private String getTransformedClassname(String name) {
		if (name.startsWith("[")) {
			return transformDescriptor(name);
		}
		if (!isClassException(name)) {
			return layer.getPrefixedClassname(name);
		}
		return name;
	}

	private String transformDescriptor(String desc) {
		StringBuilder sb = new StringBuilder();
		String substr;
		int posOld;

		for (int pos = 0; pos < desc.length(); pos++) {
			switch (desc.charAt(pos)) {
			case 'B':
			case 'C':
			case 'D':
			case 'F':
			case 'I':
			case 'J':
			case 'S':
			case 'V':
			case 'Z':
			case '[':
			case '(':
			case ')':
				sb.append(desc.charAt(pos));
				break;
			case 'L':
				sb.append(desc.charAt(pos));
				posOld = pos + 1;
				while (desc.charAt(pos) != ';')
					pos++;
				substr = desc.substring(posOld, pos);
				sb.append(getTransformedClassname(substr));

				sb.append(';');
				break;

			}
		}

		return sb.toString();
	}

	private boolean doesClassContainField(Map<String, LoadClassInfo> classesToLoad, String className, String fieldName) {
		if (!classesToLoad.containsKey(className)) {
			return false;
		}

		LoadClassInfo classInfo = classesToLoad.get(className);
		if (classInfo.fields.contains(fieldName)) {
			return true;
		}

		return doesClassContainField(classesToLoad, classInfo.parentName, fieldName);
	}

	public static boolean isMcClass(String name) {
		name = name.replace(".", "/");
		return name.startsWith("net/minecraft/") || name.startsWith("net/minecraftforge/");
	}

	private static boolean isMethodException(String targetClassName, String name) {
		// Skip constructors
		if (name.equals("<init>") || name.equals("<clinit>"))
			return true;

		// Skip special enum methods
		if (name.equals("values") || name.equals("valueOf") || name.equals("clone"))
			return true;

		if (name.equals("ordinal") || name.equals("name") || name.equals("hashCode") || name.equals("equals")) {
			if (!isMcClass(targetClassName)) {
				return true;
			}
		}

		// Skip Runnable method
		if (name.equals("run"))
			return true;

		// Skip lambdas
		if (name.startsWith("lambda") || name.equals("test") || name.equals("call"))
			return true;

		// Skip stream methods?
		if (name.equals("apply") || name.equals("accept") || name.equals("applyAsInt"))
			return true;

		return false;
	}

	private Handle transformHandle(Handle handle) {
		String desc = transformDescriptor(handle.getDesc());
		String owner = getTransformedClassname(handle.getOwner());
		String name = handle.getName();
		if (!isMethodException(handle.getOwner(), name) && !isClassException(handle.getOwner())) {
			name = layer.getPrefixFake() + name;
		}
		return new Handle(handle.getTag(), owner, name, desc, handle.isInterface());
	}

	private List<AbstractInsnNode> transformInstruction(AbstractInsnNode instruction, Map<String, LoadClassInfo> classesToLoad) {
		int opcode = instruction.getOpcode();
		List<AbstractInsnNode> ret = new ArrayList<>();
		ret.add(instruction);

		switch (opcode) {
		case Opcodes.CHECKCAST:
		case Opcodes.ANEWARRAY:
		case Opcodes.INSTANCEOF:
		case Opcodes.NEW:
			TypeInsnNode type = (TypeInsnNode) instruction;
			type.desc = getTransformedClassname(type.desc);
			break;
		case Opcodes.GETFIELD:
		case Opcodes.GETSTATIC:
		case Opcodes.PUTFIELD:
		case Opcodes.PUTSTATIC:
			FieldInsnNode field = (FieldInsnNode) instruction;
			if (isClassException(field.owner)) {
				break;
			}

			if (doesClassContainField(classesToLoad, field.owner, field.name)) {
				field.desc = transformDescriptor(field.desc);
				field.name = layer.getPrefixFake() + field.name;
				field.owner = getTransformedClassname(field.owner);
			} else {
				ret.clear();
				String name = "";
				MethodInsnNode fieldMethod = null;
				String desc = transformDescriptor(field.desc);
				String owner = getTransformedClassname(field.owner);
				switch (opcode) {
				case Opcodes.GETSTATIC:
					name = layer.getPrefixGet() + field.name;
					desc = "()" + desc;
					fieldMethod = new MethodInsnNode(Opcodes.INVOKESTATIC, owner, name, desc, false);
					break;
				case Opcodes.PUTSTATIC:
					name = layer.getPrefixSet() + field.name;
					desc = "(" + desc + ")V";
					fieldMethod = new MethodInsnNode(Opcodes.INVOKESTATIC, owner, name, desc, false);
					break;
				case Opcodes.GETFIELD:
					name = layer.getPrefixGet() + field.name;
					desc = "()" + desc;
					fieldMethod = new MethodInsnNode(Opcodes.INVOKEVIRTUAL, owner, name, desc, false);
					break;
				case Opcodes.PUTFIELD:
					name = layer.getPrefixSet() + field.name;
					desc = "(" + desc + ")V";
					fieldMethod = new MethodInsnNode(Opcodes.INVOKEVIRTUAL, owner, name, desc, false);
				}
				ret.add(fieldMethod);
			}
			break;
		case Opcodes.INVOKEDYNAMIC:
			InvokeDynamicInsnNode methoddyn = (InvokeDynamicInsnNode) instruction;
			methoddyn.desc = transformDescriptor(methoddyn.desc);

			if (!isMethodException("", methoddyn.name)) {
				methoddyn.name = layer.getPrefixFake() + methoddyn.name;
			}

			methoddyn.bsm = transformHandle(methoddyn.bsm);
			for (int i = 0; i < methoddyn.bsmArgs.length; i++) {
				Object arg = methoddyn.bsmArgs[i];
				if (arg instanceof Handle) {
					methoddyn.bsmArgs[i] = transformHandle((Handle) arg);
				}
				if (arg instanceof Type) {
					Type argType = (Type) arg;
					String desc = argType.getDescriptor();
					desc = transformDescriptor(desc);
					methoddyn.bsmArgs[i] = Type.getType(desc);
				}
			}
			break;
		case Opcodes.INVOKEINTERFACE:
		case Opcodes.INVOKESPECIAL:
		case Opcodes.INVOKESTATIC:
		case Opcodes.INVOKEVIRTUAL:
			MethodInsnNode method = (MethodInsnNode) instruction;
			if (!isClassException(method.owner)) {
				// Skip constructors and special enum methods
				if (!isMethodException(method.owner, method.name)) {
					method.name = layer.getPrefixFake() + method.name;
				}
				method.owner = getTransformedClassname(method.owner);
				method.desc = transformDescriptor(method.desc);
			}
			if (method.owner.equals("java/lang/Class")) {
				if (method.name.equals("getConstructor") || method.name.equals("getDeclaredField") || method.name.equals("getDeclaredFields") || method.name.equals("forName")) {
					method.name = layer.getPrefixFake() + method.name;

					method.setOpcode(Opcodes.INVOKESTATIC);
					method.owner = layer.getPrefixedClassname(method.owner);
					method.desc = transformDescriptor(method.desc);
					if (opcode != Opcodes.INVOKESTATIC) {
						method.desc = "(Ljava/lang/Class;" + method.desc.substring(1);
					}
				}
			}
			break;
		case Opcodes.MULTIANEWARRAY:
			MultiANewArrayInsnNode multiarray = (MultiANewArrayInsnNode) instruction;
			multiarray.desc = transformDescriptor(multiarray.desc);
			break;
		case Opcodes.LDC:
			LdcInsnNode ldc = (LdcInsnNode) instruction;
			if (ldc.cst instanceof Type) {
				Type typeCst = (Type) ldc.cst;
				String className = typeCst.getInternalName();
				if (!isClassException(className)) {
					className = getTransformedClassname(className);
					ldc.cst = Type.getObjectType(className);
				}
			}
			break;
		default:
			break;
		}
		return ret;
	}

	private void transformAnnotations(List<AnnotationNode> annotations) {
		if (annotations == null)
			return;
		for (AnnotationNode annotation : annotations) {
			annotation.desc = transformDescriptor(annotation.desc);

			if (annotation.values == null)
				continue;

			for (int i = 0; i < annotation.values.size(); i++) {
				Object value = annotation.values.get(i);
				if (value instanceof Type) {
					String className = ((Type) value).getInternalName();
					className = getTransformedClassname(className);
					Type newType = Type.getObjectType(className);
					annotation.values.set(i, newType);
				}
				if (value instanceof String[]) {
					// TODO
				}
			}
		}
	}

	private List<String> transformInterfaces(List<String> interfaces) {
		List<String> ret = new ArrayList<String>();
		for (String iface : interfaces) {
			ret.add(getTransformedClassname(iface));
		}
		return ret;
	}

	private void transformVariables(List<LocalVariableNode> variables) {
		if (variables == null)
			return;

		for (LocalVariableNode variable : variables) {
			variable.desc = transformDescriptor(variable.desc);
		}
	}

	InsnList createExceptionOverrides() {
		InsnList ret = new InsnList();
		ret.add(new InsnNode(Opcodes.ATHROW));
		return ret;
	}

	private void transformMethod(MethodNode method, Map<String, LoadClassInfo> classesToLoad) {
		InsnList newList = new InsnList();
		for (int i = 0; i < method.instructions.size(); i++) {
			List<AbstractInsnNode> newInsns = transformInstruction(method.instructions.get(i), classesToLoad);
			for (AbstractInsnNode insn : newInsns) {
				newList.add(insn);
			}
		}

		if (method.tryCatchBlocks != null) {
			for (TryCatchBlockNode block : method.tryCatchBlocks) {
				if (block.type != null) {
					block.type = getTransformedClassname(block.type);
					newList.insert(block.handler, createExceptionOverrides());
				}
			}
		}

		method.instructions = newList;
		method.signature = null;
		transformVariables(method.localVariables);
		transformAnnotations(method.visibleAnnotations);
		// Skip constructors and special enum methods
		if (!isMethodException(classNode.name, method.name)) {
			method.name = layer.getPrefixFake() + method.name;
		}
		method.desc = transformDescriptor(method.desc);
	}

	private void transformField(FieldNode field) {
		field.desc = transformDescriptor(field.desc);
		field.name = layer.getPrefixFake() + field.name;
		transformAnnotations(field.visibleAnnotations);
	}

	public void transform(Map<String, LoadClassInfo> classesToLoad) {
		for (FieldNode field : classNode.fields) {
			transformField(field);
		}

		for (MethodNode method : classNode.methods) {
			transformMethod(method, classesToLoad);
		}

		transformAnnotations(classNode.visibleAnnotations);
		classNode.name = getTransformedClassname(classNode.name);
		classNode.superName = getTransformedClassname(classNode.superName);
		classNode.interfaces = transformInterfaces(classNode.interfaces);
		int posName = classNode.name.lastIndexOf('/') + 1;
		classNode.sourceFile = classNode.name.substring(posName) + ".java";
	}

	public byte[] getTransformedData() {
		try {
			ClassWriter classWriter = new CustomClassWriter(ClassWriter.COMPUTE_FRAMES);
			classNode.accept(classWriter);
			return classWriter.toByteArray();
		} catch (Exception e) {
			System.out.println("Error transforming: " + classNode.name);
			throw e;
		}
	}
}
