package de.darkshadow44.compatibility.core.loader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class CompatibilityClassLoader {

	static class LoadClassInfo {
		public String name;
		public byte[] data;
		public String[] dependenciesHard;
		public String[] dependenciesSoft;
	}

	MemoryClassLoader classLoader;

	public CompatibilityClassLoader(MemoryClassLoader classLoader) {
		this.classLoader = classLoader;
	}

	boolean isClassLoaded(String name) {
		try {
			Class.forName(name);
			return true;
		} catch (ClassNotFoundException e) {
			return false;
		}
	}

	boolean classExists(HashMap<String, LoadClassInfo> loadedClassNames, String name) {
		if (name.startsWith("java/"))
			return true;

		if (loadedClassNames.containsKey(name))
			return true;

		if (isClassLoaded(name.replace('/', '.'))) {
			return true;
		}

		return false;
	}

	void logLoadErrors(List<LoadClassInfo> classesToLoad, HashMap<String, LoadClassInfo> loadedClassNames, boolean hard) {
		String err = "Can't find classes: \n";
		List<String> classesErr = new ArrayList<String>();

		for (LoadClassInfo cl : classesToLoad) {
			String[] dependencies = hard ? cl.dependenciesHard : cl.dependenciesSoft;
			for (String dep : dependencies)
				classesErr.add(dep);
		}

		for (LoadClassInfo cl : loadedClassNames.values()) {
			String[] dependencies = hard ? cl.dependenciesHard : cl.dependenciesSoft;
			for (String dep : dependencies)
				classesErr.add(dep);
		}

		classesErr = classesErr.stream().distinct().collect(Collectors.toList());

		Collections.sort(classesErr);
		for (String name : classesErr)
			if (!classExists(loadedClassNames, name))
				err += name + "\n";

		if (classesErr.size() > 0) {
			if (hard)
				throw new RuntimeException(err);
			else
				System.out.print("################ Compatibiliy Mod - Missing Classes!\n" + err);
		}
	}

	public Class<?>[] loadClasses(byte[][] classes) {
		List<Class<?>> loadedClasses = new ArrayList<Class<?>>();
		HashMap<String, LoadClassInfo> loadedClassNames = new HashMap<String, LoadClassInfo>();
		List<LoadClassInfo> classesToLoad = new ArrayList<LoadClassInfo>();

		for (byte[] cl : classes) {
			LoadClassInfo loadClassInfo = new LoadClassInfo();
			classesToLoad.add(loadClassInfo);

			CompatibilityClassTransformer transformer = new CompatibilityClassTransformer(cl);

			List<String> dependenciesSoft = new ArrayList<String>();
			List<String> dependenciesHard = new ArrayList<String>();

			loadClassInfo.name = transformer.getThisClass();
			loadClassInfo.data = transformer.transform();
			dependenciesSoft = transformer.getDependencies();

			dependenciesHard.add(transformer.getSuperClass());
			String[] interfaces = transformer.getInterfaces();
			for (String interf : interfaces)
				dependenciesHard.add(interf);

			loadClassInfo.dependenciesSoft = dependenciesSoft.toArray(new String[0]);
			loadClassInfo.dependenciesHard = dependenciesHard.toArray(new String[0]);
		}

		logLoadErrors(classesToLoad, loadedClassNames, true);
		int num_iterations = 0;
		while (classesToLoad.size() > 0) {
			num_iterations++;
			if (num_iterations > 100) {
				throw new RuntimeException("Deadlock in class loading");
			}

			ListIterator<LoadClassInfo> iter = classesToLoad.listIterator();
			while (iter.hasNext()) {
				LoadClassInfo loadClassInfo = iter.next();

				boolean depsFound = true;
				for (String dep : loadClassInfo.dependenciesHard) {
					if (!classExists(loadedClassNames, dep)) {
						depsFound = false;
						break;
					}
				}

				if (depsFound) {
					Class<?> c = classLoader.addClass(loadClassInfo.name.replace('/', '.'), loadClassInfo.data);
					loadedClasses.add(c);
					loadedClassNames.put(loadClassInfo.name, loadClassInfo);
					iter.remove();
				}
			}
		}
		logLoadErrors(classesToLoad, loadedClassNames, false);

		return loadedClasses.toArray(new Class[0]);
	}
}
