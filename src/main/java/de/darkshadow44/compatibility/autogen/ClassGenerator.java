package de.darkshadow44.compatibility.autogen;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
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
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.VarInsnNode;

import com.google.common.collect.ImmutableSet;
import com.google.common.io.Files;
import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;

import de.darkshadow44.compatibility.core.CompatibilityMod;
import de.darkshadow44.compatibility.core.loader.CompatibilityClassTransformer;

public class ClassGenerator {

	private void generateLoadParams(InsnList instructions, Parameter[] params, int offset) {
		offset++; // Skip this parameter
		for (Parameter param : params) {
			int opcode = Type.getType(param.getType()).getOpcode(Opcodes.ILOAD);
			instructions.add(new VarInsnNode(opcode, offset++));
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

		// super(...);
		method.instructions.add(new VarInsnNode(Opcodes.ALOAD, 0));
		generateLoadParams(method.instructions, params, 1);
		String superDesc = "(" + makeParamDesc(params) + ")V";
		method.instructions.add(new MethodInsnNode(Opcodes.INVOKESPECIAL, mcPath, "<init>", superDesc, false));

		// this.thisFake = thisFake;
		method.instructions.add(new VarInsnNode(Opcodes.ALOAD, 0));
		method.instructions.add(new VarInsnNode(Opcodes.ALOAD, 1));
		method.instructions.add(new FieldInsnNode(Opcodes.PUTFIELD, realPath, "thisFake", thisFakeDesc));

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

	private void generateMethodsForIface(List<MethodNode> methods, Class<?> classIface, String realPath, String mcPath) {
		for (Method method : classIface.getMethods()) {
			if (method.getName().equals("get")) {
				continue;
			}
			MethodNode methodCreated = generateSuper(realPath, mcPath, method.getParameters(), method.getName(), method.getReturnType());
			methods.add(methodCreated);
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

		String thisFakeDesc = "L" + path + ifaceName.replace("CompatI_", "Compat_") + ";";
		classNode.fields.add(new FieldNode(Opcodes.ACC_PRIVATE, "thisFake", thisFakeDesc, null, null));

		String mcPath = classMc.getName().replace(".", "/");

		classNode.methods.add(generateGet(mcPath));

		for (Constructor<?> constructor : classMc.getConstructors()) {
			MethodNode method = generateConstructor(classNode.name, constructor.getParameters(), mcPath);
			classNode.methods.add(method);
		}

		generateMethodsForIface(classNode.methods, classIface, classNode.name, mcPath);

		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
		classNode.accept(classWriter);
		byte[] data = classWriter.toByteArray();

		int debug = 0;
		if (debug == 1) {
			Files.write(data, new File("/home/fabian/Ramdisk/" + className + ".class"));
		}

		CompatibilityMod.classLoader.addClass(classNode.name.replace("/", "."), data);
	}

	private void generateRealClasses() throws Exception {
		ClassPath classesPath = ClassPath.from(ClassGenerator.class.getClassLoader());
		String sandbox = CompatibilityClassTransformer.prefixSandbox.replace("/", ".");
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
