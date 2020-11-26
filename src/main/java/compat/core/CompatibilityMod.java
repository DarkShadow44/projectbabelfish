package compat.core;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import compat.autogen.ClassGenerator;
import compat.core.layer.CompatibilityLayer;
import compat.core.layer.CompatibilityLayer_1_10_2;
import compat.core.layer.CompatibilityLayer_1_7_10;
import compat.core.loader.MemoryClassLoader;
import compat.core.model.variabletexture.item.ModelLoaderItemVariableTexture;
import compat.core.resources.ResourcePack;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.item.Item;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.event.AttachCapabilitiesEvent;
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

	public static List<CompatibilityLayer> LAYERS = new ArrayList<>();
	public static CompatibilityLayer CURRENT_LAYER;
	private static CompatibilityLayer_1_7_10 LAYER_1_7_10 = new CompatibilityLayer_1_7_10(Version.V1_7_10);
	private static CompatibilityLayer_1_10_2 LAYER_1_10_2 = new CompatibilityLayer_1_10_2(Version.V1_10_2);

	static {
		LAYERS.add(LAYER_1_7_10);
		LAYERS.add(LAYER_1_10_2);
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

		ClassGenerator.tryGenerateRealClasses();

		File directoryMods = new File(event.getModConfigurationDirectory().getParentFile(), "mods");

		for (CompatibilityLayer layer : LAYERS) {
			CURRENT_LAYER = layer;
			layer.loadMods(directoryMods, event.getSide());
			layer.preInit(event);
		}
		CURRENT_LAYER = null;
		Minecraft.getMinecraft().refreshResources(); // Refresh for models
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		for (CompatibilityLayer layer : LAYERS) {
			CURRENT_LAYER = layer;
			layer.init(event);
		}
		CURRENT_LAYER = null;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	void postInit(FMLPostInitializationEvent event) {
		Minecraft.getMinecraft().refreshResources(); // Refresh for translations
	}

	@SubscribeEvent
	public static void onBlocksRegistration(final RegistryEvent.Register<Block> blockRegisterEvent) {
		for (CompatibilityLayer layer : LAYERS) {
			layer.onBlocksRegistration(blockRegisterEvent);
		}
	}

	@SubscribeEvent
	public static void onItemsRegistration(final RegistryEvent.Register<Item> itemRegisterEvent) {
		for (CompatibilityLayer layer : LAYERS) {
			layer.onItemsRegistration(itemRegisterEvent);
		}
	}

	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent evt) {
		ModelLoaderRegistry.registerLoader(ModelLoaderItemVariableTexture.INSTANCE);
		for (CompatibilityLayer layer : LAYERS) {
			layer.registerModels(evt);
		}
	}

	@SubscribeEvent
	public static void registerTextures(TextureStitchEvent.Pre evt) {
		for (CompatibilityLayer layer : LAYERS) {
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
		for (CompatibilityLayer layer : LAYERS) {
			layer.onClientTick(event);
		}
	}

	@SubscribeEvent
	public static void onServerTick(TickEvent.ServerTickEvent event) {
		for (CompatibilityLayer layer : LAYERS) {
			layer.onServerTick(event);
		}
	}

	@SubscribeEvent
	public static void onRightclickBlock(PlayerInteractEvent.RightClickBlock event) {
		for (CompatibilityLayer layer : LAYERS) {
			layer.onRightclickBlock(event);
		}
	}

	@SubscribeEvent
	public static void onModelBake(ModelBakeEvent event) {
		for (CompatibilityLayer layer : LAYERS) {
			layer.onModelBake(event);
		}
	}

	@SubscribeEvent
	public static void onDrawBlockHighlight(DrawBlockHighlightEvent event) {
		for (CompatibilityLayer layer : LAYERS) {
			layer.onDrawBlockHighlight(event);
		}
	}

	@SubscribeEvent
	public static void onAttachCapabilities(AttachCapabilitiesEvent<TileEntity> event) {
		for (CompatibilityLayer layer : LAYERS) {
			layer.onAttachCapabilities(event);
		}
	}
}
