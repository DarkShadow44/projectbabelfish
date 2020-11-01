package de.darkshadow44.compatibility.core.loader;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import de.darkshadow44.compatibility.core.layer.CompatibilityLayer;
import de.darkshadow44.compatibility.core.loader.OverrideMethodInfo.MethodInfo;

public class MissingOverrideChecker {

	private final List<String> methods = new ArrayList<>();
	private final CompatibilityLayer layer;

	public MissingOverrideChecker(CompatibilityLayer layer) {
		this.layer = layer;
	}

	public void checkClass(Class<?> classMod) {

		OverrideMethodInfo methodsMod = new OverrideMethodInfo(layer);
		OverrideMethodInfo methodsCompat = new OverrideMethodInfo(layer);
		OverrideMethodInfo methodsMc = new OverrideMethodInfo(layer);

		Class<?> parentCompat = classMod.getSuperclass();

		methodsCompat.addFromImplementedInterfaces(classMod);
		while (methodsCompat.isModClass(parentCompat)) {
			methodsCompat.addFromImplementedInterfaces(parentCompat);
			parentCompat = parentCompat.getSuperclass();
		}

		if (parentCompat == null)
			return;

		methodsMc.getMethodsForMc(parentCompat);

		try {
			methodsMod.getMethodsForClassAndParents(classMod, false);
			methodsCompat.getMethodsForClassAndParents(parentCompat, true);
		} catch (Throwable e) {
			throw new RuntimeException("Checking class: \n" + classMod.getName() + "\n" + parentCompat.getName(), e);
		}

		for (MethodInfo method : methodsMod.getMethods()) {
			if (!methodsCompat.containsDescriptor(method)) {
				if (method.name.startsWith(layer.getPrefixFake() + "func_")) {
					methods.add("Missing method: " + parentCompat.getSimpleName() + "." + method.desc);
				} else {
					String mcName = method.name.replace(layer.getPrefixFake(), "");
					if (methodsMc.containsName(mcName)) {
						methods.add("Missing method: " + parentCompat.getSimpleName() + "." + method.desc);
					}
				}
			} else if (!methodsCompat.getByDesc(method.desc).hasCallback) {
				methods.add("Missing callback: " + parentCompat.getSimpleName() + "." + method.desc);
			}
		}

	}

	public void printWarning() {
		List<String> methodsDedup = methods.stream().distinct().collect(Collectors.toList());
		for (String method : methodsDedup) {
			System.out.println("Compatibility: " + method);
		}
	}
}
