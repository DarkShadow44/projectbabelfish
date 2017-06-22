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

	boolean HasRequirements(HashMap<String, Boolean> loadedClasses, ClassParser parser) {
		String superclass = transformConfig.GetTransformedClassname(parser.GetSuperclass());
		String[] interfaces = parser.GetInterfaces();
		if (!loadedClasses.containsKey(superclass))
			return false;

		for (int i = 0; i < interfaces.length; i++) {
			if (!loadedClasses.containsKey(transformConfig.GetTransformedClassname(interfaces[i])))
				return false;
		}

		if (IsClassLoaded(superclass.replace('/', '.'))) {
			loadedClasses.put(superclass, true);
			return true;
		}

		return true;
	}

	boolean IsClassLoaded(String name) {
		try {
			Class<?> cl = Class.forName("name");
			return true;
		} catch (ClassNotFoundException e) {
			return false;
		}
	}

	public void LoadClasses(byte[][] classes) {
		HashMap<String, Boolean> loadedClasses = new HashMap<String, Boolean>();
		List<ClassParser> classesToLoad = new ArrayList<ClassParser>();

		loadedClasses.put("java/lang/Object", true);

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
