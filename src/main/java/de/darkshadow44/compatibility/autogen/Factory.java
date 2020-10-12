package de.darkshadow44.compatibility.autogen;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.darkshadow44.compatibility.core.CompatibilityMod;

public class Factory {

	public static enum CtorPos {
		POS1, POS2, POS3, POS4, POS5, POS6;
	}

	private static Map<String, List<Constructor<?>>> cache = new HashMap<>();

	private static boolean constructorMatches(Constructor<?> constructor, Object[] params) {
		Parameter[] parameters = constructor.getParameters();

		if (parameters.length != params.length)
			return false;

		for (int i = 0; i < params.length; i++) {
			if (params[i] != null && !parameters[i].getType().isAssignableFrom(params[i].getClass())) {
				return false;
			}
		}

		return true;
	}

	private static Constructor<?> findConstructor(Class<?> clazz, Object[] params) {
		for (Constructor<?> constructor : clazz.getConstructors()) {
			if (constructorMatches(constructor, params)) {
				return constructor;
			}
		}
		return null;
	}

	// TODO: Don't allow duplicate ctor pos
	@SuppressWarnings("unchecked")
	public static <T> T create(CtorPos pos, Object... params) {
		Class<?> classFake = params[0].getClass();
		String targetName = classFake.getName().replace("Compat_", "CompatReal_");

		try {
			Class<?> classReal = Class.forName(targetName, true, CompatibilityMod.classLoader);
			Constructor<?> constructor = findConstructor(classReal, params);
			if (constructor == null) {
				throw new RuntimeException("Can't find constructor!");
			}
			return (T) constructor.newInstance(params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
