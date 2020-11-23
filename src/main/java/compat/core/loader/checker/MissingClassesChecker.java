package compat.core.loader.checker;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.TypeInsnNode;

import compat.core.CompatibilityMod;
import compat.core.layer.CompatibilityLayer;
import compat.core.loader.CompatibilityClassTransformer;

public class MissingClassesChecker extends GenericChecker {

	public MissingClassesChecker(CompatibilityLayer layer) {
		super(layer, "missing classes");
	}

	private void checkInstruction(AbstractInsnNode instruction) {
		int opcode = instruction.getOpcode();

		switch (opcode) {
		case Opcodes.CHECKCAST:
		case Opcodes.ANEWARRAY:
		case Opcodes.INSTANCEOF:
		case Opcodes.NEW:
			TypeInsnNode type = (TypeInsnNode) instruction;
			testDesc(type.desc);
			break;
		case Opcodes.GETFIELD:
		case Opcodes.GETSTATIC:
		case Opcodes.PUTFIELD:
		case Opcodes.PUTSTATIC:
			FieldInsnNode field = (FieldInsnNode) instruction;
			testDesc(field.desc);
			testClass(field.owner);
			break;
		case Opcodes.INVOKEINTERFACE:
		case Opcodes.INVOKESPECIAL:
		case Opcodes.INVOKESTATIC:
		case Opcodes.INVOKEVIRTUAL:
			MethodInsnNode method = (MethodInsnNode) instruction;
			testClass(method.owner);
			testMethodDesc(method.desc);
			break;
		default:
			break;
		}
	}

	private void testMethodDesc(String desc) {
		Type[] types = Type.getArgumentTypes(desc);
		Type returnType = Type.getReturnType(desc);
		if (returnType.getSort() == Type.OBJECT) {
			testClass(returnType.getClassName());
		}

		for (Type type : types) {
			if (type.getSort() == Type.OBJECT) {
				testClass(type.getClassName());
			}
		}
	}

	private void testDesc(String desc) {
		Type types = Type.getType(desc);
		if (types.getSort() == Type.OBJECT) {
			testClass(types.getClassName());
		}
	}

	private void testClass(String name) {
		name = name.replace(".", "/");
		String nameCheck = name;
		if (nameCheck.startsWith(layer.getPathSandbox())) {
			nameCheck = nameCheck.substring(layer.getPathSandbox().length());
		}
		if (!CompatibilityClassTransformer.isMcClass(nameCheck)) {
			return;
		}
		try {
			Class.forName(name.replace("/", "."), false, CompatibilityMod.classLoader);
		} catch (Exception e) {
			missing.add(name);
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

}
