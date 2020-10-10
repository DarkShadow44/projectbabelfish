package de.darkshadow44.compatibility.core.loader;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InvokeDynamicInsnNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.LocalVariableNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.MultiANewArrayInsnNode;
import org.objectweb.asm.tree.TypeInsnNode;

public class CompatibilityClassTransformer {

	static final String prefixSandbox = "de/darkshadow44/compatibility/sandbox/v1_7_10/";
	static final String prefixCompat = "Compat_";
	static final String prefixGet = "get_";
	static final String prefixSet = "set_";
	ClassNode classNode;
	List<String> outDependencies;

	public CompatibilityClassTransformer(byte[] data) {
		ClassReader classReader = new ClassReader(data);
		classNode = new ClassNode();
		classReader.accept(classNode, ClassReader.SKIP_FRAMES);
	}

	public String getThisClass() {
		return classNode.name;
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

		return false;
	}

	public static String getPrefixedClassname(String name) {
		String[] names = name.replace('$', '_').split("\\/");
		names[names.length - 1] = prefixCompat + names[names.length - 1];
		return prefixSandbox + String.join("/", names);
	}

	private String getTransformedClassname(String name) {
		if (name.startsWith("[")) {
			return transformDescriptor(name);
		}
		if (!isClassException(name)) {
			return getPrefixedClassname(name);
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
				if (!isClassException(substr)) {
					outDependencies.add(getTransformedClassname(substr));
				}
				sb.append(getTransformedClassname(substr));

				sb.append(';');
				break;

			}
		}

		return sb.toString();
	}

	static boolean isMinecraftClass(String name) {
		if (name.startsWith("net/minecraft/") || name.startsWith("net/minecraftforce/") || name.startsWith("cpw/mods/fml/")) {
			return true;
		}
		return false;
	}

	private List<AbstractInsnNode> transformInstruction(AbstractInsnNode instruction) {
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
			if (!isMinecraftClass(field.owner)) {
				field.desc = transformDescriptor(field.desc);
				field.name = prefixCompat + field.name;
				field.owner = getTransformedClassname(field.owner);
			} else {
				ret.clear();
				String name = "";
				MethodInsnNode fieldMethod = null;
				String desc = transformDescriptor(field.desc);
				String owner = getTransformedClassname(field.owner);
				switch (opcode) {
				case Opcodes.GETSTATIC:
					name = prefixCompat + prefixGet + field.name;
					desc = "()" + desc;
					fieldMethod = new MethodInsnNode(Opcodes.INVOKESTATIC, owner, name, desc, false);
					break;
				case Opcodes.PUTSTATIC:
					name = prefixCompat + prefixSet + field.name;
					desc = "(" + desc + ")V";
					fieldMethod = new MethodInsnNode(Opcodes.INVOKESTATIC, owner, name, desc, false);
					break;
				case Opcodes.GETFIELD:
					name = prefixCompat + prefixGet + field.name;
					desc = "()" + desc;
					fieldMethod = new MethodInsnNode(Opcodes.INVOKEVIRTUAL, owner, name, desc, false);
					break;
				case Opcodes.PUTFIELD:
					name = prefixCompat + prefixSet + field.name;
					desc = "(" + desc + ")V";
					fieldMethod = new MethodInsnNode(Opcodes.INVOKEVIRTUAL, owner, name, desc, false);
				}
				ret.add(fieldMethod);
			}
			break;
		case Opcodes.INVOKEDYNAMIC:
			InvokeDynamicInsnNode methoddyn = (InvokeDynamicInsnNode) instruction;
			methoddyn.desc = transformDescriptor(methoddyn.desc);
			methoddyn.name = prefixCompat + methoddyn.name;
			break;
		case Opcodes.INVOKEINTERFACE:
		case Opcodes.INVOKESPECIAL:
		case Opcodes.INVOKESTATIC:
		case Opcodes.INVOKEVIRTUAL:
			MethodInsnNode method = (MethodInsnNode) instruction;
			if (!isClassException(method.owner)) {
				if (!method.name.equals("<init>") && !method.name.equals("<clinit>")) {
					method.name = prefixCompat + method.name;
				}
				method.owner = getTransformedClassname(method.owner);
				method.desc = transformDescriptor(method.desc);
			}
			if (method.owner.equals("java/lang/Class")) {
				if (method.name.equals("getConstructor") || method.name.equals("getDeclaredField")) {
					method.name = prefixCompat + method.name;

					method.setOpcode(Opcodes.INVOKESTATIC);
					method.owner = getPrefixedClassname(method.owner);
					method.desc = transformDescriptor(method.desc);
					method.desc = "(Ljava/lang/Class;" + method.desc.substring(1);
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

	private void transformMethod(MethodNode method) {
		InsnList newList = new InsnList();
		for (int i = 0; i < method.instructions.size(); i++) {

			List<AbstractInsnNode> newInsns = transformInstruction(method.instructions.get(i));
			for (AbstractInsnNode insn : newInsns) {
				newList.add(insn);
			}
		}
		method.instructions = newList;
		transformVariables(method.localVariables);
		transformAnnotations(method.visibleAnnotations);
		if (!method.name.equals("<init>") && !method.name.equals("<clinit>")) {
			method.name = prefixCompat + method.name;
		}
		method.desc = transformDescriptor(method.desc);
	}

	private void transformField(FieldNode field) {
		field.desc = transformDescriptor(field.desc);
		field.name = prefixCompat + field.name;
		transformAnnotations(field.visibleAnnotations);
	}

	public void transform() {
		outDependencies = new ArrayList<String>();
		for (MethodNode method : classNode.methods) {
			transformMethod(method);
		}
		for (FieldNode field : classNode.fields) {
			transformField(field);
		}
		transformAnnotations(classNode.visibleAnnotations);
		classNode.name = getTransformedClassname(classNode.name);
		classNode.superName = getTransformedClassname(classNode.superName);
		classNode.interfaces = transformInterfaces(classNode.interfaces);
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

	public List<String> getDependencies() {
		return outDependencies.stream().distinct().collect(Collectors.toList());
	}
}
