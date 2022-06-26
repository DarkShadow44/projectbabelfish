package net.projectbabelfish.mappings;

import java.io.File;
import java.io.IOException;

import net.minecraftforge.srgutils.IMappingFile;
import net.minecraftforge.srgutils.IMappingFile.IClass;
import net.minecraftforge.srgutils.IMappingFile.IField;
import net.minecraftforge.srgutils.IMappingFile.IMethod;

public class MappingHandler {

	IMappingFile obf_to_intermediary;
	IMappingFile intermediary_to_obf;
	IMappingFile obf_to_srg;
	IMappingFile srg_to_obf;
	IMappingFile official_to_obf;
	IMappingFile obf_to_official;

	public MappingHandler() {

		try {
			obf_to_srg = IMappingFile.load(new File("/home/fabian/Programming/Minecraft/Mods/CompatibilityMod/mappings/joined.tsrg"));
			official_to_obf = IMappingFile.load(new File("/home/fabian/Programming/Minecraft/Mods/CompatibilityMod/mappings/client.txt"));
			obf_to_intermediary = IMappingFile.load(new File("/home/fabian/Programming/Minecraft/Mods/CompatibilityMod/mappings/1.18.2.tiny"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		intermediary_to_obf = obf_to_intermediary.reverse();
		obf_to_official = official_to_obf.reverse();
		srg_to_obf = obf_to_srg.reverse();
	}

	private IClass getObfClassForTarget(MappingTarget target, String className) {
		switch (target) {
		case Official:
			return official_to_obf.getClass(className);
		case SRG:
			return srg_to_obf.getClass(className);
		case Intermediary:
			return intermediary_to_obf.getClass(className);
		}
		return null;
	}

	private String getObfClassNameForTarget(MappingTarget target, String className) {
		return getObfClassForTarget(target, className).getMapped();
	}

	private IClass getClassForTarget(MappingTarget target, String obfClassName) {
		switch (target) {
		case Official:
			return obf_to_official.getClass(obfClassName);
		case SRG:
			return obf_to_srg.getClass(obfClassName);
		case Intermediary:
			return obf_to_intermediary.getClass(obfClassName);
		}
		return null;
	}

	private String getObfFieldNameForTarget(MappingTarget target, String className, String fieldName) {
		IClass clazz = getObfClassForTarget(target, className);
		return clazz.getField(fieldName).getMapped();
	}

	private MethodFieldInfo getObfMethodForTarget(MappingTarget target, String className, MethodFieldInfo methodInfo) {
		IClass clazz = getObfClassForTarget(target, className);
		IMethod method = clazz.getMethod(methodInfo.getName(), methodInfo.getDesc());
		return new MethodFieldInfo(method.getMapped(), method.getMappedDescriptor());
	}

	public String mapClassName(MappingTarget from, MappingTarget to, String className) {
		String classNameObf = getObfClassNameForTarget(from, className);

		IClass clazz = getClassForTarget(to, classNameObf);

		return clazz.getMapped();
	}

	public MethodFieldInfo mapField(MappingTarget from, MappingTarget to, String className, String fieldName) {
		String classNameObf = getObfClassNameForTarget(from, className);
		String fieldNameObf = getObfFieldNameForTarget(from, className, fieldName);

		IClass clazz = getClassForTarget(to, classNameObf);
		IField field = clazz.getField(fieldNameObf);
		return new MethodFieldInfo(field.getMapped(), field.getMappedDescriptor());
	}

	public MethodFieldInfo mapMethod(MappingTarget from, MappingTarget to, String className, String methodName, String methodDesc) {
		String classNameObf = getObfClassNameForTarget(from, className);
		MethodFieldInfo methodObf = getObfMethodForTarget(from, className, new MethodFieldInfo(methodName, methodDesc));

		IClass clazz = getClassForTarget(to, classNameObf);
		IMethod method = clazz.getMethod(methodObf.getName(), methodObf.getDesc());

		return new MethodFieldInfo(method.getMapped(), method.getMappedDescriptor());
	}

	public class MethodFieldInfo {
		private String name;
		private String desc;

		public MethodFieldInfo(String name, String desc) {
			this.name = name;
			this.desc = desc;
		}

		public String getName() {
			return name;
		}

		public String getDesc() {
			return desc;
		}
	}

}
