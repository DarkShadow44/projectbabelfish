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
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multimap;
import com.google.common.eventbus.EventBus;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.LoaderState.ModState;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.ModMetadata;
import darkshadow44.compatibility.core.asm.ClassTransformer;
import darkshadow44.compatibility.core.asm.MemoryClassLoader;
import darkshadow44.compatibility.version.v1_2_5.sandbox.Core;
import darkshadow44.compatibility.version.v1_2_5.sandbox.net.minecraft.src.BaseMod;
import helper.ReflectionHelper;
import net.minecraft.launchwrapper.Launch;
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

	byte[] LoadFile(ZipInputStream zip, ZipEntry entry) throws IOException {
		int length = (int) entry.getSize();

		byte[] data = new byte[length];
		int read = 0;
		while (read < length) {
			read += zip.read(data, read, length - read);
		}
		return data;
	}

	public byte[][] LoadClasses(String path) {
		List<byte[]> classes = new ArrayList<byte[]>();

		ZipInputStream zip;
		try {
			zip = new ZipInputStream(new FileInputStream(path));

			for (ZipEntry entry = zip.getNextEntry(); entry != null; entry = zip.getNextEntry()) {
				String nameLower = entry.getName().toLowerCase();
				if (!entry.isDirectory()) {
					byte[] data = LoadFile(zip, entry);

					if (nameLower.endsWith(".class"))
						classes.add(data);

					if (nameLower.endsWith(".txt") || nameLower.endsWith(".png"))
						Core.classLoader.addResource(entry.getName(), data);
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

		List<ModContainer> mods;
		Map<String, ModContainer> namedMods;
		Multimap<String, ModState> modStates;
		List<ModContainer> activeModList;
		ImmutableMap<String, EventBus> eventChannelsImmutable;
		HashMap<String, EventBus> eventChannels;

		mods = new ArrayList((List) ReflectionHelper.getPrivateField(fmlLoader, "mods"));
		namedMods = new HashMap<String, ModContainer>((Map) ReflectionHelper.getPrivateField(fmlLoader, "namedMods"));
		modStates = ArrayListMultimap
				.create((Multimap) ReflectionHelper.getPrivateField(fmlLoadController, "modStates"));
		activeModList = new ArrayList((List) ReflectionHelper.getPrivateField(fmlLoadController, "activeModList"));
		eventChannelsImmutable = (ImmutableMap<String, EventBus>) ReflectionHelper.getPrivateField(fmlLoadController,
				"eventChannels");
		eventChannels = new HashMap<String, EventBus>(eventChannelsImmutable);

		for (Class c : classes) {
			ModMetadata modFMLMeta = new ModMetadata();
			modFMLMeta.authorList = Arrays.asList("[missing]");
			modFMLMeta.name = "[Compat-1.2.5] " + c.getSimpleName();
			modFMLMeta.modId = modFMLMeta.name;
			modFMLMeta.version = "[missing]";
			modFMLMeta.description = "[missing]";

			ModContainer modFMLContainer = new CompatModContainer(modFMLMeta);

			mods.add(modFMLContainer);
			namedMods.put(modFMLMeta.modId, modFMLContainer);
			modStates.put(modFMLMeta.modId, ModState.AVAILABLE);
			activeModList.add(modFMLContainer);
			eventChannels.put(modFMLMeta.modId, new EventBus());
		}
		ReflectionHelper.setPrivateField(fmlLoader, "mods", mods);
		ReflectionHelper.setPrivateField(fmlLoader, "namedMods", namedMods);
		ReflectionHelper.setPrivateField(fmlLoadController, "modStates", modStates);
		ReflectionHelper.setPrivateField(fmlLoadController, "activeModList", activeModList);
		ReflectionHelper.setPrivateField(fmlLoadController, "eventChannels", ImmutableMap.copyOf(eventChannels));
	}

	public void LoadAllMods(String path) {
		String[] pathMods = GetModFiles(new File(path));

		ClassTransformer transformer = new ClassTransformer(Core.classLoader);

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
