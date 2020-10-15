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
		//System.out.println("Loading class: " + name); // For debugging
		return defineClass(name, data, 0, data.length);
	}

	public void addResource(String path, byte[] data) {
		if (!path.startsWith("/"))
			path = "/" + path;
		if (path.contains("witchesRobes.png")) {
			path = "/compatibility/textures/items/witchrobe.png";
		}
		resources.put(path, data);
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
