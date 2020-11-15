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

public class CalledMethodChecker {
	private final List<String> methods = new ArrayList<>();
	private final CompatibilityLayer layer;

	public CalledMethodChecker(CompatibilityLayer layer) {
		this.layer = layer;
	}

	private boolean methodExists(MethodInsnNode method) {
		String nameOwner = method.owner;
		if (nameOwner.startsWith(layer.getPathSandbox())) {
			nameOwner = nameOwner.substring(layer.getPathSandbox().length());
		}
		if (!CompatibilityClassTransformer.isMcClass(nameOwner)) {
			return true;
		}

		try {
			Class<?> clazz = Class.forName(method.owner.replace("/", "."), false, CompatibilityMod.classLoader);

			if (method.name.equals("<init>")) {
				for (Constructor<?> c : clazz.getConstructors()) {
					if (Type.getConstructorDescriptor(c).equals(method.desc)) {
						return true;
					}
				}
			} else {
				for (Method m : clazz.getMethods()) {
					if (m.getName().equals(method.name) && Type.getMethodDescriptor(m).equals(method.desc)) {
						return true;
					}
				}
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	private void checkInstruction(AbstractInsnNode instruction) {
		int opcode = instruction.getOpcode();

		switch (opcode) {
		case Opcodes.INVOKEINTERFACE:
		case Opcodes.INVOKESPECIAL:
		case Opcodes.INVOKESTATIC:
		case Opcodes.INVOKEVIRTUAL:
			MethodInsnNode method = (MethodInsnNode) instruction;
			if (!methodExists(method)) {
				String owner = method.owner.substring(method.owner.lastIndexOf("/") + 1);
				methods.add("Missing called method: " + owner + "." + method.name + method.desc);
			}
			break;
		default:
			break;
		}
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

	public void printWarning() {
		List<String> methodsDedup = methods.stream().distinct().sorted().collect(Collectors.toList());
		for (String method : methodsDedup) {
			System.out.println("Compatibility: " + method);
		}
	}
}
