package darkshadow44.compatibility.core;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multimap;
import com.google.common.eventbus.EventBus;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.LoaderState.ModState;
import darkshadow44.compatibility.common.ResourcePack;
import darkshadow44.compatibility.version.v1_2_5.sandbox.Core;
import darkshadow44.compatibility.version.v1_2_5.sandbox.net.minecraft.src.ModLoader;
import helper.ReflectionHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.IResourcePack;
import scala.Console;

public class ModController {

	String path;

	public ModController(String path) {
		this.path = path;
	}

	public void AddForgeMods(Class[] classes) {
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
		modStates = ArrayListMultimap.create((Multimap) ReflectionHelper.getPrivateField(fmlLoadController, "modStates"));
		activeModList = new ArrayList((List) ReflectionHelper.getPrivateField(fmlLoadController, "activeModList"));
		eventChannelsImmutable = (ImmutableMap<String, EventBus>) ReflectionHelper.getPrivateField(fmlLoadController, "eventChannels");
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

	public ResourcePack resourcePack = new ResourcePack();

	void registerTexturePack() {
		FMLClientHandler INSTANCE;
		List<IResourcePack> resourcePackList;
		Map<String, IResourcePack> resourcePackMap;

		INSTANCE = (FMLClientHandler) ReflectionHelper.getPrivateField(FMLClientHandler.class, "INSTANCE");
		resourcePackList = (List<IResourcePack>) ReflectionHelper.getPrivateField(INSTANCE, "resourcePackList");
		resourcePackMap = (Map<String, IResourcePack>) ReflectionHelper.getPrivateField(INSTANCE, "resourcePackMap");

		resourcePackList.add(resourcePack);
		resourcePackMap.put("compat", resourcePack);

		Minecraft.getMinecraft().refreshResources();
	}

	public void LoadMods() {
		ArchiveHandler archiveHandler = new ArchiveHandler();
		Class[] baseMods = archiveHandler.LoadAllMods(path);

		ModLoader.tmpLocale = "";
		for (Class mod : baseMods) {
			try {
				mod.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}

		try {
			Core.classLoader.addResource("lang/en_US.lang", ModLoader.tmpLocale.getBytes("UTF8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		registerTexturePack();
		Console.out().println("Loaded successfully.");
	}
}
