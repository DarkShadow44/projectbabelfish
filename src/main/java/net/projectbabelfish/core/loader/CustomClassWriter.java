package net.projectbabelfish.core.loader;

import org.objectweb.asm.ClassWriter;

public class CustomClassWriter extends ClassWriter {

	public CustomClassWriter(int flags) {
		super(flags);
	}

	@Override
	protected String getCommonSuperClass(final String type1, final String type2) {
		Class<?> c, d;
		ClassLoader classLoader = getClass().getClassLoader();
		try {
			c = Class.forName(type1.replace('/', '.'), false, classLoader);
			d = Class.forName(type2.replace('/', '.'), false, classLoader);
		} catch (Exception e) {
			return "java/lang/Object";
		}
		if (c.isAssignableFrom(d)) {
			return type1;
		}
		if (d.isAssignableFrom(c)) {
			return type2;
		}
		if (c.isInterface() || d.isInterface()) {
			return "java/lang/Object";
		} else {
			do {
				c = c.getSuperclass();
			} while (!c.isAssignableFrom(d));
			return c.getName().replace('.', '/');
		}
	}
}
