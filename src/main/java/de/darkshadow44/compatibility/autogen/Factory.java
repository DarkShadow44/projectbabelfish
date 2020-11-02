package de.darkshadow44.compatibility.autogen;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.objectweb.asm.Type;

import de.darkshadow44.compatibility.core.CompatibilityMod;

public class Factory {

	public static enum CtorPos {
		POS1,
		POS2,
		POS3,
		POS4,
		POS5,
		POS6;
	}

	@SuppressWarnings("unused")
	private static Map<String, List<Constructor<?>>> cache = new HashMap<>();

	private static Class<?> boxPrimitive(Class<?> clazz) {
		if (!clazz.isPrimitive())
			return clazz;

		if (clazz == Boolean.TYPE)
			return Boolean.class;
		if (clazz == Integer.TYPE)
			return Integer.class;
		if (clazz == Short.TYPE)
			return Short.class;
		if (clazz == Long.TYPE)
			return Long.class;
		if (clazz == Byte.TYPE)
			return Byte.class;
		if (clazz == Character.TYPE)
			return Character.class;
		if (clazz == Float.TYPE)
			return Float.class;
		if (clazz == Double.TYPE)
			return Double.class;

		return clazz;
	}

	private static boolean constructorMatches(Constructor<?> constructor, Object[] params) {
		Parameter[] parameters = constructor.getParameters();

		if (parameters.length != params.length)
			return false;

		for (int i = 0; i < params.length; i++) {
			if (params[i] != null) {
				Class<?> c1 = parameters[i].getType();
				c1 = boxPrimitive(c1);
				Class<?> c2 = params[i].getClass();
				if (!c1.isAssignableFrom(c2)) {
					return false;
				}
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

	private static String makeParamDesc(Object[] params) {
		String desc = "";
		for (Object param : params) {
			desc += Type.getDescriptor(param.getClass());
		}
		return desc;
	}

	// TODO: Don't allow duplicate ctor pos
	@SuppressWarnings("unchecked")
	public static <T> T create(CtorPos pos, Class<?> classIface, Object... params) {
		if (!classIface.getName().contains(".CompatI_")) {
			throw new RuntimeException("Not an interface: " + classIface.getName());
		}
		String targetName = classIface.getName().replace("CompatI_", "CompatReal_");

		try {
			Class<?> classReal = Class.forName(targetName, true, CompatibilityMod.classLoader);
			Constructor<?> constructor = findConstructor(classReal, params);
			if (constructor == null) {
				throw new RuntimeException("Can't find constructor! desc: " + makeParamDesc(params));
			}
			return (T) constructor.newInstance(params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T createWrapper(Class<?> classIface, Object param) {
		if (!classIface.getName().contains(".CompatI_")) {
			throw new RuntimeException("Not an interface: " + classIface.getName());
		}
		String targetName = classIface.getName().replace("CompatI_", "CompatWrapper_");

		try {
			Class<?> classReal = Class.forName(targetName, true, CompatibilityMod.classLoader);
			Constructor<?> constructor = findConstructor(classReal, new Object[] { param });
			if (constructor == null) {
				throw new RuntimeException("Can't find constructor! desc: " + param);
			}
			return (T) constructor.newInstance(param);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
