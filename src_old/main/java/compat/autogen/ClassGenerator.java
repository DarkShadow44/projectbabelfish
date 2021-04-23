package compat.autogen;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;

import compat.core.CompatibilityMod;
import compat.core.layer.CompatibilityLayer;

public class ClassGenerator {

	private final Class<?> classIface;
	private final String pathIface;
	private final Class<?> classMc;
	private final String pathMc;
	private final String descMc;
	private final String pathFake;
	private final String descFake;
	private final Class<?> classFake;
	private final String pathReal;
	private final String pathWrapper;

	private ClassGenerator(Class<?> classIface, String pathIface) throws Exception {
		this.classIface = classIface;
		this.pathIface = pathIface;
		this.pathReal = pathIface.replace("CompatI_", "CompatReal_");
		this.pathFake = pathIface.replace("CompatI_", "Compat_");
		this.pathWrapper = pathIface.replace("CompatI_", "CompatWrapper_");
		this.descFake = "L" + pathFake + ";";

		this.classFake = Class.forName(pathFake.replace("/", "."), false, CompatibilityMod.classLoader);

		Method methodGet = classIface.getMethod("get");
		this.classMc = methodGet.getReturnType();
		this.pathMc = classMc.getName().replace(".", "/");
		this.descMc = "L" + pathMc + ";";
	}

