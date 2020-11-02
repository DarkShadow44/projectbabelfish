package compat.core.loader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import compat.core.CompatibilityMod;
import compat.core.layer.CompatibilityLayer;

public class CompatibilityClassLoader {

	private final MemoryClassLoader classLoader;
	private final CompatibilityLayer layer;

	private final HashMap<String, Boolean> loadedClassNames = new HashMap<String, Boolean>();

	public CompatibilityClassLoader(CompatibilityLayer layer, MemoryClassLoader classLoader) {
		this.layer = layer;
		this.classLoader = classLoader;
	}

	boolean classExists(String name) {
		if (name.startsWith("java/")) {
			return true;
		}

		if (name.startsWith("com/google")) {
			return true;
		}

		if (loadedClassNames.containsKey(name)) {
			return true;
		}

		try {
			name = layer.getPrefixedClassname(name);
			Class.forName(name.replace('/', '.'), false, CompatibilityMod.classLoader);
			return true;
		} catch (ClassNotFoundException | NoClassDefFoundError e) {
			return false;
		}
	}

	boolean canLoadClass(LoadClassInfo clazz) {
		if (loadedClassNames.containsKey(clazz.name))
			return false;

		for (String dep : clazz.dependenciesHard) {
			if (!classExists(dep)) {
				return false;
			}
		}
		return true;
	}

	boolean isClassToLoad(Map<String, LoadClassInfo> classesToLoad, String name) {
		for (LoadClassInfo info : classesToLoad.values()) {
			if (info.name.equals(name)) {
				return true;
			}
		}
		return false;
	}

	List<Class<?>> loadClasses(Map<String, LoadClassInfo> classesToLoad) {
		List<Class<?>> loadedClasses = new ArrayList<Class<?>>();
		int target = loadedClassNames.size() + classesToLoad.size();

		while (loadedClassNames.size() < target) {
			int sizeBefore = loadedClassNames.size();

			for (LoadClassInfo clazz : classesToLoad.values()) {
				if (canLoadClass(clazz)) {
					loadedClassNames.put(clazz.name, true);
					clazz.transformer.transform(classesToLoad);
					String name = clazz.transformer.getThisClass();
					byte[] data = clazz.transformer.getTransformedData();
					Class<?> c = classLoader.addClass(name.replace('/', '.'), data);
					loadedClasses.add(c);
				}
			}

			if (loadedClassNames.size() == sizeBefore) {
				List<String> missingClasses = new ArrayList<String>();
				for (LoadClassInfo clazz : classesToLoad.values()) {
					if (!classExists(clazz.name)) {
						for (String dep : clazz.dependenciesHard) {
							if (!missingClasses.contains(dep) && !classExists(dep) && !isClassToLoad(classesToLoad, dep)) {
								missingClasses.add(dep);
							}
						}
					}
				}
				Collections.sort(missingClasses);
				System.out.println("\n################ Compatibiliy Mod - Missing Classes:\n\t" + String.join("\n\t", missingClasses));
				break;
			}
		}

		MissingOverrideChecker overrideChecker = new MissingOverrideChecker(layer);

		for (Class<?> clazz : loadedClasses) {
			overrideChecker.checkClass(clazz);
		}
		overrideChecker.printWarning();

		return loadedClasses;
	}

	public List<Class<?>> loadClasses(List<byte[]> classes) {
		Map<String, LoadClassInfo> classesToLoad = new HashMap<>();

		for (byte[] cl : classes) {
			LoadClassInfo loadClassInfo = new LoadClassInfo();

			CompatibilityClassTransformer transformer = new CompatibilityClassTransformer(layer, cl);

			loadClassInfo.name = transformer.getThisClass();
			classesToLoad.put(loadClassInfo.name, loadClassInfo);
			loadClassInfo.transformer = transformer;

			List<String> dependenciesHard = new ArrayList<String>();
			dependenciesHard.add(transformer.getSuperClass());
			String[] interfaces = transformer.getInterfaces();
			for (String interf : interfaces)
				dependenciesHard.add(interf);

			loadClassInfo.dependenciesHard = dependenciesHard.toArray(new String[0]);
			loadClassInfo.parentName = transformer.getSuperClass();
			loadClassInfo.fields = transformer.getFields();
		}

		return loadClasses(classesToLoad);
	}
}
