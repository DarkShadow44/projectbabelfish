package compat.sandbox.java.lang;

import compat.core.CompatibilityMod;
import compat.core.layer.CompatibilityLayer;

public class Compat_Class {

	public static Class<?> Compat_forName(String name) throws ClassNotFoundException {
		int lastDot = name.lastIndexOf(".");

		String path = name.substring(0, lastDot + 1);
		String className = name.substring(lastDot + 1);

		name = CompatibilityLayer.pathSandbox.replace("/", ".") + path + "Compat_" + className;
		return Class.forName(name, true, CompatibilityMod.classLoader);
	}
}
