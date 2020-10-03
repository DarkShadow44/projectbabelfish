package de.darkshadow44.compatibility.core.loader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.google.common.io.Files;

public class CompatibilityClassLoader {

	static class LoadClassInfo {
		public String name;
		public CompatibilityClassTransformer transformer;
		public String[] dependenciesHard;
		public String[] dependenciesSoft;
	}

	MemoryClassLoader classLoader;

	public CompatibilityClassLoader(MemoryClassLoader classLoader) {
		this.classLoader = classLoader;
	}

	boolean classExists(HashMap<String, Boolean> loadedClassNames, String name) {
		if (name.startsWith("java/")) {
			return true;
		}

		if (loadedClassNames.containsKey(name)) {
			return true;
		}

		try {
			Class.forName(name.replace('/', '.'));
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

	boolean isClassToLoad(List<LoadClassInfo> classesToLoad, String name) {
		for (LoadClassInfo info : classesToLoad) {
			if (info.name.equals(name)) {
				return true;
			}
		}
		return false;
	}

	Class<?>[] loadClasses(List<LoadClassInfo> classesToLoad) {
		HashMap<String, Boolean> loadedClassNames = new HashMap<String, Boolean>();
		List<Class<?>> loadedClasses = new ArrayList<Class<?>>();

		while (loadedClassNames.size() < classesToLoad.size()) {
			int sizeBefore = loadedClassNames.size();

			for (LoadClassInfo clazz : classesToLoad) {
				if (canLoadClass(loadedClassNames, clazz)) {
					loadedClassNames.put(clazz.name, true);
					byte[] data = clazz.transformer.getTransformedData();

					int debug = 0;
					if (debug == 1) {
						try {
							Files.write(data, new File("/home/fabian/Ramdisk/test.class"));
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					Class<?> c = classLoader.addClass(clazz.name.replace('/', '.'), data);
					loadedClasses.add(c);
				}
			}

			if (loadedClassNames.size() == sizeBefore) {
				List<String> missingClasses = new ArrayList<String>();
				for (LoadClassInfo clazz : classesToLoad) {
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

		return loadedClasses.toArray(new Class<?>[0]);
	}

	public Class<?>[] loadClasses(byte[][] classes) {
		List<LoadClassInfo> classesToLoad = new ArrayList<LoadClassInfo>();

		for (byte[] cl : classes) {
			LoadClassInfo loadClassInfo = new LoadClassInfo();
			classesToLoad.add(loadClassInfo);

			CompatibilityClassTransformer transformer = new CompatibilityClassTransformer(cl);
			transformer.transform();

			loadClassInfo.name = transformer.getThisClass();
			loadClassInfo.transformer = transformer;

			List<String> dependenciesSoft = transformer.getDependencies();
			List<String> dependenciesHard = new ArrayList<String>();
			dependenciesHard.add(transformer.getSuperClass());
			String[] interfaces = transformer.getInterfaces();
			for (String interf : interfaces)
				dependenciesHard.add(interf);

			loadClassInfo.dependenciesSoft = dependenciesSoft.toArray(new String[0]);
			loadClassInfo.dependenciesHard = dependenciesHard.toArray(new String[0]);
		}

		Class<?>[] loadedClasses = loadClasses(classesToLoad);

		return loadedClasses;
	}
}
