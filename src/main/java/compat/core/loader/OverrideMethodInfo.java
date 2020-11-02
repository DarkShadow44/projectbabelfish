package compat.core.loader;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.objectweb.asm.Type;

import compat.autogen.HasCallback;
import compat.core.CompatibilityMod;
import compat.core.layer.CompatibilityLayer;

public class OverrideMethodInfo {
	public class MethodInfo {
		public final String name;
		public final String desc;
		public final boolean hasCallback;

		public MethodInfo(String name, String desc, boolean hasCallback) {
			this.name = name;
			this.desc = desc;
			this.hasCallback = hasCallback;
		}
	}

	private final List<MethodInfo> methods = new ArrayList<MethodInfo>();
	private final CompatibilityLayer layer;

	public OverrideMethodInfo(CompatibilityLayer layer) {
		this.layer = layer;
	}

	public boolean isModClass(Class<?> c) {
		if (c == null || c.getName().startsWith("java.") || c.getName().startsWith("com.google."))
			return false;

		if (c.getName().length() < layer.getPathSandbox().length()) {
			throw new RuntimeException("Unexpected class : " + c.getName());
		}
		String name = c.getName().substring(layer.getPathSandbox().length());
		return !CompatibilityClassTransformer.isMcClass(name);
	}

	public void getMethodsForClassUnconditionally(Class<?> clazz, boolean checkCallback) {
		for (Method method : clazz.getDeclaredMethods()) {
			boolean hasCallback = !checkCallback;
			if (checkCallback) {
				hasCallback = method.getAnnotation(HasCallback.class) != null;
			}

			MethodInfo info = new MethodInfo(method.getName(), method.getName() + Type.getMethodDescriptor(method), hasCallback);
			methods.add(info);
		}
	}

	public void getMethodsForClassAndParents(Class<?> clazz, boolean checkCallback) {
		if (clazz == null || clazz == Object.class)
			return;

		getMethodsForClassUnconditionally(clazz, checkCallback);

		if (isModClass(clazz) && !isModClass(clazz.getSuperclass()))
			return;
		getMethodsForClassAndParents(clazz.getSuperclass(), checkCallback);
	}

	public void addFromImplementedInterfaces(Class<?> clazz) {
		for (Class<?> classIface : clazz.getInterfaces()) {
			if (!isModClass(classIface)) {
				getMethodsForClassUnconditionally(classIface, false);
			}
		}
	}

	public void getMethodsForMc(Class<?> parentCompat) {
		if (!parentCompat.getName().startsWith("java.lang.")) {
			String nameMc = parentCompat.getName().substring(layer.getPathSandbox().length()).replace("Compat_", "");
			try {
				Class<?> classMc = Class.forName(nameMc, false, CompatibilityMod.classLoader);
				getMethodsForClassAndParents(classMc, false);
			} catch (Exception e) {
				// Ignore Exceptions
			}
		}
	}

	public List<MethodInfo> getMethods() {
		return methods;
	}

	public boolean containsDescriptor(MethodInfo methodOther) {
		return getByDesc(methodOther.desc) != null;
	}

	public boolean containsName(String name) {
		for (MethodInfo method : methods) {
			if (method.name.equals(name)) {
				return true;
			}
		}
		return false;
	}

	public MethodInfo getByDesc(String desc) {
		for (MethodInfo method : methods) {
			if (method.desc.equals(desc)) {
				return method;
			}
		}
		return null;
	}
}
