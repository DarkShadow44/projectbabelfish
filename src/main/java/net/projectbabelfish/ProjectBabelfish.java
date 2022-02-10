package net.projectbabelfish;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.modlauncher.Launcher;
import net.minecraft.client.Minecraft;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import net.projectbabelfish.core.CompatibilityLayer;
import net.projectbabelfish.core.ReflectionHelper;
import net.projectbabelfish.core.Version;
import net.projectbabelfish.core.loader.MemoryClassLoader;

@Mod(ProjectBabelfish.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ProjectBabelfish {
	private static final Logger LOGGER = LogManager.getLogger();
	
	public static final String MODID = "projectbabelfish";
	public static final String NAME = "Project Babelfish";
	public static final String VERSION = "1.0";
	
	public static final boolean DUMP_CLASSES = true;
	public static final String DUMP_CLASS_PATH = "/home/fabian/Programming/Minecraft/Mods/CompatibilityMod/TEMP_CLASSES/";

	public static CompatibilityLayer CURRENT_LAYER;
	public static List<CompatibilityLayer> LAYERS = new ArrayList<>();
	
	static
	{
		LAYERS.add(new CompatibilityLayer(Version.V1_16));
	}
	
	public static MemoryClassLoader classLoader;
	
	static {
		File file = new File(DUMP_CLASS_PATH);
		URL[] urls = null;
		try {
			urls = new URL[] { file.toURI().toURL() };
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}

		ClassLoader parent = (ClassLoader) ReflectionHelper.getPrivateField(Launcher.INSTANCE, "classLoader");
		classLoader = new MemoryClassLoader(urls, parent);
	}

	public ProjectBabelfish() {
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		MinecraftForge.EVENT_BUS.register(this);
	}

	private void setup(final FMLCommonSetupEvent event) {
		LOGGER.info("HELLO FROM PREINIT");
		LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
	}
	
	static void registerTexturePack() {
		/*FMLClientHandler INSTANCE;
		List<PackResources> resourcePackList;
		Map<String, IResourcePack> resourcePackMap;

		INSTANCE = (FMLClientHandler) ReflectionHelper.getPrivateField(FMLClientHandler.class, "INSTANCE");
		resourcePackList = (List<IResourcePack>) ReflectionHelper.getPrivateField(INSTANCE, "resourcePackList");
		resourcePackMap = (Map<String, IResourcePack>) ReflectionHelper.getPrivateField(INSTANCE, "resourcePackMap");

		resourcePackList.add(resourcePack);
		resourcePackMap.put("compat", resourcePack);
		*/
		
		/*
		  public class ResourcePackLoader {
    		private static Map<IModFile, PathResourcePack> modResourcePacks;
		 */
	}
	
	@SubscribeEvent
	public static void PreInit(FMLConstructModEvent event) {
		registerTexturePack();

		File directoryMods = FMLPaths.MODSDIR.get().toFile();

		for (CompatibilityLayer layer : LAYERS) {
			CURRENT_LAYER = layer;
			layer.loadMods(directoryMods, LogicalSide.CLIENT);
			//layer.preInit(event);
		}
		CURRENT_LAYER = null;
		Minecraft.getInstance().reloadResourcePacks(); // Refresh for models
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {
		@SubscribeEvent
		public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
			LOGGER.info("HELLO from Register Block");
		}
	}
}
