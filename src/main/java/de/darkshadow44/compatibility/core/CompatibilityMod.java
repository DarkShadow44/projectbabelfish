package de.darkshadow44.compatibility.core;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import de.darkshadow44.compatibility.core.layer.CompatibilityLayer;
import de.darkshadow44.compatibility.core.layer.CompatibilityLayer_1_7_10;
import de.darkshadow44.compatibility.core.loader.MemoryClassLoader;
import de.darkshadow44.compatibility.core.model.variabletexture.ModelLoaderItemVariableTexture;
import de.darkshadow44.compatibility.core.resources.ResourcePack;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.item.Item;
import net.minecraft.launchwrapper.Launch;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = CompatibilityMod.MODID, name = CompatibilityMod.NAME, version = CompatibilityMod.VERSION)
@EventBusSubscriber
public class CompatibilityMod {
	public static final String MODID = "compatibility";
	public static final String NAME = "Compatibility Mod";
	public static final String VERSION = "1.0";

	private final ResourcePack resourcePack = new ResourcePack();

	private static List<CompatibilityLayer> layers = new ArrayList<>();
	public static CompatibilityLayer LAYER_1_7_10 = new CompatibilityLayer_1_7_10("1.7.10");

	static {
		layers.add(LAYER_1_7_10);
	}

	public static MemoryClassLoader classLoader = new MemoryClassLoader(Launch.classLoader);

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		registerTexturePack();

		File directoryMods = new File(event.getModConfigurationDirectory().getParentFile(), "mods");

		for (CompatibilityLayer layer : layers) {
			layer.generateClasses();
			layer.loadMods(directoryMods, event.getSide());
			layer.preInit(event);
		}
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

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

	@SuppressWarnings({ "unchecked", "deprecation" })
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
}
