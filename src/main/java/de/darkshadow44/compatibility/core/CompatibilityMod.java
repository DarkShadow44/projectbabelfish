package de.darkshadow44.compatibility.core;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import de.darkshadow44.compatibility.autogen.ClassGenerator;
import de.darkshadow44.compatibility.core.loader.CompatibilityClassTransformer;
import de.darkshadow44.compatibility.core.loader.CompatibilityModLoader;
import de.darkshadow44.compatibility.core.loader.MemoryClassLoader;
import de.darkshadow44.compatibility.core.model.variabletexture.ModelItemVariableTexture;
import de.darkshadow44.compatibility.core.model.variabletexture.ModelLoaderItemVariableTexture;
import de.darkshadow44.compatibility.core.resources.ResourcePack;
import de.darkshadow44.compatibility.sandbox.v1_7_10.cpw.mods.fml.common.Compat_Mod_EventHandler;
import de.darkshadow44.compatibility.sandbox.v1_7_10.cpw.mods.fml.common.Compat_Mod_Instance;
import de.darkshadow44.compatibility.sandbox.v1_7_10.cpw.mods.fml.common.Compat_SidedProxy;
import de.darkshadow44.compatibility.sandbox.v1_7_10.cpw.mods.fml.common.event.Compat_FMLPreInitializationEvent;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.texture.Wrapper_IIconRegister;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item.CompatI_Item;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item.Compat_Item;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.item.Item;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = CompatibilityMod.MODID, name = CompatibilityMod.NAME, version = CompatibilityMod.VERSION)
@EventBusSubscriber
public class CompatibilityMod {
	public static final String MODID = "compatibility";
	public static final String NAME = "Compatibility Mod";
	public static final String VERSION = "1.0";

	public static MemoryClassLoader classLoader = new MemoryClassLoader(Launch.classLoader);

	public static List<RegistrationInfoBlock> blocksToRegister = new ArrayList<>();
	public static List<RegistrationInfoItem> itemsToRegister = new ArrayList<>();
	public static List<RegistrationInfoIcon> iconsToRegister = new ArrayList<>();

	private List<Object> mods = new ArrayList<Object>();

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ClassGenerator classGenerator = new ClassGenerator();
		classGenerator.tryGenerateRealClasses();

		registerTexturePack();

		File directoryMods = new File(event.getModConfigurationDirectory().getParentFile(), "mods");
		loadMods(new File(directoryMods, "1.7.10"), event.getSide());

		// Execute preInit
		for (Object mod : mods) {
			MethodInfo<?> methodPreInit = new MethodInfo<>(mod, Compat_Mod_EventHandler.class, Compat_FMLPreInitializationEvent.class);
			methodPreInit.tryInvoke(new Compat_FMLPreInitializationEvent(event));
		}

		// Get icons to register
		Wrapper_IIconRegister iconRegister = new Wrapper_IIconRegister();
		for (RegistrationInfoItem itemRegister : itemsToRegister) {
			Compat_Item item = ((CompatI_Item) itemRegister.getItem()).getFake();
			item.Compat_func_94581_a(iconRegister);
		}
	}

	void loadMods(File dir, Side side) {
		dir.mkdirs();
		CompatibilityModLoader loader = new CompatibilityModLoader();
		String[] modClassNames = loader.loadAllMods(dir);

		// Construct mod objects
		for (String modClassName : modClassNames) {
			ConstructorInfo ctor = new ConstructorInfo(modClassName);
			Object mod = ctor.tryConstruct();
			mods.add(mod);
		}

		// Fill instances
		for (Object mod : mods) {
			FieldInfo<?> instance = new FieldInfo<>(mod, Compat_Mod_Instance.class);
			instance.trySetValue(mod);
		}

		// Fill proxys
		for (Object mod : mods) {
			FieldInfo<Compat_SidedProxy> instance = new FieldInfo<>(mod, Compat_SidedProxy.class);
			if (instance != null) {
				Compat_SidedProxy sidedProxy = instance.getAnnotation();
				String className;
				if (side == Side.CLIENT) {
					className = sidedProxy.clientSide();
				} else {
					className = sidedProxy.serverSide();
				}
				className = className.replace(".", "/");
				className = CompatibilityClassTransformer.getPrefixedClassname(className);
				className = className.replace("/", ".");
				ConstructorInfo ctor = new ConstructorInfo(className);
				Object proxy = ctor.tryConstruct();
				instance.trySetValue(proxy);
			}
		}
	}

	@SubscribeEvent
	public static void onBlocksRegistration(final RegistryEvent.Register<Block> blockRegisterEvent) {
		for (RegistrationInfoBlock block : blocksToRegister) {
			blockRegisterEvent.getRegistry().register(block.getBlock());
		}
	}

	@SubscribeEvent
	public static void onItemsRegistration(final RegistryEvent.Register<Item> itemRegisterEvent) {
		for (RegistrationInfoItem itemRegister : itemsToRegister) {
			Item item = itemRegister.getItem();
			item.setRegistryName(MODID, itemRegister.getName());
			itemRegisterEvent.getRegistry().register(item);
		}
	}

	public ResourcePack resourcePack = new ResourcePack();

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

	@EventHandler
	public void init(FMLInitializationEvent event) {

	}

	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent evt) {
		ModelLoaderRegistry.registerLoader(ModelLoaderItemVariableTexture.INSTANCE);

		for (RegistrationInfoItem itemRegister : itemsToRegister) {
			Item item = itemRegister.getItem();
			ModelLoader.setCustomMeshDefinition(item, stack -> ModelItemVariableTexture.LOCATION);
			ModelBakery.registerItemVariants(item, ModelItemVariableTexture.LOCATION);
		}
	}

	@SubscribeEvent
	public static void registerTextures(TextureStitchEvent.Pre evt) {
		TextureMap map = evt.getMap();

		for (RegistrationInfoIcon icon : iconsToRegister) {
			String name = icon.getName().replace(":", "_");
			map.registerSprite(new ResourceLocation(CompatibilityMod.MODID, "items/" + name));
		}
		map.registerSprite(new ResourceLocation(CompatibilityMod.MODID, "items/damage" + 0));
		map.registerSprite(new ResourceLocation(CompatibilityMod.MODID, "items/damage" + 1));
		map.registerSprite(new ResourceLocation(CompatibilityMod.MODID, "items/damage" + 2));
	}
}
