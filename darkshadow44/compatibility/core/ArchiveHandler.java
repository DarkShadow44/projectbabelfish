package darkshadow44.compatibility.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.LoaderState.ModState;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.ModMetadata;
import darkshadow44.compatibility.core.asm.ClassTransformer;
import darkshadow44.compatibility.version.v1_2_5.sandbox.net.minecraft.src.BaseMod;
import helper.ReflectionHelper;
import scala.Console;

public class ArchiveHandler {

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

	public byte[][] LoadClasses(String path) {
		List<byte[]> classes = new ArrayList<byte[]>();

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

					classes.add(data);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return classes.toArray(new byte[0][]);
	}

	void FindBasemods(List<Class> baseMods, Class[] classes) {
		Class cBasemod = BaseMod.class;
		for (Class c : classes) {
			if (cBasemod.isAssignableFrom(c))
				baseMods.add(c);
		}
	}

	void AddForgeMods(Class[] classes) {
		Object fmlLoader = Loader.instance();
		Object fmlLoadController = ReflectionHelper.getPrivateField(fmlLoader, "modController");

		List<ModContainer> mods = new ArrayList((List) ReflectionHelper.getPrivateField(fmlLoader, "mods"));
		Map<String, ModContainer> namedMods = new HashMap<String, ModContainer>(
				(Map) ReflectionHelper.getPrivateField(fmlLoader, "namedMods"));
		Multimap<String, ModState> modStates = ArrayListMultimap
				.create((Multimap) ReflectionHelper.getPrivateField(fmlLoadController, "modStates"));
		List<ModContainer> activeModList = new ArrayList(
				(List) ReflectionHelper.getPrivateField(fmlLoadController, "activeModList"));
		for (Class c : classes) {
			ModMetadata modFMLMeta = new ModMetadata();
			modFMLMeta.authorList = Arrays.asList("[missing]");
			modFMLMeta.name = "[Compat-1.2.5] " + c.getSimpleName();
			modFMLMeta.modId = "[missing]";
			modFMLMeta.version = "[missing]";
			modFMLMeta.description = "[missing]";

			ModContainer modFMLContainer = new CompatModContainer(modFMLMeta);

			mods.add(modFMLContainer);
			namedMods.put(modFMLMeta.modId, modFMLContainer);
			modStates.put(modFMLMeta.modId, ModState.AVAILABLE);
			activeModList.add(modFMLContainer);
		}
		ReflectionHelper.setPrivateField(fmlLoader, "mods", mods);
		ReflectionHelper.setPrivateField(fmlLoader, "namedMods", namedMods);
		ReflectionHelper.setPrivateField(fmlLoadController, "modStates", modStates);
		ReflectionHelper.setPrivateField(fmlLoadController, "activeModList", activeModList);
	}

	public void LoadAllMods(String path) {
		String[] pathMods = GetModFiles(new File(path));

		ClassTransformer transformer = new ClassTransformer();

		List<Class> baseMods = new ArrayList<Class>();

		for (String pathMod : pathMods) {
			byte[][] classesBytes = LoadClasses(pathMod);
			Class[] classesLoaded = transformer.LoadClasses(classesBytes);
			FindBasemods(baseMods, classesLoaded);
		}

		try {
			baseMods.get(0).newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}

		AddForgeMods(baseMods.toArray(new Class[0]));
	}

}
