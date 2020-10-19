package de.darkshadow44.compatibility.core.layer;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.darkshadow44.compatibility.autogen.ClassGenerator;
import de.darkshadow44.compatibility.core.CompatibilityMod;
import de.darkshadow44.compatibility.core.ConstructorInfo;
import de.darkshadow44.compatibility.core.FieldInfo;
import de.darkshadow44.compatibility.core.MethodInfo;
import de.darkshadow44.compatibility.core.RegistrationInfoBlock;
import de.darkshadow44.compatibility.core.RegistrationInfoIcon;
import de.darkshadow44.compatibility.core.RegistrationInfoItem;
import de.darkshadow44.compatibility.core.loader.CompatibilityModLoader;
import de.darkshadow44.compatibility.core.model.variabletexture.ModelItemVariableTexture;
import de.darkshadow44.compatibility.sandbox.v1_7_10.cpw.mods.fml.common.Compat_Mod_EventHandler;
import de.darkshadow44.compatibility.sandbox.v1_7_10.cpw.mods.fml.common.Compat_Mod_Instance;
import de.darkshadow44.compatibility.sandbox.v1_7_10.cpw.mods.fml.common.Compat_SidedProxy;
import de.darkshadow44.compatibility.sandbox.v1_7_10.cpw.mods.fml.common.event.Compat_FMLPreInitializationEvent;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.TextureStitchEvent.Pre;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

public abstract class CompatibilityLayer {

	static final String prefixFake = "Compat_";
	static final String prefixInterface = "CompatI_";
	static final String prefixReal = "CompatReal_";
	static final String prefixGet = "Compat_get_";
	static final String prefixSet = "Compat_set_";

	public List<RegistrationInfoBlock> blocksToRegister = new ArrayList<>();
	public List<RegistrationInfoItem> itemsToRegister = new ArrayList<>();
	public List<RegistrationInfoIcon> iconsToRegister = new ArrayList<>();
	public Map<String, String> translationsToRegister = new HashMap<>();

	private final String pathSandbox;
	private final String version;

	private final List<Object> mods = new ArrayList<Object>();

	public CompatibilityLayer(String version) {
		this.pathSandbox = "de/darkshadow44/compatibility/sandbox/v" + version.replace(".", "_") + "/";
		this.version = version;
	}

	public String getPathSandbox() {
		return pathSandbox;
	}

	public String getPrefixedClassname(String name) {
		String[] names = name.replace('$', '_').split("\\/");
		names[names.length - 1] = prefixFake + names[names.length - 1];
		return pathSandbox + String.join("/", names);
	}

	public String getPrefixFake() {
		return prefixFake;
	}

	public String getPrefixReal() {
		return prefixReal;
	}

	public String getPrefixInterface() {
		return prefixInterface;
	}

	public String getPrefixGet() {
		return prefixGet;
	}

	public String getPrefixSet() {
		return prefixSet;
	}

	public void generateClasses() {
		ClassGenerator classGenerator = new ClassGenerator(this);
		classGenerator.tryGenerateRealClasses();
	}

	public void loadMods(File modsDirectory, Side side) {
		File dir = new File(modsDirectory, version);
		dir.mkdirs();
		CompatibilityModLoader loader = new CompatibilityModLoader(this);
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
				className = getPrefixedClassname(className);
				className = className.replace("/", ".");
				ConstructorInfo ctor = new ConstructorInfo(className);
				Object proxy = ctor.tryConstruct();
				instance.trySetValue(proxy);
			}
		}
	}

	public void preInit(FMLPreInitializationEvent event) {
		for (Object mod : mods) {
			MethodInfo<?> methodPreInit = new MethodInfo<>(mod, Compat_Mod_EventHandler.class, Compat_FMLPreInitializationEvent.class);
			methodPreInit.tryInvoke(new Compat_FMLPreInitializationEvent(event));
		}
	}

	public void onBlocksRegistration(Register<Block> blockRegisterEvent) {
		for (RegistrationInfoBlock block : blocksToRegister) {
			blockRegisterEvent.getRegistry().register(block.getBlock());
		}
	}

	public void onItemsRegistration(Register<Item> itemRegisterEvent) {
		for (RegistrationInfoItem itemRegister : itemsToRegister) {
			Item item = itemRegister.getItem();
			item.setRegistryName(CompatibilityMod.MODID, itemRegister.getName());
			itemRegisterEvent.getRegistry().register(item);
		}
	}

	public void registerModels(ModelRegistryEvent evt) {
		for (RegistrationInfoItem itemRegister : itemsToRegister) {
			Item item = itemRegister.getItem();
			ModelLoader.setCustomMeshDefinition(item, stack -> ModelItemVariableTexture.LOCATION);
			ModelBakery.registerItemVariants(item, ModelItemVariableTexture.LOCATION);
		}
	}

	public void registerTextures(Pre evt) {
		TextureMap map = evt.getMap();
		for (RegistrationInfoIcon icon : iconsToRegister) {
			String name = icon.getName().replace(":", "_");
			map.registerSprite(new ResourceLocation(CompatibilityMod.MODID, "items/" + name));
		}
	}
}
