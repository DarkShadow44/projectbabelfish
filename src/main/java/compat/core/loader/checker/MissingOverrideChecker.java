package compat.core.loader.checker;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.mutable.MutableBoolean;
import org.objectweb.asm.Type;

import compat.autogen.HasCallback;
import compat.core.Version;
import compat.core.VersionInfo;
import compat.core.layer.CompatibilityLayer;
import compat.core.loader.CompatibilityClassTransformer;

public class MissingOverrideChecker extends GenericChecker {

	private final List<String> knownFalsePositives;

	public MissingOverrideChecker(CompatibilityLayer layer) {
		super(layer, "override methods");

		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("overrideCheckerFalsePositives.txt");
		try {
			knownFalsePositives = IOUtils.readLines(inputStream, StandardCharsets.UTF_8);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
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

	private boolean methodExistsInCompatInternal(Class<?> clazz, Method methodSearch, MutableBoolean hasCallback, Version versionMod) {
		String nameOwner = clazz.getName().replace(".", "/");
		if (nameOwner.startsWith(layer.getPathSandbox())) {
			nameOwner = nameOwner.substring(layer.getPathSandbox().length());
		}

		if (CompatibilityClassTransformer.isMcClass(nameOwner)) {
			for (Method method : clazz.getDeclaredMethods()) {
				if (method.getName().equals(methodSearch.getName()) && methodMatches(method, methodSearch)) {
					HasCallback annotation = method.getAnnotation(HasCallback.class);
					boolean isIface = clazz.isInterface();
					boolean hasAnnotation = annotation != null && ArrayUtils.contains(annotation.value(), versionMod);
					hasCallback.setValue(isIface || hasAnnotation);
					return true;
				}
			}
		}

		if (clazz.getSuperclass() != null) {
			if (methodExistsInCompatInternal(clazz.getSuperclass(), methodSearch, hasCallback, versionMod))
				return true;
		}

		for (Class<?> parent : clazz.getInterfaces()) {
			if (methodExistsInCompatInternal(parent, methodSearch, hasCallback, versionMod))
				return true;
		}

		return false;
	}

	private boolean methodExistsInCompat(Class<?> modClass, Method methodSearch, MutableBoolean hasCallback, Version versionMod) {
		if (modClass.getSuperclass() != null) {
			if (methodExistsInCompatInternal(modClass.getSuperclass(), methodSearch, hasCallback, versionMod))
				return true;
		}

		for (Class<?> parent : modClass.getInterfaces()) {
			if (methodExistsInCompatInternal(parent, methodSearch, hasCallback, versionMod))
				return true;
		}
		return false;

	}

	public void checkClass(Class<?> classMod) {
		Version versionMod = classMod.getAnnotation(VersionInfo.class).value();
		String parentName = classMod.getSuperclass() == null ? "Object" : classMod.getSuperclass().getName();
		for (Method method : classMod.getDeclaredMethods()) {
			if (method.getName().startsWith(layer.getPrefixFake())) {
				MutableBoolean hasCallback = new MutableBoolean();
				int lastDot = parentName.lastIndexOf('.') + 1;
				String className = parentName.substring(lastDot);
				String methodInfo = className + "." + method.getName() + Type.getMethodDescriptor(method);
				if (!methodExistsInCompat(classMod, method, hasCallback, versionMod)) {
					if (!knownFalsePositives.contains(methodInfo)) {
						methods.add("Missing override method: " + methodInfo);
					}
				} else if (!hasCallback.getValue()) {
					methods.add("Missing callback method: " + methodInfo);
				}
			}
		}
	}
}
