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

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.ClassNode;

import com.google.common.io.Files;

import scala.Console;

public class ClassTransformer {

	MemoryClassLoader classLoader;
	TransformConfig transformConfig;

	public ClassTransformer() {
		classLoader = new MemoryClassLoader();
		transformConfig = new TransformConfig();
	}

	public byte[] TransformClass(byte[] data) {
		ClassConstantTransformer constantTransformer = new ClassConstantTransformer(transformConfig);
		byte[] ret = constantTransformer.TransformClass(data);

		return ret;
	}

	public void LoadClass(String className, byte[] data) {
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
		classLoader.injectClass(className.replace('/', '.'), data);
	}

	boolean IsClassLoaded(String name) {
		try {
			Class<?> cl = Class.forName(name);
			return true;
		} catch (ClassNotFoundException e) {
			return false;
		}
	}

	boolean ClassExists(HashMap<String, Boolean> loadedClasses, String name) {
		if (name.startsWith("java/"))
			return true;

		if (loadedClasses.containsKey(name))
			return true;

		if (IsClassLoaded(name.replace('/', '.'))) {
			loadedClasses.put(name, true);
			return true;
		}

		return false;
	}

	boolean HasRequirements(HashMap<String, Boolean> loadedClasses, ClassParser parser) {
		String superclass = transformConfig.GetTransformedClassname(parser.GetSuperclass());
		String[] interfaces = parser.GetInterfaces();

		if (!ClassExists(loadedClasses, superclass))
			return false;

		for (int i = 0; i < interfaces.length; i++) {
			if (!ClassExists(loadedClasses, transformConfig.GetTransformedClassname(interfaces[i])))
				return false;
		}

		return true;
	}

	public void LoadClasses(byte[][] classes) {
		HashMap<String, Boolean> loadedClasses = new HashMap<String, Boolean>();
		List<ClassParser> classesToLoad = new ArrayList<ClassParser>();

		for (int i = 0; i < classes.length; i++) {
			ClassParser parser = new ClassParser();
			parser.Parse(classes[i]);
			classesToLoad.add(parser);
		}

		int num_iterations = 0;
		while (classesToLoad.size() > 0) {
			num_iterations++;
			if (num_iterations > 100)
				throw new RuntimeException("Can't find class: \n" + classesToLoad.get(0).GetSuperclass()
						+ "\nrequired by: \n" + classesToLoad.get(0).GetThisclass());

			ListIterator<ClassParser> iter = classesToLoad.listIterator();
			while (iter.hasNext()) {
				ClassParser parser = iter.next();

				if (HasRequirements(loadedClasses, parser)) {
					String className = transformConfig.GetPrefix() + parser.GetThisclass();
					LoadClass(className, parser.GetData());
					loadedClasses.put(className, true);
					iter.remove();
				}
			}
		}
	}

}
