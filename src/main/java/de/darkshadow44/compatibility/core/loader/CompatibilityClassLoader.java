package de.darkshadow44.compatibility.core.loader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.io.Files;

import de.darkshadow44.compatibility.core.CompatibilityMod;
import de.darkshadow44.compatibility.core.layer.CompatibilityLayer;

public class CompatibilityClassLoader {

	private final MemoryClassLoader classLoader;
	private final CompatibilityLayer layer;

	public CompatibilityClassLoader(CompatibilityLayer layer, MemoryClassLoader classLoader) {
		this.layer = layer;
		this.classLoader = classLoader;
	}

	boolean classExists(HashMap<String, Boolean> loadedClassNames, String name) {
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
			Class.forName(name.replace('/', '.'), true, CompatibilityMod.classLoader);
			return true;
		} catch (ClassNotFoundException e) {
			return false;
		}
	}

	boolean canLoadClass(HashMap<String, Boolean> loadedClassNames, LoadClassInfo clazz) {
		if (loadedClassNames.containsKey(clazz.name))
			return false;

		for (String dep : clazz.dependenciesHard) {
			if (!classExists(loadedClassNames, dep)) {
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
		HashMap<String, Boolean> loadedClassNames = new HashMap<String, Boolean>();
		List<Class<?>> loadedClasses = new ArrayList<Class<?>>();

		while (loadedClassNames.size() < classesToLoad.size()) {
			int sizeBefore = loadedClassNames.size();

			for (LoadClassInfo clazz : classesToLoad.values()) {
				if (canLoadClass(loadedClassNames, clazz)) {
					loadedClassNames.put(clazz.name, true);
					clazz.transformer.transform(classesToLoad);
					String name = clazz.transformer.getThisClass();
					byte[] data = clazz.transformer.getTransformedData();

					int debug = 0;
					if (debug == 1) {
						try {
							Files.write(data, new File("/home/fabian/Ramdisk/test.class"));
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					Class<?> c = classLoader.addClass(name.replace('/', '.'), data);
					loadedClasses.add(c);
				}
			}

			if (loadedClassNames.size() == sizeBefore) {
				List<String> missingClasses = new ArrayList<String>();
				for (LoadClassInfo clazz : classesToLoad.values()) {
					if (!classExists(loadedClassNames, clazz.name)) {
						for (String dep : clazz.dependenciesHard) {
							if (!missingClasses.contains(dep) && !classExists(loadedClassNames, dep) && !isClassToLoad(classesToLoad, dep)) {
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

		return loadedClasses;
	}

	public List<Class<?>> loadClasses(byte[][] classes) {
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
