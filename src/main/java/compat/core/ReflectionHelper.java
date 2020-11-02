package compat.core;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionHelper {

	public static void setPrivateField(Object instance, String fieldName, Object value) {
		setPrivateField(instance.getClass(), instance, fieldName, value);
	}

	public static void setPrivateField(Class<?> c, String fieldName, Object value) {
		setPrivateField(c, null, fieldName, value);
	}

	public static void setPrivateField(Class<?> c, Object instance, String fieldName, Object value) {
		try {
			Field field = c.getDeclaredField(fieldName);
			field.setAccessible(true);
			field.set(instance, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Object getPrivateField(Object instance, String fieldName) {
		return getPrivateField(instance.getClass(), instance, fieldName);
	}

	public static Object getPrivateField(Class<?> c, String fieldName) {
		return getPrivateField(c, null, fieldName);
	}

	public static Object getPrivateField(Class<?> c, Object instance, String fieldName) {
		try {
			Field field = c.getDeclaredField(fieldName);
			field.setAccessible(true);
			return field.get(instance);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Object callPrivateMethod(Class<?> c, Object instance, String methodName, Object[] parameter, Class<?>[] classParameters) {
		try {
			Method method = c.getDeclaredMethod(methodName, classParameters);
			method.setAccessible(true);
			return method.invoke(instance, parameter);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
