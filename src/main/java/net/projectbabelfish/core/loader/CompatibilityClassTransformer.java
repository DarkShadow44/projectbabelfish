package net.projectbabelfish.core.loader;

import java.lang.reflect.Method;
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

import net.projectbabelfish.ProjectBabelfish;
import net.projectbabelfish.core.CompatibilityLayer;
import net.projectbabelfish.core.Version;
import net.projectbabelfish.core.VersionInfo;

public class CompatibilityClassTransformer {
	ClassNode classNode;
	List<String> fields = new ArrayList<>();
	private final CompatibilityLayer layer;

	private List<String> missingClasses = new ArrayList<String>();

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

	public static boolean isClassException(String name) {
		if (name.startsWith("java/")) {
			if (name.startsWith("java/lang/reflect/")) {
				return false; // We must handle reflection attempts and redirect accordingly...
			}
			return true;
		}

		if (name.startsWith("scala/"))
			return true;

		if (name.startsWith("javax/"))
			return true;

		if (name.startsWith("org/lwjgl/")) {
			if (name.startsWith("org/lwjgl/opengl/GL")) {
				return false;
			}
			return true;
		}

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
		name = name.replace(".", "/").replace("Compat_", "");

		if (name.startsWith("cpw/mods/fml/"))
			return true;

		if (name.startsWith("net/minecraft/"))
			return true;

		if (name.startsWith("net/minecraftforge/"))
			return true;

		if (name.startsWith("io/netty/"))
			return true;

		if (name.startsWith("java/lang/reflect/"))
			return true;

		if (name.equals("java/lang/Class"))
			return true;

		if (name.startsWith("org/lwjgl/opengl/GL"))
			return true;

		return false;
	}

	private static boolean isHookedClassMethod(String name) {
		List<String> names = new ArrayList<>();
		names.add("getConstructor");
		names.add("getDeclaredField");
		names.add("getDeclaredFields");
		names.add("forName");
		names.add("getField");

		return names.contains(name);
	}

