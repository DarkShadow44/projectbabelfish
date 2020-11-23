package compat.core.loader.checker;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;

import compat.core.CompatibilityMod;
import compat.core.layer.CompatibilityLayer;
import compat.core.loader.CompatibilityClassTransformer;

public class CalledMethodChecker extends GenericChecker {

	private final List<String> missingClasses = new ArrayList<>();

	public CalledMethodChecker(CompatibilityLayer layer) {
		super(layer, "called methods");
	}

	private void checkInstruction(AbstractInsnNode instruction) {
		int opcode = instruction.getOpcode();

		switch (opcode) {
		case Opcodes.INVOKEINTERFACE:
		case Opcodes.INVOKESPECIAL:
		case Opcodes.INVOKESTATIC:
		case Opcodes.INVOKEVIRTUAL:
			MethodInsnNode method = (MethodInsnNode) instruction;
			if (!methodExistsInCompat(method)) {
				String owner = method.owner.substring(method.owner.lastIndexOf("/") + 1);
				methods.add("Missing called method: " + owner + "." + method.name + method.desc);
			}
			break;
		default:
			break;
		}
	}

	private boolean methodExistsInCompat(MethodInsnNode methodSearch) {
		String nameOwner = methodSearch.owner;
		if (nameOwner.startsWith(layer.getPathSandbox())) {
			nameOwner = nameOwner.substring(layer.getPathSandbox().length());
		}
		if (!CompatibilityClassTransformer.isMcClass(nameOwner)) {
			return true;
		}

		try {
			Class<?> clazz = Class.forName(methodSearch.owner.replace("/", "."), false, CompatibilityMod.classLoader);

			if (methodSearch.name.equals("<init>")) {
				for (Constructor<?> c : clazz.getConstructors()) {
					if (Type.getConstructorDescriptor(c).equals(methodSearch.desc)) {
						return true;
					}
				}
			} else {
				for (Method method : clazz.getMethods()) {
					if (method.getName().equals(methodSearch.name) && Type.getMethodDescriptor(method).equals(methodSearch.desc)) {
						return true;
					}
				}
			}
		} catch (Exception e) {
			missingClasses.add(methodSearch.owner);
			return false;
		}
		return false;
	}

	public void checkClass(byte[] classMod) {
		ClassReader classReader = new ClassReader(classMod);
		ClassNode node = new ClassNode();
		classReader.accept(node, ClassReader.SKIP_FRAMES);

		for (MethodNode method : node.methods) {
			for (int i = 0; i < method.instructions.size(); i++) {
				checkInstruction(method.instructions.get(i));
			}
		}
	}

	public void checkMissingClasses() {
		if (missingClasses.size() > 0) {
			List<String> classesDedup = missingClasses.stream().distinct().sorted().collect(Collectors.toList());
			StringBuilder sb = new StringBuilder();
			sb.append("\n########## Compatibility: Found " + missingClasses.size() + " missing classes.\n");

			for (String method : classesDedup) {
				sb.append("\t" + method + "\n");
			}
			throw new RuntimeException(sb.toString());
		}
	}

}
