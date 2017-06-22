package darkshadow44.compatibility.core.asm;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.ClassNode;

import com.google.common.io.Files;

import helper.ReflectionHelper;
import net.minecraft.launchwrapper.Launch;
import scala.Console;

public class ClassTransformer {

	TransformConfig transformConfig;

	public ClassTransformer() {
		transformConfig = new TransformConfig();
	}

	public byte[] TransformClass(byte[] data) {
		ClassConstantTransformer constantTransformer = new ClassConstantTransformer(transformConfig);
		byte[] ret = constantTransformer.TransformClass(data);

		return ret;
	}

	public Class InjectClass(String className, byte[] data) {
		ClassLoader classLoader = Launch.classLoader;
		Object[] parameters = new Object[] { className, data, 0, data.length };
		Class[] classParameters = new Class[] { String.class, byte[].class, int.class, int.class };
		Object cl = ReflectionHelper.callPrivateMethod(ClassLoader.class, classLoader, "defineClass", parameters,
				classParameters);
		return (Class) cl;
	}

	public Class LoadClass(String className, byte[] data) {
		try {
			Files.write(data, new File("./testIn.class"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		data = TransformClass(data);

		try {
			Files.write(data, new File("./testOut.class"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Loading: " + className);
		return InjectClass(className.replace('/', '.'), data);
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

	boolean HasRequirements(HashMap<String, Boolean> loadedClassNames, ClassParser parser) {
		String superclass = transformConfig.GetTransformedClassname(parser.GetSuperclass());
		String[] interfaces = parser.GetInterfaces();

		if (!ClassExists(loadedClassNames, superclass))
			return false;

		for (int i = 0; i < interfaces.length; i++) {
			if (!ClassExists(loadedClassNames, transformConfig.GetTransformedClassname(interfaces[i])))
				return false;
		}

		return true;
	}

	public Class[] LoadClasses(byte[][] classes) {
		List<Class> loadedClasses = new ArrayList<Class>();
		HashMap<String, Boolean> loadedClassNames = new HashMap<String, Boolean>();
		List<ClassParser> classesToLoad = new ArrayList<ClassParser>();

		for (int i = 0; i < classes.length; i++) {
			ClassParser parser = new ClassParser();
			parser.Parse(classes[i]);
			classesToLoad.add(parser);
		}

		int num_iterations = 0;
		while (classesToLoad.size() > 0) {
			num_iterations++;
			if (num_iterations > 100) {
				String err = "Can't find classes: \n";
				List<String> classesErr = new ArrayList<String>();

				for (ClassParser parser : classesToLoad) {
					classesErr.add(transformConfig.GetTransformedClassname(parser.GetSuperclass()));

					String[] interfaces = parser.GetInterfaces();
					for (String interfacex : interfaces)
						classesErr.add(transformConfig.GetTransformedClassname(interfacex));
				}

				classesErr = classesErr.stream().distinct().collect(Collectors.toList());
				for (String name : classesErr) {
					if (!ClassExists(loadedClassNames, name))
						err += name + "\n";
				}
				throw new RuntimeException(err);
			}

			ListIterator<ClassParser> iter = classesToLoad.listIterator();
			while (iter.hasNext()) {
				ClassParser parser = iter.next();

				if (HasRequirements(loadedClassNames, parser)) {
					String className = transformConfig.GetPrefix() + parser.GetThisclass();
					Class c = LoadClass(className, parser.GetData());
					loadedClasses.add(c);
					loadedClassNames.put(className, true);
					iter.remove();
				}
			}
		}
		return loadedClasses.toArray(new Class[0]);
	}

}