	private void generateLoadParams(InsnList instructions, Parameter[] params, int offset) {
		offset++; // Skip the "this" parameter
		for (Parameter param : params) {
			int opcode = Type.getType(param.getType()).getOpcode(Opcodes.ILOAD);
			instructions.add(new VarInsnNode(opcode, offset++));

			// Some types take two slots...
			if (opcode == Opcodes.DLOAD || opcode == Opcodes.LLOAD) {
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

	private MethodNode generateConstructor(Parameter[] params) {
		MethodNode method = new MethodNode();
		method.name = "<init>";
		method.access = Opcodes.ACC_PUBLIC;
		method.exceptions = new ArrayList<>();

		method.desc = "(" + descFake + makeParamDesc(params) + ")V";

		method.instructions = new InsnList();

		// this.thisFake = thisFake;
		method.instructions.add(new VarInsnNode(Opcodes.ALOAD, 0));
		method.instructions.add(new VarInsnNode(Opcodes.ALOAD, 1));
		method.instructions.add(new FieldInsnNode(Opcodes.PUTFIELD, pathReal, "thisFake", descFake));

		// this.inInit = true;
		method.instructions.add(new VarInsnNode(Opcodes.ALOAD, 0));
		method.instructions.add(new InsnNode(Opcodes.ICONST_1));
		method.instructions.add(new FieldInsnNode(Opcodes.PUTFIELD, pathReal, "inInit", "Z"));

		// super(...);
		method.instructions.add(new VarInsnNode(Opcodes.ALOAD, 0));
		generateLoadParams(method.instructions, params, 1);
		String superDesc = "(" + makeParamDesc(params) + ")V";
		method.instructions.add(new MethodInsnNode(Opcodes.INVOKESPECIAL, pathMc, "<init>", superDesc, false));

		// this.inInit = false;
		method.instructions.add(new VarInsnNode(Opcodes.ALOAD, 0));
		method.instructions.add(new InsnNode(Opcodes.ICONST_0));
		method.instructions.add(new FieldInsnNode(Opcodes.PUTFIELD, pathReal, "inInit", "Z"));

		method.instructions.add(new InsnNode(Opcodes.RETURN));

		return method;
	}

	private MethodNode generateConstructorWrapper() {
		MethodNode method = new MethodNode();
		method.name = "<init>";
		method.access = Opcodes.ACC_PUBLIC;
		method.exceptions = new ArrayList<>();

		method.desc = "(" + descMc + ")V";

		method.instructions = new InsnList();

		// this.original = original;
		method.instructions.add(new VarInsnNode(Opcodes.ALOAD, 0));
		method.instructions.add(new MethodInsnNode(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false));
		method.instructions.add(new VarInsnNode(Opcodes.ALOAD, 0));
		method.instructions.add(new VarInsnNode(Opcodes.ALOAD, 1));
		method.instructions.add(new FieldInsnNode(Opcodes.PUTFIELD, pathWrapper, "original", descMc));
		method.instructions.add(new InsnNode(Opcodes.RETURN));

		return method;
	}

	private MethodNode generateGet() {
		MethodNode method = new MethodNode();
		method.name = "get";
		method.access = Opcodes.ACC_PUBLIC;
		method.exceptions = new ArrayList<>();

		method.desc = "()" + descMc;

		method.instructions = new InsnList();
		method.instructions.add(new VarInsnNode(Opcodes.ALOAD, 0));
		method.instructions.add(new InsnNode(Opcodes.ARETURN));

		return method;
	}

	private MethodNode generateGetWrapper() {
		MethodNode method = new MethodNode();
		method.name = "get";
		method.access = Opcodes.ACC_PUBLIC;
		method.exceptions = new ArrayList<>();

		method.desc = "()" + descMc;

		method.instructions = new InsnList();
		method.instructions.add(new VarInsnNode(Opcodes.ALOAD, 0));
		method.instructions.add(new FieldInsnNode(Opcodes.GETFIELD, pathWrapper, "original", descMc));
		method.instructions.add(new InsnNode(Opcodes.ARETURN));

		return method;
	}

	private MethodNode generateGetFake(Class<?> type) {
		MethodNode method = new MethodNode();
		method.name = "getFake";
		method.access = Opcodes.ACC_PUBLIC;
		method.exceptions = new ArrayList<>();

		method.desc = "()" + Type.getDescriptor(type);

		method.instructions = new InsnList();
		method.instructions.add(new VarInsnNode(Opcodes.ALOAD, 0));
		method.instructions.add(new FieldInsnNode(Opcodes.GETFIELD, pathReal, "thisFake", descFake));
		method.instructions.add(new InsnNode(Opcodes.ARETURN));

		return method;
	}

	private MethodNode generateIsChild(boolean isChild) {
		MethodNode method = new MethodNode();
		method.name = "isChild";
		method.access = Opcodes.ACC_PUBLIC;
		method.exceptions = new ArrayList<>();

		method.desc = "()Z";

		method.instructions = new InsnList();
		if (isChild) {
			method.instructions.add(new InsnNode(Opcodes.ICONST_1));
		} else {
			method.instructions.add(new InsnNode(Opcodes.ICONST_0));
		}
		method.instructions.add(new InsnNode(Opcodes.IRETURN));

		return method;
	}

	private MethodNode generateSuper(Parameter[] params, String methodName, Class<?> returnType, boolean isWrapper) {
		MethodNode method = new MethodNode();
		method.name = methodName;
		method.access = Opcodes.ACC_PUBLIC;
		method.exceptions = new ArrayList<>();

		method.desc = "(" + makeParamDesc(params) + ")" + Type.getDescriptor(returnType);

		method.instructions = new InsnList();

		method.instructions.add(new VarInsnNode(Opcodes.ALOAD, 0));
		if (isWrapper) {
			method.instructions.add(new FieldInsnNode(Opcodes.GETFIELD, pathWrapper, "original", descMc));
		}

		generateLoadParams(method.instructions, params, 0);

		String superDesc = "(" + makeParamDesc(params) + ")" + Type.getDescriptor(returnType);
		String methodNameMc = methodName.substring(0, methodName.length() - "Super".length());

		if (isWrapper) {
			method.instructions.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, pathMc, methodNameMc, superDesc, false));
		} else {
			method.instructions.add(new MethodInsnNode(Opcodes.INVOKESPECIAL, pathMc, methodNameMc, superDesc, false));
		}

		generateReturn(method.instructions, returnType);

		return method;
	}

	private MethodNode generatePropertyGet(String methodName, Class<?> type, boolean isWrapper) {
		MethodNode method = new MethodNode();
		method.name = methodName;
		method.access = Opcodes.ACC_PUBLIC;
		method.exceptions = new ArrayList<>();

		method.desc = "()" + Type.getDescriptor(type);

		method.instructions = new InsnList();

		method.instructions.add(new VarInsnNode(Opcodes.ALOAD, 0));
		if (isWrapper) {
			method.instructions.add(new FieldInsnNode(Opcodes.GETFIELD, pathWrapper, "original", descMc));
		}

		String name = methodName.substring("get_".length());
		String desc = Type.getDescriptor(type);

		method.instructions.add(new FieldInsnNode(Opcodes.GETFIELD, pathMc, name, desc));
		generateReturn(method.instructions, type);

		return method;
	}

	private MethodNode generatePropertySet(String mcPath, String methodName, Class<?> type, boolean isWrapper) {
		MethodNode method = new MethodNode();
		method.name = methodName;
		method.access = Opcodes.ACC_PUBLIC;
		method.exceptions = new ArrayList<>();

		method.desc = "(" + Type.getDescriptor(type) + ")V";

		method.instructions = new InsnList();

		String name = methodName.substring("set_".length());
		String desc = Type.getDescriptor(type);

		method.instructions.add(new VarInsnNode(Opcodes.ALOAD, 0));
		if (isWrapper) {
			method.instructions.add(new FieldInsnNode(Opcodes.GETFIELD, pathWrapper, "original", descMc));
		}
		int opcode = Type.getType(type).getOpcode(Opcodes.ILOAD);
		method.instructions.add(new VarInsnNode(opcode, 1));

		method.instructions.add(new FieldInsnNode(Opcodes.PUTFIELD, mcPath, name, desc));
		method.instructions.add(new InsnNode(Opcodes.RETURN));

		return method;
	}

	private MethodNode generateWrapper(Parameter[] params, String methodName, Class<?> returnType, boolean skipDuringConstructor) {
		MethodNode method = new MethodNode();
		method.name = methodName;
		method.access = Opcodes.ACC_PUBLIC;
		method.exceptions = new ArrayList<>();

		method.desc = "(" + makeParamDesc(params) + ")" + Type.getDescriptor(returnType);

		String superDesc = "(" + makeParamDesc(params) + ")" + Type.getDescriptor(returnType);

		method.instructions = new InsnList();

		if (skipDuringConstructor) {
			LabelNode labelNoSkip = new LabelNode();
			method.instructions.add(new VarInsnNode(Opcodes.ALOAD, 0));
			method.instructions.add(new FieldInsnNode(Opcodes.GETFIELD, pathReal, "inInit", "Z"));
			method.instructions.add(new InsnNode(Opcodes.ICONST_0));
			method.instructions.add(new JumpInsnNode(Opcodes.IF_ICMPEQ, labelNoSkip));
			method.instructions.add(new VarInsnNode(Opcodes.ALOAD, 0));
			generateLoadParams(method.instructions, params, 0);
			method.instructions.add(new MethodInsnNode(Opcodes.INVOKESPECIAL, pathMc, methodName, superDesc, false));
			generateReturn(method.instructions, returnType);
			method.instructions.add(labelNoSkip);
		}

		method.instructions.add(new VarInsnNode(Opcodes.ALOAD, 0));
		method.instructions.add(new FieldInsnNode(Opcodes.GETFIELD, pathReal, "thisFake", descFake));
		generateLoadParams(method.instructions, params, 0);
		method.instructions.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, pathFake, methodName, superDesc, false));
		generateReturn(method.instructions, returnType);

