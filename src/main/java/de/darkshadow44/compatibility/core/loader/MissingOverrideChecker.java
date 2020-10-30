package de.darkshadow44.compatibility.core.loader;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.objectweb.asm.Type;

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

	private void getMethodsForClassUnconditionally(List<String> ret, Class<?> clazz) {
		for (Method method : clazz.getDeclaredMethods()) {
			String name = method.getName();
			if (name.startsWith(layer.getPrefixFake() + "func_")) {
				ret.add(name + Type.getMethodDescriptor(method));
			}
		}
	}

	private void getMethodsForClassAndParents(List<String> ret, Class<?> clazz) {
		if (clazz == null || clazz == Object.class)
			return;

		getMethodsForClassUnconditionally(ret, clazz);

		if (isModClass(clazz) && !isModClass(clazz.getSuperclass()))
			return;
		getMethodsForClassAndParents(ret, clazz.getSuperclass());
	}

	public void checkClass(Class<?> classMod) {
		Class<?> mcParent = classMod.getSuperclass();

		List<String> methodsMod = new ArrayList<>();
		List<String> methodsMc = new ArrayList<>();

		while (isModClass(mcParent)) {
			for (Class<?> classIface : mcParent.getInterfaces()) {
				getMethodsForClassUnconditionally(methodsMc, classIface);
			}
			mcParent = mcParent.getSuperclass();
		}
		if (mcParent == null)
			return;

		try {
			getMethodsForClassAndParents(methodsMod, classMod);
			getMethodsForClassAndParents(methodsMc, mcParent);
			for (Class<?> classIface : classMod.getInterfaces()) {
				getMethodsForClassUnconditionally(methodsMc, classIface);
			}
		} catch (Throwable e) {
			throw new RuntimeException("Checking class: \n" + classMod.getName() + "\n" + mcParent.getName(), e);
		}

		for (String method : methodsMod) {
			if (!methodsMc.contains(method)) {
				methods.add(mcParent.getSimpleName() + "." + method);
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
