package de.darkshadow44.compatibility.core.loader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import de.darkshadow44.compatibility.core.CompatibilityMod;
import de.darkshadow44.compatibility.sandbox.v1_7_10.cpw.mods.fml.common.Compat_Mod;

public class CompatibilityModLoader {

	public String[] getModFiles(File path) {
		List<String> files = new ArrayList<String>();

		for (File file : path.listFiles()) {
			if (file.isFile()) {
				String fileName = file.getPath().toLowerCase();
				if (fileName.endsWith(".zip") || fileName.endsWith(".jar"))
					files.add(file.getPath());
			}
		}
		return files.toArray(new String[0]);
	}

	byte[] readFileInZip(InputStream stream, ZipEntry entry) throws IOException {
		int length = (int) entry.getSize();

		byte[] data = new byte[length];
		int read = 0;
		while (read < length) {
			read += stream.read(data, read, length - read);
		}
		return data;
	}

	public byte[][] readZip(String path) {
		List<byte[]> classes = new ArrayList<byte[]>();

		ZipFile zipFile;
		try {
			zipFile = new ZipFile(path);

			Enumeration<? extends ZipEntry> entries = zipFile.entries();

			while (entries.hasMoreElements()) {
				ZipEntry entry = entries.nextElement();

				if (!entry.isDirectory()) {
					String nameLower = entry.getName().toLowerCase();
					InputStream stream = zipFile.getInputStream(entry);
					byte[] data = readFileInZip(stream, entry);
					stream.close();

					if (nameLower.endsWith(".class"))
						classes.add(data);

					if (nameLower.endsWith(".txt") || nameLower.endsWith(".png"))
						CompatibilityMod.classLoader.addResource(entry.getName(), data);
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return classes.toArray(new byte[0][]);
	}

	void findMods(List<String> mods, Class<?>[] classes) {
		for (Class<?> c : classes) {
			Annotation annotation = c.getAnnotation(Compat_Mod.class);
			if (annotation != null)
				mods.add(c.getName());
		}
	}

	public String[] loadAllMods(File path) {
		String[] pathMods = getModFiles(path);

		CompatibilityClassLoader transformer = new CompatibilityClassLoader(CompatibilityMod.classLoader);

		List<String> mods = new ArrayList<>();

		for (String pathMod : pathMods) {
			byte[][] classesBytes = readZip(pathMod);
			Class<?>[] classesLoaded = transformer.loadClasses(classesBytes);
			findMods(mods, classesLoaded);
		}

		return mods.toArray(new String[0]);
	}
}
