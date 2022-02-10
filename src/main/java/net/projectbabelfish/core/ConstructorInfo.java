package net.projectbabelfish.core;

import java.lang.reflect.Constructor;

import net.projectbabelfish.ProjectBabelfish;

public class ConstructorInfo {
	private final String className;

	public ConstructorInfo(String className) {
		this.className = className;
	}

	public Object tryConstruct() {
		try {
			Class<?> clazz = Class.forName(className, true, ProjectBabelfish.classLoader);
			Constructor<?> ctor = clazz.getConstructor();
			return ctor.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
