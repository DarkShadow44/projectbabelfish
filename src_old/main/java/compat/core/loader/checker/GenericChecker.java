package compat.core.loader.checker;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import compat.core.layer.CompatibilityLayer;

public abstract class GenericChecker {
	protected final List<String> missing = new ArrayList<>();
	protected final CompatibilityLayer layer;
	private final String name;

	public GenericChecker(CompatibilityLayer layer, String name) {
		this.layer = layer;
		this.name = name;
	}

	public void printWarning() {
		List<String> methodsDedup = missing.stream().distinct().sorted().collect(Collectors.toList());
		StringBuilder sb = new StringBuilder();
		sb.append("\n########## Compatibility: Found " + methodsDedup.size() + " missing " + name + ".\n");

		for (String method : methodsDedup) {
			sb.append("\t" + method + "\n");
		}
		System.out.println(sb.toString());
	}
}
