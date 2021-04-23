package compat.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class MethodInfo<T extends Annotation> {
	private final Object mod;
	private Method method;

	public MethodInfo(Object mod, Class<T> annotationClass, Class<?> eventClass) {
		this.mod = mod;
		for (Method method : mod.getClass().getMethods()) {
			if (method.getAnnotation(annotationClass) != null) {
				Parameter[] params = method.getParameters();
				String paramName = params[0].getParameterizedType().getTypeName().replace("$", "_");
				if (paramName.contains("cpw/")) {
					throw new RuntimeException("Err");
				}
				if (params.length == 1 && paramName.equals(eventClass.getTypeName())) {
					this.method = method;
				}
			}
		}
	}

	public void tryInvoke(Object event) {
		if (method == null)
			return;
		try {
			method.invoke(mod, event);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}