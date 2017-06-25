package darkshadow44.compatibility.core.asm;

public class MemoryClassLoader extends ClassLoader {

	public MemoryClassLoader(ClassLoader parent) {
		super(parent);
	}

	public Class injectClass(String name, byte[] data) {
		return defineClass(name, data, 0, data.length);
	}
}
