package de.darkshadow44.compatibility.core.loader;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.objectweb.asm.Type;

import de.darkshadow44.compatibility.core.CompatibilityMod;
import de.darkshadow44.compatibility.core.layer.CompatibilityLayer;

public class MissingOverrideChecker {

	private final List<String> methods = new ArrayList<>();
	private final CompatibilityLayer layer;

	public MissingOverrideChecker(CompatibilityLayer layer) {
		this.layer = layer;
	}

	private boolean isModClass(Class<?> c) {
		if (c == null || c == Object.class || c == Enum.class)
			return false;

		if (c.getName().length() < layer.getPathSandbox().length()) {
			throw new RuntimeException("Unexpected class : " + c.getName());
		}
		String name = c.getName().substring(layer.getPathSandbox().length());
		return !CompatibilityClassTransformer.isMcClass(name);
	}

	private void getMethodsForClassUnconditionally(List<String> ret, Class<?> clazz, boolean withDescriptor) {
		for (Method method : clazz.getDeclaredMethods()) {
			String name = method.getName();
			if (withDescriptor) {
				ret.add(name + Type.getMethodDescriptor(method));
			} else {
				ret.add(name);
			}
		}
	}

	private void getMethodsForClassAndParents(List<String> ret, Class<?> clazz, boolean withDescriptor) {
		if (clazz == null || clazz == Object.class)
			return;

		getMethodsForClassUnconditionally(ret, clazz, withDescriptor);

		if (isModClass(clazz) && !isModClass(clazz.getSuperclass()))
			return;
		getMethodsForClassAndParents(ret, clazz.getSuperclass(), withDescriptor);
	}

	public void checkClass(Class<?> classMod) {
		Class<?> parentCompat = classMod.getSuperclass();

		List<String> methodsMod = new ArrayList<>();
		List<String> methodsCompat = new ArrayList<>();
		List<String> methodsMc = new ArrayList<>();

		while (isModClass(parentCompat)) {
			for (Class<?> classIface : parentCompat.getInterfaces()) {
				getMethodsForClassUnconditionally(methodsCompat, classIface, true);
			}
			parentCompat = parentCompat.getSuperclass();
		}
		if (parentCompat == null)
			return;

		if (parentCompat != Object.class && parentCompat != Enum.class) {
			String nameMc = parentCompat.getName().substring(layer.getPathSandbox().length()).replace("Compat_", "");

			try {
				Class<?> classMc = Class.forName(nameMc, false, CompatibilityMod.classLoader);
				getMethodsForClassAndParents(methodsMc, classMc, false);
			} catch (Exception e) {
				// Ignore errors
			}
		}

		try {
			getMethodsForClassAndParents(methodsMod, classMod, true);
			getMethodsForClassAndParents(methodsCompat, parentCompat, true);
			for (Class<?> classIface : classMod.getInterfaces()) {
				getMethodsForClassUnconditionally(methodsCompat, classIface, true);
			}
		} catch (Throwable e) {
			throw new RuntimeException("Checking class: \n" + classMod.getName() + "\n" + parentCompat.getName(), e);
		}

		for (String method : methodsMod) {
			if (!methodsCompat.contains(method)) {
				if (method.startsWith(layer.getPrefixFake() + "func_")) {
					methods.add(parentCompat.getSimpleName() + "." + method);
				} else {
					String mcName = method.replace(layer.getPrefixFake(), "");
					mcName = mcName.substring(0, mcName.indexOf("("));
					if (methodsMc.contains(mcName)) {
						methods.add(parentCompat.getSimpleName() + "." + method);
					}
				}
			}
		}

	}

	public void printWarning() {
		List<String> methodsDedup = methods.stream().distinct().collect(Collectors.toList());
		for (String method : methodsDedup) {
			System.out.println("Compatibility: Missing method: " + method);
		}
	}
}
