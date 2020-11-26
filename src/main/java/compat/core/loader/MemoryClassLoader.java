package compat.core.loader;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;

import com.google.common.io.Files;

import compat.core.CompatibilityMod;

public class MemoryClassLoader extends URLClassLoader {

	HashMap<String, byte[]> resources;

	public MemoryClassLoader(URL[] urls, ClassLoader parent) {
		super(urls, parent);
		resources = new HashMap<String, byte[]>();
	}

	public Class<?> addClass(String name, byte[] data) {
		if (!CompatibilityMod.DUMP_CLASSES)
			return defineClass(name, data, 0, data.length);

		try {
			File file = new File("/home/fabian/Programming/Minecraft/Mods/CompatibilityMod/mod/TEMP_CLASSES/" + name.replace(".", "/") + ".class");
			file.getParentFile().mkdirs();
			Files.write(data, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			// System.out.println("Loading class: " + name);
			return loadClass(name, false);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public void addResource(String path, byte[] data) {
		if (!path.startsWith("/")) {
			path = "/" + path;
		}
		resources.put(path.toLowerCase(), data);
	}

	@Override
	public InputStream getResourceAsStream(String path) {
		if (!path.startsWith("/"))
			path = "/" + path;
		if (resources.containsKey(path))
			return new DataInputStream(new ByteArrayInputStream(resources.get(path)));
		return null;
	}
}