		return method;
	}

	private void generateMethodsForIface(List<MethodNode> methods, boolean isWrapper) {
		for (Method method : classIface.getMethods()) {
			if (method.getName().equals("get")) {
				continue;
			}
			if (method.getName().equals("getFake")) {
				if (isWrapper) {
					continue;
				}
				methods.add(generateGetFake(method.getReturnType()));
				continue;
			}

			if (method.getName().equals("isChild")) {
				methods.add(generateIsChild(!isWrapper));
				continue;
			}

			if (method.getName().startsWith("get_")) {
				String name = method.getName().substring(4);
				if (!fieldExistsInClass(classMc, name, method.getReturnType())) {
					throw new RuntimeException("Can't find field \"" + name + "\" in class " + pathMc);
				}
				MethodNode methodCreated = generatePropertyGet(method.getName(), method.getReturnType(), isWrapper);
				methods.add(methodCreated);
				continue;
			}
			if (method.getName().startsWith("set_")) {
				String name = method.getName().substring(4);
				if (!fieldExistsInClass(classMc, name, method.getParameters()[0].getType())) {
					throw new RuntimeException("Can't find field \"" + name + "\" in class " + pathMc);
				}
				MethodNode methodCreated = generatePropertySet(pathMc, method.getName(), method.getParameters()[0].getType(), isWrapper);
				methods.add(methodCreated);
				continue;
			}
			if (!methodExistsInClass(classMc, method, true)) {
				throw new RuntimeException("Can't find method \"" + method.getName() + "\" in class " + pathMc);
			}
			MethodNode methodCreated = generateSuper(method.getParameters(), method.getName(), method.getReturnType(), isWrapper);
			methods.add(methodCreated);
		}
	}

	private boolean methodExistsAsCallback(Method methodSearch) {
		for (Method method : classFake.getDeclaredMethods()) {
			if (method.getAnnotation(Callback.class) != null) {
				if (methodsMatch(method, methodSearch, false)) {
					return true;
				}
			}
		}
		return false;
	}

	private void generateAbstractWrappers(List<MethodNode> methods) {
		for (Method method : classMc.getDeclaredMethods()) {
			if (Modifier.isAbstract(method.getModifiers()) && !methodExistsAsCallback(method)) {
				MethodNode methodCreated = generateWrapper(method.getParameters(), method.getName(), method.getReturnType(), false);
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

	private boolean methodExistsInClass(Class<?> clazz, Method methodSearch, boolean isSuper) {
		for (Method method : clazz.getDeclaredMethods()) {
			if (methodsMatch(method, methodSearch, isSuper))
				return true;
		}

		if (clazz.getSuperclass() != null) {
			if (methodExistsInClass(clazz.getSuperclass(), methodSearch, isSuper))
				return true;
		}

		for (Class<?> iface : clazz.getInterfaces()) {
			if (methodExistsInClass(iface, methodSearch, isSuper))
				return true;
		}

		return false;
	}

	private boolean fieldExistsInClass(Class<?> clazz, String name, Class<?> type) {
		for (Field field : clazz.getDeclaredFields()) {
			if (field.getName().equals(name) && field.getType() == type)
				return true;
		}

		if (clazz.getSuperclass() != null) {
			return fieldExistsInClass(clazz.getSuperclass(), name, type);
		}

		return false;
	}

	private void generateCallbacks(List<MethodNode> methods) {
		for (Method method : classFake.getMethods()) {
			Callback callback = method.getAnnotation(Callback.class);
			if (callback != null) {
				if (!methodExistsInClass(classMc, method, false)) {
					throw new RuntimeException("Can't find method \"" + method.getName() + "\" in class " + pathMc);
				}
				MethodNode methodCreated = generateWrapper(method.getParameters(), method.getName(), method.getReturnType(), callback.skipDuringConstructor());
				methods.add(methodCreated);
			}
		}
	}

	private void generateClassWrapper() throws Exception {
		ClassNode classNode = new ClassNode();
		classNode.access = Opcodes.ACC_PUBLIC;
		classNode.interfaces.add(pathIface);
		classNode.name = pathWrapper;
		classNode.superName = "java/lang/Object";
		classNode.version = 52;

		classNode.fields.add(new FieldNode(Opcodes.ACC_PRIVATE, "original", descMc, null, null));

		classNode.methods.add(generateGetWrapper());

		MethodNode method = generateConstructorWrapper();
		classNode.methods.add(method);

		generateMethodsForIface(classNode.methods, true);

		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
		classNode.accept(classWriter);
		byte[] data = classWriter.toByteArray();

		CompatibilityMod.classLoader.addClass(classNode.name.replace("/", "."), data);
	}

	private void getInterfacesToImplement(List<Class<?>> ifaces, Class<?> clazz) {
		Interface iface = clazz.getAnnotation(Interface.class);
		if (iface != null) {
			ifaces.add(iface.value());
		}

		for (Class<?> sup : clazz.getInterfaces()) {
			getInterfacesToImplement(ifaces, sup);
		}
	}

	public void generateClass() throws Exception {
		ClassNode classNode = new ClassNode();
		classNode.access = Opcodes.ACC_PUBLIC;
		classNode.interfaces.add(pathIface);
		classNode.name = pathReal;
		classNode.superName = pathMc;
		classNode.version = 52;

		classNode.fields.add(new FieldNode(Opcodes.ACC_PRIVATE, "thisFake", descFake, null, null));
		classNode.fields.add(new FieldNode(Opcodes.ACC_PRIVATE, "inInit", "Z", null, null));

		classNode.methods.add(generateGet());

		for (Constructor<?> constructor : classMc.getDeclaredConstructors()) {
			MethodNode method = generateConstructor(constructor.getParameters());
			classNode.methods.add(method);
		}

		generateMethodsForIface(classNode.methods, false);

		generateAbstractWrappers(classNode.methods);

		List<Class<?>> interfacesToImplement = new ArrayList<>();
		getInterfacesToImplement(interfacesToImplement, classIface);
		for (Class<?> clazzIface : interfacesToImplement) {
			classNode.interfaces.add(clazzIface.getName().replace(".", "/"));

			for (Method method : clazzIface.getMethods()) {
				MethodNode methodCreated = generateWrapper(method.getParameters(), method.getName(), method.getReturnType(), false);
				classNode.methods.add(methodCreated);
			}
		}

		generateCallbacks(classNode.methods);

		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
		classNode.accept(classWriter);
		byte[] data = classWriter.toByteArray();

		CompatibilityMod.classLoader.addClass(classNode.name.replace("/", "."), data);
	}

	private static void generateRealClasses() throws Exception {
		ClassPath classesPath = ClassPath.from(ClassGenerator.class.getClassLoader());
		String sandbox = CompatibilityLayer.pathSandbox.replace("/", ".");
		sandbox = sandbox.substring(0, sandbox.length() - 1);
		Set<ClassInfo> classes = new HashSet<>();

		if (CompatibilityMod.DUMP_CLASSES) {
			classes.addAll(classesPath.getTopLevelClassesRecursive(sandbox + ".net"));
			classes.addAll(classesPath.getTopLevelClassesRecursive(sandbox + ".io.netty"));
		} else
			classes = classesPath.getTopLevelClassesRecursive(sandbox);

		for (ClassInfo clazzInfo : classes) {
			String classFullName = clazzInfo.getName().replace(".", "/");
			String[] classNameSplit = classFullName.split("\\/");
			String className = classNameSplit[classNameSplit.length - 1];
			Class<?> clazz = Class.forName(clazzInfo.getName(), false, CompatibilityMod.classLoader);

			if (clazz.isInterface() && className.startsWith("CompatI_")) {
				ClassGenerator generator = new ClassGenerator(clazz, classFullName);
				generator.generateClassWrapper();
				generator.generateClass();
			}
		}
		PathAwareEntity
	}

	public static void tryGenerateRealClasses() {
		try {
			generateRealClasses();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
