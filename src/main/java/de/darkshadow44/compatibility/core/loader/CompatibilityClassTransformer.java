package de.darkshadow44.compatibility.core.loader;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.InvokeDynamicInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.MultiANewArrayInsnNode;
import org.objectweb.asm.tree.TypeInsnNode;

public class CompatibilityClassTransformer {

	ClassNode classNode;
	List<String> outDependencies;

	public CompatibilityClassTransformer(byte[] data) {
		ClassReader classReader = new ClassReader(data);
		classNode = new ClassNode();
		classReader.accept(classNode, ClassReader.SKIP_FRAMES);
	}

	public String getThisClass() {
		return getTransformedClassname(classNode.name);
	}

	public String getSuperClass() {
		return getTransformedClassname(classNode.superName);
	}

	public String[] getInterfaces() {
		String[] interfaces = classNode.interfaces.toArray(new String[0]);
		for (int i = 0; i < interfaces.length; i++) {
			interfaces[i] = getTransformedClassname(interfaces[i]);
		}
		return interfaces;
	}

	public boolean isClassException(String name) {
		if (name.startsWith("java/"))
			return true;

		if (name.startsWith("javax/"))
			return true;

		if (name.startsWith("org/lwjgl/"))
			return true;

		return false;
	}

	private String getTransformedClassname(String name) {
		String prefix = "de/darkshadow44/compatibility/sandbox/v1_7_10/";
		if (!isClassException(name)) {
			String[] names = name.split("\\/");
			names[names.length - 1] = "compat_" + names[names.length - 1];
			return prefix + String.join("/", names);
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

	private void transformInstruction(AbstractInsnNode instruction) {
		switch (instruction.getOpcode()) {
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
			field.desc = transformDescriptor(field.desc);
			field.name = "compat_" + field.name;
			field.owner = getTransformedClassname(field.owner);
			break;
		case Opcodes.INVOKEDYNAMIC:
			InvokeDynamicInsnNode methoddyn = (InvokeDynamicInsnNode) instruction;
			methoddyn.desc = transformDescriptor(methoddyn.desc);
			methoddyn.name = "compat_" + methoddyn.name;
			break;
		case Opcodes.INVOKEINTERFACE:
		case Opcodes.INVOKESPECIAL:
		case Opcodes.INVOKESTATIC:
		case Opcodes.INVOKEVIRTUAL:
			MethodInsnNode method = (MethodInsnNode) instruction;
			method.name = "compat_" + method.name;
			method.owner = getTransformedClassname(method.owner);
			method.desc = transformDescriptor(method.desc);
			break;
		case Opcodes.MULTIANEWARRAY:
			MultiANewArrayInsnNode multiarray = (MultiANewArrayInsnNode) instruction;
			multiarray.desc = transformDescriptor(multiarray.desc);
		default:
			break;
		}
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

	private void transformMethod(MethodNode method) {
		for (int i = 0; i < method.instructions.size(); i++) {
			transformInstruction(method.instructions.get(i));
		}
		transformAnnotations(method.visibleAnnotations);
		method.name = "compat_" + method.name;
	}

	public byte[] transform() {
		outDependencies = new ArrayList<String>();
		for (MethodNode method : classNode.methods) {
			transformMethod(method);
		}
		transformAnnotations(classNode.visibleAnnotations);
		classNode.name = getTransformedClassname(classNode.name);
		classNode.superName = getTransformedClassname(classNode.name);
		classNode.interfaces = transformInterfaces(classNode.interfaces);

		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
		classNode.accept(classWriter);
		return classWriter.toByteArray();
	}

	public List<String> getDependencies() {
		return outDependencies.stream().distinct().collect(Collectors.toList());
	}
}
