package darkshadow44.compatibility.core.asm;

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

	public Class addClass(String name, byte[] data) {
		return defineClass(name, data, 0, data.length);
	}

	public void addResource(String path, byte[] data) {
		resources.put(path, data);
	}

	@Override
	public InputStream getResourceAsStream(String path) {
		if (resources.containsKey(path))
			return new DataInputStream(new ByteArrayInputStream(resources.get(path)));
		return null;
	}
}
