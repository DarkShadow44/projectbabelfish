package de.darkshadow44.compatibility.core.layer;

import java.io.File;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;

import de.darkshadow44.compatibility.core.CompatibilityMod;
import de.darkshadow44.compatibility.core.ConstructorInfo;
import de.darkshadow44.compatibility.core.FieldInfo;
import de.darkshadow44.compatibility.core.MethodInfo;
import de.darkshadow44.compatibility.core.RegistrationInfoBlock;
import de.darkshadow44.compatibility.core.RegistrationInfoItem;
import de.darkshadow44.compatibility.core.loader.CompatibilityModLoader;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.Compat_Mod;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.Compat_Mod_EventHandler;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.Compat_SidedProxy;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.event.Compat_FMLPreInitializationEvent;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.TextureStitchEvent.Pre;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

public class CompatibilityLayer_1_10_2 extends CompatibilityLayer {

	public List<RegistrationInfoBlock> blocksToRegister = new ArrayList<>();
	public List<RegistrationInfoItem> itemsToRegister = new ArrayList<>();
	public Map<String, String> translationsToRegister = new HashMap<>();

	public CompatibilityLayer_1_10_2(String pathSandbox) {
		super(pathSandbox);
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

		// HACK TODO dependencies
		modClassNames = Lists.reverse(modClassNames);

		// Construct mod objects
		for (String modClassName : modClassNames) {
			ConstructorInfo ctor = new ConstructorInfo(modClassName);
			Object mod = ctor.tryConstruct();
			mods.add(mod);
		}

		// Fill instances TODO
		/*for (Object mod : mods) {
			FieldInfo<?> instance = new FieldInfo<>(mod, Compat_Mod_Instance.class);
			instance.trySetValue(mod);
		}*/

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
	}

	@Override
	public void onBlocksRegistration(Register<Block> blockRegisterEvent) {
		for (RegistrationInfoBlock blockRegister : blocksToRegister) {
			// TODO location?
			Block block = blockRegister.getBlock();
			if (blockRegister.getLocation() != null) {
				block.setRegistryName(blockRegister.getLocation());
			}

			blockRegisterEvent.getRegistry().register(block);
		}
	}

	@Override
	public void onItemsRegistration(Register<Item> itemRegisterEvent) {
		for (RegistrationInfoItem itemRegister : itemsToRegister) {
			Item item = itemRegister.getItem();
			if (itemRegister.getLocation() != null) {
				item.setRegistryName(itemRegister.getLocation());
			}
			itemRegisterEvent.getRegistry().register(item);
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

	@Override
	public void registerModels(ModelRegistryEvent evt) {

	}

	@Override
	public void registerTextures(Pre evt) {

	}

}
