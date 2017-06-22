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

	public ClassTransformer() {
		transformConfig = new TransformConfig();
		constantTransformer = new ClassConstantTransformer(transformConfig);
	}

	static class LoadClassInfo {
		public String name;
		public byte[] data;
		public String[] dependencies;
	}

	public Class InjectClass(String className, byte[] data) {
		ClassLoader classLoader = Launch.classLoader;
		Object[] parameters = new Object[] { className, data, 0, data.length };
		Class[] classParameters = new Class[] { String.class, byte[].class, int.class, int.class };
		Object cl = ReflectionHelper.callPrivateMethod(ClassLoader.class, classLoader, "defineClass", parameters,
				classParameters);
		return (Class) cl;
	}

	boolean IsClassLoaded(String name) {
		try {
			Class<?> cl = Class.forName(name);
			return true;
		} catch (ClassNotFoundException e) {
			return false;
		}
	}

	boolean ClassExists(HashMap<String, Boolean> loadedClassNames, String name) {
		if (name.startsWith("java/"))
			return true;

		if (loadedClassNames.containsKey(name))
			return true;

		if (IsClassLoaded(name.replace('/', '.'))) {
			loadedClassNames.put(name, true);
			return true;
		}

		return false;
	}

	void LogLoadErrors(List<LoadClassInfo> classesToLoad, HashMap<String, Boolean> loadedClassNames) {
		String err = "Can't find classes: \n";
		String errInJar = "";
		String errOutJar = "";
		List<String> classesErr = new ArrayList<String>();

		for (LoadClassInfo cl : classesToLoad) {
			for (String dep : cl.dependencies)
				classesErr.add(dep);
		}

		classesErr = classesErr.stream().distinct().collect(Collectors.toList());
		Collections.sort(classesErr);
		for (String name : classesErr) {
			boolean inThisJar = false;
			for (LoadClassInfo classInfo : classesToLoad) {
				if (classInfo.name.equals(name))
					inThisJar = true;
			}

			if (!ClassExists(loadedClassNames, name)) {
				if (inThisJar)
					errInJar += name + "\n";
				else
					errOutJar += name + "\n";
			}
		}
		err += "Outside Jar: \n" + errOutJar + "Inside Jar: \n" + errInJar;
		throw new RuntimeException(err);
	}

	public Class[] LoadClasses(byte[][] classes) {
		List<Class> loadedClasses = new ArrayList<Class>();
		HashMap<String, Boolean> loadedClassNames = new HashMap<String, Boolean>();
		List<LoadClassInfo> classesToLoad = new ArrayList<LoadClassInfo>();

		for (byte[] cl : classes) {
			LoadClassInfo loadClassInfo = new LoadClassInfo();
			classesToLoad.add(loadClassInfo);

			ClassParser parser = new ClassParser();
			parser.Parse(cl);

			loadClassInfo.name = transformConfig.GetPrefix() + parser.GetThisclass();

			List<String> dependencies = new ArrayList<String>();
			loadClassInfo.data = constantTransformer.TransformAndGetDependencies(cl, dependencies);
			dependencies.add(transformConfig.GetTransformedClassname(parser.GetSuperclass()));

			String[] interfaces = parser.GetInterfaces();
			for (String interfacex : interfaces)
				dependencies.add(transformConfig.GetTransformedClassname(interfacex));
			loadClassInfo.dependencies = dependencies.toArray(new String[0]);
		}

		int num_iterations = 0;
		while (classesToLoad.size() > 0) {
			num_iterations++;
			if (num_iterations > 100) {
				LogLoadErrors(classesToLoad, loadedClassNames);
			}

			ListIterator<LoadClassInfo> iter = classesToLoad.listIterator();
			while (iter.hasNext()) {
				LoadClassInfo loadClassInfo = iter.next();

				boolean depsFound = true;
				for (String dep : loadClassInfo.dependencies) {
					if (!ClassExists(loadedClassNames, dep)) {
						depsFound = false;
						break;
					}
				}

				if (depsFound) {
					System.out.println("Loading: " + loadClassInfo.name);
					Class c = InjectClass(loadClassInfo.name.replace('/', '.'), loadClassInfo.data);
					loadedClasses.add(c);
					loadedClassNames.put(loadClassInfo.name, true);
					iter.remove();
				}
			}
		}
		return loadedClasses.toArray(new Class[0]);
	}

}
