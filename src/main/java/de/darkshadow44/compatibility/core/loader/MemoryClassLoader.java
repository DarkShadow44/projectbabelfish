package de.darkshadow44.compatibility.core.loader;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.HashMap;

public class MemoryClassLoader extends ClassLoader {

	HashMap<String, byte[]> resources;

	public MemoryClassLoader(ClassLoader parent) {
		super(parent);
		resources = new HashMap<String, byte[]>();
	}

	public Class<?> addClass(String name, byte[] data) {
		// System.out.println("Loading class: " + name); // For debugging
		return defineClass(name, data, 0, data.length);
	}

	public void addResource(String path, byte[] data) {
		if (path.startsWith("/")) {
			path = path.substring(1);
		}
		path = path.toLowerCase();

		String[] split = path.split("\\/");

		String modName = split[1];
		if (split[2].equals("textures")) {
			if (split[3].equals("items")) {
				resources.put("/compatibility/textures/items/" + modName + "_" + split[4], data);
				System.out.println("/compatibility/textures/items/" + modName + "_" + split[4]);
			}
		}
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
