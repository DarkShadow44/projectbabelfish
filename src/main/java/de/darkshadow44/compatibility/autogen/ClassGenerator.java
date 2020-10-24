package de.darkshadow44.compatibility.autogen;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.JumpInsnNode;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.VarInsnNode;

import com.google.common.collect.ImmutableSet;
import com.google.common.io.Files;
import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;

import de.darkshadow44.compatibility.core.CompatibilityMod;
import de.darkshadow44.compatibility.core.layer.CompatibilityLayer;

public class ClassGenerator {

	private CompatibilityLayer layer;

	public ClassGenerator(CompatibilityLayer layer) {
		this.layer = layer;
	}

	private void generateLoadParams(InsnList instructions, Parameter[] params, int offset) {
		offset++; // Skip the "this" parameter
		for (Parameter param : params) {
			int opcode = Type.getType(param.getType()).getOpcode(Opcodes.ILOAD);
			instructions.add(new VarInsnNode(opcode, offset++));

			// Some types take two slots...
			if (opcode == Opcodes.DLOAD) {
				offset++;
			}
		}
	}

	private void generateReturn(InsnList instructions, Class<?> type) {
		int opcode = Type.getType(type).getOpcode(Opcodes.IRETURN);
		instructions.add(new InsnNode(opcode));
	}

	private String makeParamDesc(Parameter[] params) {
		String desc = "";
		for (Parameter param : params) {
			desc += Type.getDescriptor(param.getType());
		}
		return desc;
	}

	private MethodNode generateConstructor(String realPath, Parameter[] params, String mcPath) {
		String thisFakeDesc = "L" + realPath.replace("/CompatReal_", "/Compat_") + ";";

		MethodNode method = new MethodNode();
		method.name = "<init>";
		method.access = Opcodes.ACC_PUBLIC;
		method.exceptions = new ArrayList<>();

		method.desc = "(" + thisFakeDesc + makeParamDesc(params) + ")V";

		method.instructions = new InsnList();

		// this.thisFake = thisFake;
		method.instructions.add(new VarInsnNode(Opcodes.ALOAD, 0));
		method.instructions.add(new VarInsnNode(Opcodes.ALOAD, 1));
		method.instructions.add(new FieldInsnNode(Opcodes.PUTFIELD, realPath, "thisFake", thisFakeDesc));

		// this.inInit = true;
		method.instructions.add(new VarInsnNode(Opcodes.ALOAD, 0));
		method.instructions.add(new InsnNode(Opcodes.ICONST_1));
		method.instructions.add(new FieldInsnNode(Opcodes.PUTFIELD, realPath, "inInit", "Z"));

		// super(...);
		method.instructions.add(new VarInsnNode(Opcodes.ALOAD, 0));
		generateLoadParams(method.instructions, params, 1);
		String superDesc = "(" + makeParamDesc(params) + ")V";
		method.instructions.add(new MethodInsnNode(Opcodes.INVOKESPECIAL, mcPath, "<init>", superDesc, false));

		// this.inInit = false;
		method.instructions.add(new VarInsnNode(Opcodes.ALOAD, 0));
		method.instructions.add(new InsnNode(Opcodes.ICONST_0));
		method.instructions.add(new FieldInsnNode(Opcodes.PUTFIELD, realPath, "inInit", "Z"));

		method.instructions.add(new InsnNode(Opcodes.RETURN));

		return method;
	}

	private MethodNode generateGet(String mcPath) {
		MethodNode method = new MethodNode();
		method.name = "get";
		method.access = Opcodes.ACC_PUBLIC;
		method.exceptions = new ArrayList<>();

		method.desc = "()L" + mcPath + ";";

		method.instructions = new InsnList();
		method.instructions.add(new VarInsnNode(Opcodes.ALOAD, 0));
		method.instructions.add(new InsnNode(Opcodes.ARETURN));

		return method;
	}