	private boolean isMethodException(Map<String, LoadClassInfo> classesToLoad, String targetClassName, String name, String desc) {
		// Skip constructors
		if (name.equals("<init>") || name.equals("<clinit>"))
			return true;

		// Skip special enum methods
		if (name.equals("values") || name.equals("valueOf") || name.equals("clone"))
			return true;

		if (name.equals("ordinal") || name.equals("name") || name.equals("hashCode") || name.equals("equals")) {
			if (!isMcClass(targetClassName)) { // TODO hashCode can go to Object, which means we don't know if we should
												// transform... e.g. Interfaces
				return true;
			}
			return false;
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

		if (isMcClass(targetClassName)) {
			return false;
		}

		if (isMethodMc(classesToLoad, targetClassName, name, desc))
			return false;

		return true;
	}

	private Handle transformHandle(Map<String, LoadClassInfo> classesToLoad, Handle handle) {
		String desc = transformDescriptor(handle.getDesc());
		String owner = getTransformedClassname(handle.getOwner());
		String name = handle.getName();
		if (!isMethodException(classesToLoad, handle.getOwner(), name, handle.getDesc()) && !isClassException(handle.getOwner())) {
			name = layer.getPrefixFake() + name;
		}
		return new Handle(handle.getTag(), owner, name, desc, handle.isInterface());
	}

	private void getMcParentsForCompat(List<Class<?>> parents, Class<?> clazz) {
		parents.add(clazz);

		if (clazz.getSuperclass() != null) {
			getMcParentsForCompat(parents, clazz.getSuperclass());
		}
		if (!clazz.isInterface()) {
			for (Class<?> parent : clazz.getInterfaces()) {
				getMcParentsForCompat(parents, parent);
			}
		}
	}

	private void getMcParentsForMod(List<Class<?>> parents, Map<String, LoadClassInfo> classesToLoad, String className) {
		if (isMcClass(className)) {
			String parentPathCompat = (getTransformedClassname(className)).replace("/", ".");
			Class<?> classParentCompat = null;
			Class<?> classParentMc = null;

			try {
				classParentCompat = Class.forName(parentPathCompat, false, ProjectBabelfish.classLoader);
			} catch (Exception e) {
				missingClasses.add("Compat Class: " + parentPathCompat);
				return;
			}

			if (classParentCompat.isInterface()) {
				// For interfaces, get MC class type from className
				String parentPathMc = className.replace("/", ".");
				try {
					classParentMc = Class.forName(parentPathMc, false, ProjectBabelfish.classLoader);
				} catch (ClassNotFoundException e) {
					return; // Some classes don't exist in MC/forge today, this is okay.
				}
			} else {
				// For classes, get MC class type from Compat_XXX.getReal() return type
				// For example, when BlockFire gets renamed into FireBlock, it still works
				try {
					Method methodGetReal = classParentCompat.getDeclaredMethod("getReal");
					classParentMc = methodGetReal.getReturnType();
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}

			getMcParentsForCompat(parents, classParentMc);
			return;
		}

		if (className.isEmpty() || isClassException(className))
			return;

		LoadClassInfo classInfo = classesToLoad.get(className);
		if (classInfo == null) {
			missingClasses.add("Mod class: " + className);
			return;
		}

		for (String parent : classInfo.dependenciesHard) {
			getMcParentsForMod(parents, classesToLoad, parent);
		}
	}

	private void getCompatParentsForCompat(List<Class<?>> parents, Class<?> clazz) {
		parents.add(clazz);

		if (clazz.getSuperclass() != null) {
			getCompatParentsForCompat(parents, clazz.getSuperclass());
		}
		if (!clazz.isInterface()) {
			for (Class<?> parent : clazz.getInterfaces()) {
				getCompatParentsForCompat(parents, parent);
			}
		}
	}

	private void getCompatParentsForMod(List<Class<?>> parents, Map<String, LoadClassInfo> classesToLoad, String className) {
		if (isMcClass(className)) {
			String parentPath = (getTransformedClassname(className)).replace("/", ".");
			Class<?> classParent = null;
			try {
				classParent = Class.forName(parentPath, false, ProjectBabelfish.classLoader);
			} catch (ClassNotFoundException e) {
				missingClasses.add("Compat Class: " + parentPath);
				return;
			}
			getCompatParentsForCompat(parents, classParent);
			return;
		}

		if (className.isEmpty() || isClassException(className))
			return;

		LoadClassInfo classInfo = classesToLoad.get(className);
		if (classInfo == null) {
			missingClasses.add("Mod class: " + className);
			return;
		}

		for (String parent : classInfo.dependenciesHard) {
			getCompatParentsForMod(parents, classesToLoad, parent);
		}
	}

	private boolean isMethodMc(Map<String, LoadClassInfo> classesToLoad, String className, String methodName, String methodDesc) {
		if (methodName.startsWith("func_"))
			return true;

		List<Class<?>> mcClasses = new ArrayList<>();
		getMcParentsForMod(mcClasses, classesToLoad, className);

		List<Class<?>> compatClasses = new ArrayList<>();
		getCompatParentsForMod(compatClasses, classesToLoad, className);

		for (Class<?> parent : compatClasses) {
			for (Method method : parent.getDeclaredMethods()) {
				String methodDescTransformed = transformDescriptor(methodDesc);
				if (method.getName().equals(layer.getPrefixFake() + methodName) && Type.getMethodDescriptor(method).equals(methodDescTransformed))
					return true;
			}
		}

		for (Class<?> parent : mcClasses) {
			for (Method method : parent.getDeclaredMethods()) {
				// Don't check descriptor here, need to be careful! //&&
				// Type.getMethodDescriptor(method).equals(methodDesc)
				if (method.getName().equals(methodName))
					return true;
			}
		}

		return false;
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

			if (!isMethodException(classesToLoad, "", methoddyn.name, methoddyn.desc)) {
				methoddyn.name = layer.getPrefixFake() + methoddyn.name;
			}

			methoddyn.bsm = transformHandle(classesToLoad, methoddyn.bsm);
			for (int i = 0; i < methoddyn.bsmArgs.length; i++) {
				Object arg = methoddyn.bsmArgs[i];
				if (arg instanceof Handle) {
					methoddyn.bsmArgs[i] = transformHandle(classesToLoad, (Handle) arg);
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
				if (!isMethodException(classesToLoad, method.owner, method.name, method.desc)) {
					method.name = layer.getRedirectedMethod(layer.getPrefixFake() + method.name, method.desc);
				}
				method.owner = getTransformedClassname(method.owner);
				method.desc = transformDescriptor(method.desc);
			}
			if (method.owner.equals("java/lang/Class")) {
				if (isHookedClassMethod(method.name)) {
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
		if (!isMethodException(classesToLoad, classNode.name, method.name, method.desc)) {
			method.name = layer.getPrefixFake() + method.name;
		}
		method.desc = transformDescriptor(method.desc);
	}

	private void transformField(FieldNode field) {
		field.desc = transformDescriptor(field.desc);
		transformAnnotations(field.visibleAnnotations);
	}

	private void addVersionAnnotation() {
		AnnotationNode versionAnnotation = new AnnotationNode(Type.getDescriptor(VersionInfo.class));
		versionAnnotation.values = new ArrayList<>();
		versionAnnotation.values.add("value");
		String[] values = new String[2];
		values[0] = Type.getDescriptor(Version.class);
		values[1] = layer.getVersion().name();
		versionAnnotation.values.add(values);
		if (classNode.visibleAnnotations == null) {
			classNode.visibleAnnotations = new ArrayList<>();
		}
		classNode.visibleAnnotations.add(versionAnnotation);
	}

	public void transform(Map<String, LoadClassInfo> classesToLoad) {

		if (missingClasses.size() > 0) {
			StringBuilder sb = new StringBuilder();
			sb.append("\n########## Compatibility: Found " + missingClasses.size() + " missing classes .\n");

			for (String method : missingClasses) {
				sb.append("\t" + method + "\n");
			}
			throw new RuntimeException(sb.toString());
		}

		for (FieldNode field : classNode.fields) {
			transformField(field);
		}

		for (MethodNode method : classNode.methods) {
			transformMethod(method, classesToLoad);
		}

		transformAnnotations(classNode.visibleAnnotations);
		addVersionAnnotation();
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
}
