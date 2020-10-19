package de.darkshadow44.compatibility.core.layer;

import java.io.File;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.darkshadow44.compatibility.core.CompatibilityMod;
import de.darkshadow44.compatibility.core.ConstructorInfo;
import de.darkshadow44.compatibility.core.FieldInfo;
import de.darkshadow44.compatibility.core.MethodInfo;
import de.darkshadow44.compatibility.core.RegistrationInfoBlock;
import de.darkshadow44.compatibility.core.RegistrationInfoIcon;
import de.darkshadow44.compatibility.core.RegistrationInfoItem;
import de.darkshadow44.compatibility.core.loader.CompatibilityModLoader;
import de.darkshadow44.compatibility.core.model.variabletexture.ModelItemVariableTexture;
import de.darkshadow44.compatibility.sandbox.v1_7_10.cpw.mods.fml.common.Compat_Mod;
import de.darkshadow44.compatibility.sandbox.v1_7_10.cpw.mods.fml.common.Compat_Mod_EventHandler;
import de.darkshadow44.compatibility.sandbox.v1_7_10.cpw.mods.fml.common.Compat_Mod_Instance;
import de.darkshadow44.compatibility.sandbox.v1_7_10.cpw.mods.fml.common.Compat_SidedProxy;
import de.darkshadow44.compatibility.sandbox.v1_7_10.cpw.mods.fml.common.event.Compat_FMLPreInitializationEvent;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.texture.Wrapper_IIconRegister;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item.CompatI_Item;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item.Compat_Item;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

public class CompatibilityLayer_1_7_10 extends CompatibilityLayer {

	public List<RegistrationInfoBlock> blocksToRegister = new ArrayList<>();
	public List<RegistrationInfoItem> itemsToRegister = new ArrayList<>();
	public List<RegistrationInfoIcon> iconsToRegister = new ArrayList<>();
	public Map<String, String> translationsToRegister = new HashMap<>();

	public CompatibilityLayer_1_7_10(String pathSandbox) {
		super(pathSandbox);
	}

	private void registerTranslation(String key) {
		String text = translationsToRegister.get(key);
		String lines[] = text.split("\n");

		StringBuilder json = new StringBuilder();
		json.append("{\n");

		boolean first = true;
		for (String line : lines) {
			line = line.trim();
			if (line.length() > 1) {
				String split[] = line.split("=");

				if (first) {
					first = false;
				} else {
					json.append(",\n");
				}
				json.append("\titem.\"" + split[0] + "\" = " + "\"" + split[1] + "\"");
			}
		}

		json.append("\n}\n");

		// classLoader.addResource("/" + MODID + "/lang/" + key + ".json",
		// json.toString().getBytes());
	}

	private List<String> findMods(List<Class<?>> classes) {
		List<String> mods = new ArrayList<>();
		for (Class<?> c : classes) {
			Annotation annotation = c.getAnnotation(Compat_Mod.class);
			if (annotation != null)
				mods.add(c.getName());
		}
		return mods;
	}

	@Override
	public void loadMods(File modsDirectory, Side side) {
		File dir = new File(modsDirectory, version);
		dir.mkdirs();
		CompatibilityModLoader loader = new CompatibilityModLoader(this);
		List<Class<?>> modClasses = loader.loadAllMods(dir);
		List<String> modClassNames = findMods(modClasses);

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

	@Override
	public void preInit(FMLPreInitializationEvent event) {
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

		// Register translations
		for (String key : translationsToRegister.keySet()) {
			registerTranslation(key);
		}
	}

	@Override
	public void onBlocksRegistration(Register<Block> blockRegisterEvent) {
		for (RegistrationInfoBlock block : blocksToRegister) {
			blockRegisterEvent.getRegistry().register(block.getBlock());
		}
	}

	@Override
	public void onItemsRegistration(Register<Item> itemRegisterEvent) {
		for (RegistrationInfoItem itemRegister : itemsToRegister) {
			Item item = itemRegister.getItem();
			item.setRegistryName(CompatibilityMod.MODID, itemRegister.getName());
			itemRegisterEvent.getRegistry().register(item);
		}
	}

	@Override
	public void registerModels(ModelRegistryEvent evt) {
		for (RegistrationInfoItem itemRegister : itemsToRegister) {
			Item item = itemRegister.getItem();
			ModelLoader.setCustomMeshDefinition(item, stack -> ModelItemVariableTexture.LOCATION);
			ModelBakery.registerItemVariants(item, ModelItemVariableTexture.LOCATION);
		}
	}

	@Override
	public void registerTextures(TextureStitchEvent.Pre evt) {
		TextureMap map = evt.getMap();
		for (RegistrationInfoIcon icon : iconsToRegister) {
			String name = icon.getName().replace(":", "_");
			map.registerSprite(new ResourceLocation(CompatibilityMod.MODID, "items/" + name));
		}
	}

	@Override
	public void handleResource(String name, byte[] data) {
		if (name.endsWith(".lang")) {
			String split[] = name.split("/");
			String lang = split[split.length - 1];
			lang = lang.substring(0, lang.length() - ".lang".length());

			String text = new String(data).replace("\r", "");

			if (translationsToRegister.containsKey(lang)) {
				text = translationsToRegister.get(lang) + "\n" + text;
			}
			translationsToRegister.put(lang, text);
		}

		if (name.endsWith(".png"))
			CompatibilityMod.classLoader.addResource(name, data);
	}

}
