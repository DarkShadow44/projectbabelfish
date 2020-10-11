package de.darkshadow44.compatibility.core.loader;

import java.util.List;

class LoadClassInfo {
	public String name;
	public CompatibilityClassTransformer transformer;
	public String[] dependenciesHard;
	public String parentName;
	public List<String> fields;
}