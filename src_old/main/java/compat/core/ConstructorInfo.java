package compat.core;

import java.lang.reflect.Constructor;

public class ConstructorInfo {
	private final String className;

	public ConstructorInfo(String className) {
		this.className = className;
	}

	public Object tryConstruct() {
		try {
			Class<?> clazz = Class.forName(className, true, CompatibilityMod.classLoader);
			Constructor<?> ctor = clazz.getConstructor();
			return ctor.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