	private MethodNode generateGetFake(String realPath, Class<?> type) {
		String thisFakeDesc = "L" + realPath.replace("/CompatReal_", "/Compat_") + ";";
		MethodNode method = new MethodNode();
		method.name = "getFake";
		method.access = Opcodes.ACC_PUBLIC;
		method.exceptions = new ArrayList<>();

		method.desc = "()" + Type.getDescriptor(type);

		method.instructions = new InsnList();
		method.instructions.add(new VarInsnNode(Opcodes.ALOAD, 0));
		method.instructions.add(new FieldInsnNode(Opcodes.GETFIELD, realPath, "thisFake", thisFakeDesc));
		method.instructions.add(new InsnNode(Opcodes.ARETURN));

		return method;
	}

	private MethodNode generateSuper(String realPath, String mcPath, Parameter[] params, String methodName, Class<?> returnType) {
		MethodNode method = new MethodNode();
		method.name = methodName;
		method.access = Opcodes.ACC_PUBLIC;
		method.exceptions = new ArrayList<>();

		method.desc = "(" + makeParamDesc(params) + ")" + Type.getDescriptor(returnType);

		method.instructions = new InsnList();

		method.instructions.add(new VarInsnNode(Opcodes.ALOAD, 0));
		generateLoadParams(method.instructions, params, 0);
		String superDesc = "(" + makeParamDesc(params) + ")" + Type.getDescriptor(returnType);

		String methodNameMc = methodName.substring(0, methodName.length() - "Super".length());

		method.instructions.add(new MethodInsnNode(Opcodes.INVOKESPECIAL, mcPath, methodNameMc, superDesc, false));
		generateReturn(method.instructions, returnType);

		return method;
	}

	private MethodNode generateGet(String mcPath, String methodName, Class<?> type) {
		MethodNode method = new MethodNode();
		method.name = methodName;
		method.access = Opcodes.ACC_PUBLIC;
		method.exceptions = new ArrayList<>();

		method.desc = "()" + Type.getDescriptor(type);

		method.instructions = new InsnList();

		method.instructions.add(new VarInsnNode(Opcodes.ALOAD, 0));

		String name = methodName.substring("get_".length());
		String desc = Type.getDescriptor(type);

		method.instructions.add(new FieldInsnNode(Opcodes.GETFIELD, mcPath, name, desc));
		generateReturn(method.instructions, type);

		return method;
	}

	private MethodNode generateSet(String mcPath, String methodName, Class<?> type) {
		MethodNode method = new MethodNode();
		method.name = methodName;
		method.access = Opcodes.ACC_PUBLIC;
		method.exceptions = new ArrayList<>();

		method.desc = "(" + Type.getDescriptor(type) + ")V";

		method.instructions = new InsnList();

		method.instructions.add(new VarInsnNode(Opcodes.ALOAD, 0));

		String name = methodName.substring("set_".length());
		String desc = Type.getDescriptor(type);

		method.instructions.add(new VarInsnNode(Opcodes.ALOAD, 0));
		int opcode = Type.getType(type).getOpcode(Opcodes.ILOAD);
		method.instructions.add(new VarInsnNode(opcode, 1));

		method.instructions.add(new FieldInsnNode(Opcodes.PUTFIELD, mcPath, name, desc));
		method.instructions.add(new InsnNode(Opcodes.RETURN));

		return method;
	}

