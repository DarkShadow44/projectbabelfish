package darkshadow44.compatibility.core.asm;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.ClassNode;

import com.google.common.io.Files;

import helper.IOHelper;
import helper.ReflectionHelper;
import net.minecraft.launchwrapper.Launch;
import scala.Console;

public class ClassTransformer {

	TransformConfig transformConfig;
	ClassConstantTransformer constantTransformer;
	MemoryClassLoader classLoader;

	public ClassTransformer() {
		transformConfig = new TransformConfig();
		constantTransformer = new ClassConstantTransformer(transformConfig);
		classLoader = new MemoryClassLoader(Launch.classLoader);
	}

	static class LoadClassInfo {
		public String name;
		public byte[] data;
		public String[] dependenciesHard;
		public String[] dependenciesSoft;
	}

	boolean IsClassLoaded(String name) {
		try {
			Class<?> cl = Class.forName(name);
			return true;
		} catch (ClassNotFoundException e) {
			return false;
		}
	}

	boolean ClassExists(HashMap<String, LoadClassInfo> loadedClassNames, String name) {
		if (name.startsWith("java/"))
			return true;

		if (loadedClassNames.containsKey(name))
			return true;

		if (IsClassLoaded(name.replace('/', '.'))) {
			return true;
		}

		return false;
	}

	void LogLoadErrors(List<LoadClassInfo> classesToLoad, HashMap<String, LoadClassInfo> loadedClassNames,
			boolean hard) {
		String err = "Can't find classes: \n";
		String errInJar = "";
		String errOutJar = "";
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
			if (!ClassExists(loadedClassNames, name))
				err += name + "\n";

		if (classesErr.size() > 0) {
			if (hard)
				throw new RuntimeException(err);
			else
				Console.out().println("################ Compatibiliy Mod - Missing Classes!\n" + err);
		}
	}

	public Class[] LoadClasses(byte[][] classes) {
		List<Class> loadedClasses = new ArrayList<Class>();
		HashMap<String, LoadClassInfo> loadedClassNames = new HashMap<String, LoadClassInfo>();
		List<LoadClassInfo> classesToLoad = new ArrayList<LoadClassInfo>();

		for (byte[] cl : classes) {
			LoadClassInfo loadClassInfo = new LoadClassInfo();
			classesToLoad.add(loadClassInfo);

			ClassParser parser = new ClassParser();
			parser.Parse(cl);

			List<String> dependenciesSoft = new ArrayList<String>();
			List<String> dependenciesHard = new ArrayList<String>();

			loadClassInfo.name = transformConfig.GetPrefix() + parser.GetThisclass();
			loadClassInfo.data = constantTransformer.TransformAndGetDependencies(cl, dependenciesSoft);

			dependenciesHard.add(transformConfig.GetTransformedClassname(parser.GetSuperclass()));
			String[] interfaces = parser.GetInterfaces();
			for (String interfacex : interfaces)
				dependenciesHard.add(transformConfig.GetTransformedClassname(interfacex));

			loadClassInfo.dependenciesSoft = dependenciesSoft.toArray(new String[0]);
			loadClassInfo.dependenciesHard = dependenciesHard.toArray(new String[0]);
		}

		int num_iterations = 0;
		while (classesToLoad.size() > 0) {
			num_iterations++;
			if (num_iterations > 100) {
				LogLoadErrors(classesToLoad, loadedClassNames, true);
			}

			ListIterator<LoadClassInfo> iter = classesToLoad.listIterator();
			while (iter.hasNext()) {
				LoadClassInfo loadClassInfo = iter.next();

				boolean depsFound = true;
				for (String dep : loadClassInfo.dependenciesHard) {
					if (!ClassExists(loadedClassNames, dep)) {
						depsFound = false;
						break;
					}
				}

				if (depsFound) {
					Class c = classLoader.injectClass(loadClassInfo.name.replace('/', '.'), loadClassInfo.data);
					loadedClasses.add(c);
					loadedClassNames.put(loadClassInfo.name, loadClassInfo);
					iter.remove();
				}
			}
		}
		LogLoadErrors(classesToLoad, loadedClassNames, false);

		return loadedClasses.toArray(new Class[0]);
	}

}
