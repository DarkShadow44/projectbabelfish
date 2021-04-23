package compat.sandbox.java.lang;

import compat.core.CompatibilityMod;
import compat.core.layer.CompatibilityLayer;
import compat.core.loader.CompatibilityClassTransformer;
import compat.sandbox.java.lang.reflect.Compat_Field;

public class Compat_Class {

	private static String getTarget(String name) {
		if (CompatibilityClassTransformer.isClassException(name))
			return name;

		int lastDot = name.lastIndexOf(".");

		String path = name.substring(0, lastDot + 1);
		String className = name.substring(lastDot + 1);

		if (CompatibilityClassTransformer.isMcClass(className))
			return CompatibilityLayer.pathSandbox.replace("/", ".") + path + "Compat_" + className;
		else
			return CompatibilityLayer.pathSandbox.replace("/", ".") + path + className;
	}

	public static Class<?> Compat_forName(String name) throws ClassNotFoundException {
		String target = getTarget(name);

		return Class.forName(target, true, CompatibilityMod.classLoader);
	}

	public static Compat_Field Compat_getField(Class<?> clazz, String name) throws NoSuchFieldException, SecurityException {
		return new Compat_Field(clazz.getField(name));
	}
}
