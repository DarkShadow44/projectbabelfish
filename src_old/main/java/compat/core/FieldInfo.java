package compat.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class FieldInfo<T extends Annotation> {
	private final Object mod;
	private T annotation;
	private Field field;

	public FieldInfo(Object mod, Class<T> annotationClass) {
		this.mod = mod;
		for (Field field : mod.getClass().getFields()) {
			T annotation = field.getAnnotation(annotationClass);
			if (annotation != null) {
				this.field = field;
				this.annotation = annotation;
			}
		}
	}

	public void trySetValue(Object value) {
		if (field != null) {
			try {
				field.set(mod, value);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	public T getAnnotation() {
		return annotation;
	}

}