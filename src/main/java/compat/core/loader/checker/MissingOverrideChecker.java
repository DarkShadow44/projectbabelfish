package compat.core.loader.checker;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import org.apache.commons.lang3.mutable.MutableBoolean;
import org.objectweb.asm.Type;

import compat.autogen.HasCallback;
import compat.core.layer.CompatibilityLayer;
import compat.core.loader.CompatibilityClassTransformer;

public class MissingOverrideChecker extends GenericChecker {

	public MissingOverrideChecker(CompatibilityLayer layer) {
		super(layer, "override methods");
	}

	private static boolean methodMatches(Method method, Method methodSearch) {
		Parameter[] parameters = method.getParameters();
		Parameter[] parametersSearch = methodSearch.getParameters();

		Class<?> classRet = method.getReturnType();
		Class<?> classRetSearch = methodSearch.getReturnType();

		if (!classRet.isAssignableFrom(classRetSearch))
			return false;

		if (parameters.length != parametersSearch.length)
			return false;

		for (int i = 0; i < parameters.length; i++) {
				Class<?> classParam = parameters[i].getType();
				Class<?> classParamSearch = parametersSearch[i].getType();
				if (!classParam.isAssignableFrom(classParamSearch)) {
					return false;
				}
		}

		return true;
	}

	private boolean methodExistsInCompatInternal(Class<?> clazz, Method methodSearch, MutableBoolean hasCallback) {
		String nameOwner = clazz.getName().replace(".", "/");
		if (nameOwner.startsWith(layer.getPathSandbox())) {
			nameOwner = nameOwner.substring(layer.getPathSandbox().length());
		}

		if (CompatibilityClassTransformer.isMcClass(nameOwner)) {
			for (Method method : clazz.getDeclaredMethods()) {
				if (method.getName().equals(methodSearch.getName()) && methodMatches(method, methodSearch)) {
					HasCallback annotation = method.getAnnotation(HasCallback.class);
					boolean isIface = clazz.isInterface();
					hasCallback.setValue(isIface || annotation != null);
					return true;
				}
			}
		}

		if (clazz.getSuperclass() != null) {
			if (methodExistsInCompatInternal(clazz.getSuperclass(), methodSearch, hasCallback))
				return true;
		}

		for (Class<?> parent : clazz.getInterfaces()) {
			if (methodExistsInCompatInternal(parent, methodSearch, hasCallback))
				return true;
		}

		return false;
	}

	private boolean methodExistsInCompat(Class<?> modClass, Method methodSearch, MutableBoolean hasCallback) {
		if (modClass.getSuperclass() != null) {
			if (methodExistsInCompatInternal(modClass.getSuperclass(), methodSearch, hasCallback))
				return true;
		}

		for (Class<?> parent : modClass.getInterfaces()) {
			if (methodExistsInCompatInternal(parent, methodSearch, hasCallback))
				return true;
		}
		return false;

	}

	public void checkClass(Class<?> classMod) {
		String parentName = classMod.getSuperclass() == null ? "Object" : classMod.getSuperclass().getName();
		for (Method method : classMod.getDeclaredMethods()) {
			if (method.getName().startsWith(layer.getPrefixFake())) {
				MutableBoolean hasCallback = new MutableBoolean();
				int lastDot = parentName.lastIndexOf('.') + 1;
				String className = parentName.substring(lastDot);
				if (!methodExistsInCompat(classMod, method, hasCallback)) {
					methods.add("Missing override method: " + className + "." + method.getName() + Type.getMethodDescriptor(method));
				} else if (!hasCallback.getValue()) {
					methods.add("Missing callback method: " + className + "." + method.getName() + Type.getMethodDescriptor(method));
				}
			}
		}
	}
}
