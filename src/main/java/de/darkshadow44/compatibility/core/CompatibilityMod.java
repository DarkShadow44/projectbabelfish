package de.darkshadow44.compatibility.core;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import de.darkshadow44.compatibility.core.layer.CompatibilityLayer;
import de.darkshadow44.compatibility.core.layer.CompatibilityLayer_1_10_2;
import de.darkshadow44.compatibility.core.layer.CompatibilityLayer_1_7_10;
import de.darkshadow44.compatibility.core.loader.MemoryClassLoader;
import de.darkshadow44.compatibility.core.model.variabletexture.ModelLoaderItemVariableTexture;
import de.darkshadow44.compatibility.core.resources.ResourcePack;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.item.Item;
import net.minecraft.launchwrapper.Launch;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@Mod(modid = CompatibilityMod.MODID, name = CompatibilityMod.NAME, version = CompatibilityMod.VERSION)
@EventBusSubscriber
public class CompatibilityMod {
	public static final String MODID = "compatibility";
	public static final String NAME = "Compatibility Mod";
	public static final String VERSION = "1.0";
	public static final boolean DUMP_CLASSES = true;

	private final ResourcePack resourcePack = new ResourcePack();

	private static List<CompatibilityLayer> layers = new ArrayList<>();
	public static CompatibilityLayer_1_7_10 LAYER_1_7_10 = new CompatibilityLayer_1_7_10("1.7.10");
	public static CompatibilityLayer_1_10_2 LAYER_1_10_2 = new CompatibilityLayer_1_10_2("1.10.2");

	static {
		layers.add(LAYER_1_7_10);
		layers.add(LAYER_1_10_2);
	}

	public static MemoryClassLoader classLoader;

	static {
		File file = new File("/home/fabian/Programming/Minecraft/Mods/CompatibilityMod/mod/TEMP_CLASSES/");
		URL[] urls = null;
		try {
			urls = new URL[] { file.toURI().toURL() };
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}

		classLoader = new MemoryClassLoader(urls, Launch.classLoader);
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		registerTexturePack();

		File directoryMods = new File(event.getModConfigurationDirectory().getParentFile(), "mods");

		for (CompatibilityLayer layer : layers) {
			layer.generateClasses();
			layer.loadMods(directoryMods, event.getSide());
			layer.preInit(event);
		}
		Minecraft.getMinecraft().refreshResources(); // Refresh for models
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		for (CompatibilityLayer layer : layers) {
			layer.init(event);
		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	void postInit(FMLPostInitializationEvent event) {
		Minecraft.getMinecraft().refreshResources(); // Refresh to translations
	}

	@SubscribeEvent
	public static void onBlocksRegistration(final RegistryEvent.Register<Block> blockRegisterEvent) {
		for (CompatibilityLayer layer : layers) {
			layer.onBlocksRegistration(blockRegisterEvent);
		}
	}

	@SubscribeEvent
	public static void onItemsRegistration(final RegistryEvent.Register<Item> itemRegisterEvent) {
		for (CompatibilityLayer layer : layers) {
			layer.onItemsRegistration(itemRegisterEvent);
		}
	}

	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent evt) {
		ModelLoaderRegistry.registerLoader(ModelLoaderItemVariableTexture.INSTANCE);
		for (CompatibilityLayer layer : layers) {
			layer.registerModels(evt);
		}
	}

	@SubscribeEvent
	public static void registerTextures(TextureStitchEvent.Pre evt) {
		for (CompatibilityLayer layer : layers) {
			layer.registerTextures(evt);
		}
	}

	@SuppressWarnings({ "unchecked" })
	void registerTexturePack() {
		FMLClientHandler INSTANCE;
		List<IResourcePack> resourcePackList;
		Map<String, IResourcePack> resourcePackMap;

		INSTANCE = (FMLClientHandler) ReflectionHelper.getPrivateField(FMLClientHandler.class, "INSTANCE");
		resourcePackList = (List<IResourcePack>) ReflectionHelper.getPrivateField(INSTANCE, "resourcePackList");
		resourcePackMap = (Map<String, IResourcePack>) ReflectionHelper.getPrivateField(INSTANCE, "resourcePackMap");

		resourcePackList.add(resourcePack);
		resourcePackMap.put("compat", resourcePack);
	}

	@SubscribeEvent
	public static void onClientTick(TickEvent.ClientTickEvent event) {
		for (CompatibilityLayer layer : layers) {
			layer.onClientTick(event);
		}
	}

	@SubscribeEvent
	public static void onRightclickBlock(PlayerInteractEvent.RightClickBlock event) {
		for (CompatibilityLayer layer : layers) {
			layer.onRightclickBlock(event);
		}
	}

	@SubscribeEvent
	public static void onModelBake(ModelBakeEvent event) {
		for (CompatibilityLayer layer : layers) {
			layer.onModelBake(event);
		}
	}

	@SubscribeEvent
	public static void onDrawBlockHighlight(DrawBlockHighlightEvent event) {
		for (CompatibilityLayer layer : layers) {
			layer.onDrawBlockHighlight(event);
		}
	}
}