	private MethodNode generateWrapper(String realPath, Parameter[] params, String methodName, Class<?> returnType, String mcPath, boolean skipDuringConstructor) {
		String thisFakeDesc = "L" + realPath.replace("/CompatReal_", "/Compat_") + ";";
		MethodNode method = new MethodNode();
		method.name = methodName;
		method.access = Opcodes.ACC_PUBLIC;
		method.exceptions = new ArrayList<>();

		method.desc = "(" + makeParamDesc(params) + ")" + Type.getDescriptor(returnType);

		String superDesc = "(" + makeParamDesc(params) + ")" + Type.getDescriptor(returnType);
		String containingClassName = realPath.replace("CompatReal_", "Compat_");

		method.instructions = new InsnList();

		if (skipDuringConstructor) {
			LabelNode labelNoSkip = new LabelNode();
			method.instructions.add(new VarInsnNode(Opcodes.ALOAD, 0));
			method.instructions.add(new FieldInsnNode(Opcodes.GETFIELD, realPath, "inInit", "Z"));
			method.instructions.add(new InsnNode(Opcodes.ICONST_0));
			method.instructions.add(new JumpInsnNode(Opcodes.IF_ICMPEQ, labelNoSkip));
			method.instructions.add(new VarInsnNode(Opcodes.ALOAD, 0));
			generateLoadParams(method.instructions, params, 0);
			method.instructions.add(new MethodInsnNode(Opcodes.INVOKESPECIAL, mcPath, methodName, superDesc, false));
			generateReturn(method.instructions, returnType);
			method.instructions.add(labelNoSkip);
		}

		method.instructions.add(new VarInsnNode(Opcodes.ALOAD, 0));
		method.instructions.add(new FieldInsnNode(Opcodes.GETFIELD, realPath, "thisFake", thisFakeDesc));
		generateLoadParams(method.instructions, params, 0);
		method.instructions.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, containingClassName, methodName, superDesc, false));
		generateReturn(method.instructions, returnType);

		return method;
	}

	private void generateMethodsForIface(List<MethodNode> methods, Class<?> classIface, String realPath, String mcPath, Class<?> classMc) {
		for (Method method : classIface.getMethods()) {
			if (method.getName().equals("get")) {
				continue;
			}
			if (method.getName().equals("getFake")) {
				methods.add(generateGetFake(realPath, method.getReturnType()));
				continue;
			}
			if (method.getName().startsWith("get_")) {
				MethodNode methodCreated = generateGet(mcPath, method.getName(), method.getReturnType());
				methods.add(methodCreated);
				continue;
			}
			if (method.getName().startsWith("set_")) {
				MethodNode methodCreated = generateSet(mcPath, method.getName(), method.getParameters()[0].getType());
				methods.add(methodCreated);
				continue;
			}
			if (!methodExistsInClass(classMc, method, true)) {
				throw new RuntimeException("Can't find method \"" + method.getName() + "\" in class " + mcPath);
			}
			MethodNode methodCreated = generateSuper(realPath, mcPath, method.getParameters(), method.getName(), method.getReturnType());
			methods.add(methodCreated);
		}
	}

	private void generateAbstractWrappers(List<MethodNode> methods, Class<?> classMc, String realPath) {
		for (Method method : classMc.getDeclaredMethods()) {
			if (Modifier.isAbstract(method.getModifiers())) {
				MethodNode methodCreated = generateWrapper(realPath, method.getParameters(), method.getName(), method.getReturnType(), null, false);
				methods.add(methodCreated);
			}
		}
	}

	private boolean methodsMatch(Method method, Method methodSearch, boolean isSuper) {
		String nameSearch = methodSearch.getName();
		if (isSuper) {
			nameSearch = nameSearch.substring(0, nameSearch.length() - "Super".length());
		}
		if (!method.getName().equals(nameSearch))
			return false;
		if (!method.getReturnType().equals(methodSearch.getReturnType()))
			return false;
		Parameter[] params1 = method.getParameters();
		Parameter[] params2 = methodSearch.getParameters();

		if (params1.length != params2.length)
			return false;

		for (int i = 0; i < params1.length; i++) {
			Parameter param1 = params1[i];
			Parameter param2 = params2[i];

			if (!param1.getType().equals(param2.getType()))
				return false;
		}

		return true;
	}

	private boolean methodExistsInClass(Class<?> classMc, Method methodSearch, boolean isSuper) {
		for (Method method : classMc.getDeclaredMethods()) {
			if (methodsMatch(method, methodSearch, isSuper))
				return true;
		}

		if (classMc.getSuperclass() != null) {
			return methodExistsInClass(classMc.getSuperclass(), methodSearch, isSuper);
		}

		return false;
	}

	private void generateCallbacks(List<MethodNode> methods, Class<?> classFake, String realPath, String mcPath, Class<?> classMc) {
		for (Method method : classFake.getMethods()) {
			Callback callback = method.getAnnotation(Callback.class);
			if (callback != null) {
				if (!methodExistsInClass(classMc, method, false)) {
					throw new RuntimeException("Can't find method \"" + method.getName() + "\" in class " + mcPath);
				}
				MethodNode methodCreated = generateWrapper(realPath, method.getParameters(), method.getName(), method.getReturnType(), mcPath, callback.skipDuringConstructor());
				methods.add(methodCreated);
			}
		}
	}

	private void generateClass(Class<?> classIface, String path, String ifaceName) throws Exception {
		Method methodGet = classIface.getMethod("get");
		Class<?> classMc = methodGet.getReturnType();

		ClassNode classNode = new ClassNode();
		classNode.access = Opcodes.ACC_PUBLIC;
		classNode.interfaces.add(path + ifaceName);
		String className = ifaceName.replace("CompatI_", "CompatReal_");
		classNode.name = path + className;
		classNode.superName = classMc.getName().replace(".", "/");
		classNode.version = 52;

		String fakePath = path + ifaceName.replace("CompatI_", "Compat_");
		String thisFakeDesc = "L" + fakePath + ";";
		classNode.fields.add(new FieldNode(Opcodes.ACC_PRIVATE, "thisFake", thisFakeDesc, null, null));
		classNode.fields.add(new FieldNode(Opcodes.ACC_PRIVATE, "inInit", "Z", null, null));

		String mcPath = classMc.getName().replace(".", "/");

		classNode.methods.add(generateGet(mcPath));

		for (Constructor<?> constructor : classMc.getDeclaredConstructors()) {
			MethodNode method = generateConstructor(classNode.name, constructor.getParameters(), mcPath);
			classNode.methods.add(method);
		}

		generateMethodsForIface(classNode.methods, classIface, classNode.name, mcPath, classMc);

		generateAbstractWrappers(classNode.methods, classMc, classNode.name);

		Class<?> classFake = Class.forName(fakePath.replace("/", "."));
		generateCallbacks(classNode.methods, classFake, classNode.name, mcPath, classMc);

		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
		classNode.accept(classWriter);
		byte[] data = classWriter.toByteArray();

		if (className.equals("")) {
			Files.write(data, new File("/home/fabian/Ramdisk/" + className + ".class"));
		}

		CompatibilityMod.classLoader.addClass(classNode.name.replace("/", "."), data);
	}

	private void generateRealClasses() throws Exception {
		ClassPath classesPath = ClassPath.from(ClassGenerator.class.getClassLoader());
		String sandbox = layer.getPathSandbox().replace("/", ".");
		sandbox = sandbox.substring(0, sandbox.length() - 1);
		ImmutableSet<ClassInfo> classes = classesPath.getTopLevelClassesRecursive(sandbox);

		for (ClassInfo clazzInfo : classes) {
			String classFullName = clazzInfo.getName().replace(".", "/");
			String[] classNameSplit = classFullName.split("\\/");
			String className = classNameSplit[classNameSplit.length - 1];
			String classPath = classFullName.substring(0, classFullName.length() - className.length());
			Class<?> clazz = Class.forName(clazzInfo.getName());

			if (clazz.isInterface() && className.startsWith("CompatI_")) {
				generateClass(clazz, classPath, className);
			}
		}
	}

	public void tryGenerateRealClasses() {
		try {
			generateRealClasses();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
