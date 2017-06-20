package darkshadow44.compatibility.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import darkshadow44.compatibility.core.asm.ClassTransformer;

public class ArchiveHandler {

	static class ClassInfo {
		public String name;
		public byte[] data;

		public ClassInfo(String name, byte[] data) {
			this.name = name;
			this.data = data;
		}
	}

	public String[] GetModFiles(File path) {
		List<String> files = new ArrayList();

		for (File file : path.listFiles()) {
			if (file.isFile()) {
				String fileName = file.getPath().toLowerCase();
				if (fileName.endsWith(".zip") || fileName.endsWith(".jar"))
					files.add(file.getPath());
			}
		}
		return files.toArray(new String[0]);
	}

	public ClassInfo[] LoadClasses(String path) {
		List<ClassInfo> classes = new ArrayList<ClassInfo>();

		ZipInputStream zip;
		try {
			zip = new ZipInputStream(new FileInputStream(path));

			for (ZipEntry entry = zip.getNextEntry(); entry != null; entry = zip.getNextEntry()) {
				String name = entry.getName();
				if (!entry.isDirectory() && name.toLowerCase().endsWith(".class")) {

					name = name.substring(0, name.length() - ".class".length());
					int length = (int) entry.getSize();

					byte[] data = new byte[length];
					int read = 0;
					while (read < length) {
						read += zip.read(data, read, length - read);
					}

					classes.add(new ClassInfo(name.replace('/', '.'), data));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return classes.toArray(new ClassInfo[0]);
	}

	public void LoadAllMods(String path) {
		String[] pathMods = GetModFiles(new File(path));

		ClassTransformer transformer = new ClassTransformer();

		for (String pathMod : pathMods) {
			ClassInfo[] classes = LoadClasses(pathMod);
			for (ClassInfo classInfo : classes) {
				transformer.LoadClass(classInfo.name, classInfo.data);
			}
		}
	}

}
