package darkshadow44.compatibility.core.asm;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.ClassNode;

import com.google.common.io.Files;

public class ClassTransformer {

	MemoryClassLoader classLoader;
	String classPrefix;

	public ClassTransformer() {
		classLoader = new MemoryClassLoader();
		classPrefix = "darkshadow44.compatibility.version.v1_2_5.sandbox.";
	}

	boolean IsException(String name) {
		if (name.startsWith("java."))
			return true;

		return false;
	}

	public byte[] TransformClass(byte[] data) {

		ClassConstantTransformer constantTransformer = new ClassConstantTransformer();
		byte[] ret = constantTransformer.TransformClass(data);

		return ret;
	}

	public void LoadClass(String name, byte[] data) {
		try {
			Files.write(data, new File("./test1.class"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		data = TransformClass(data);
		name = classPrefix + name;

		try {
			Files.write(data, new File("./test.class"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		classLoader.injectClass(name, data);
	}

}
