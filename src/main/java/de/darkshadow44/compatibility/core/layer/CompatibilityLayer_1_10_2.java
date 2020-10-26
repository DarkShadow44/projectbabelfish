package de.darkshadow44.compatibility.core.layer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

import de.darkshadow44.compatibility.core.CompatibilityMod;
import de.darkshadow44.compatibility.core.ConstructorInfo;
import de.darkshadow44.compatibility.core.FieldInfo;
import de.darkshadow44.compatibility.core.MethodInfo;
import de.darkshadow44.compatibility.core.ModInfo;
import de.darkshadow44.compatibility.core.RegistrationInfoBlock;
import de.darkshadow44.compatibility.core.RegistrationInfoItem;
import de.darkshadow44.compatibility.core.loader.CompatibilityModLoader;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.event.entity.player.Compat_PlayerInteractEvent_RightClickBlock;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.Compat_Mod;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.Compat_Mod_EventHandler;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.Compat_SidedProxy;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.event.Compat_FMLInitializationEvent;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.event.Compat_FMLPreInitializationEvent;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.eventhandler.Compat_SubscribeEvent;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.gameevent.Compat_TickEvent_ClientTickEvent;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.TextureStitchEvent.Pre;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.relauncher.Side;

public class CompatibilityLayer_1_10_2 extends CompatibilityLayer {

	public List<RegistrationInfoBlock> blocksToRegister = new ArrayList<>();
	public List<RegistrationInfoItem> itemsToRegister = new ArrayList<>();
	public List<ModelLocationInfo> modelLocationInfo = new ArrayList<>();

	public String currentModId = "";

	public CompatibilityLayer_1_10_2(String pathSandbox) {
		super(pathSandbox);
	}

	private List<ModInfo> findMods(List<Class<?>> classes) {
		List<ModInfo> mods = new ArrayList<>();
		for (Class<?> c : classes) {
			Compat_Mod annotation = c.getAnnotation(Compat_Mod.class);
			if (annotation != null) {
				mods.add(new ModInfo(annotation.modid(), c.getName()));
			}
		}
		return mods;
	}

	@Override
	public void loadMods(File modsDirectory, Side side) {
		File dir = new File(modsDirectory, version);
		dir.mkdirs();
		CompatibilityModLoader loader = new CompatibilityModLoader(this);
		List<Class<?>> modClasses = loader.loadAllMods(dir);
		List<ModInfo> modInfos = findMods(modClasses);

		// HACK TODO dependencies
		modInfos = Lists.reverse(modInfos);

		mods.addAll(modInfos);

		// Construct mod objects
		for (ModInfo modInfo : modInfos) {
			ConstructorInfo ctor = new ConstructorInfo(modInfo.className);
			Object mod = ctor.tryConstruct();
			modInfo.setMod(mod);
		}

		// Fill instances TODO
		/*for (Object mod : mods) {
			FieldInfo<?> instance = new FieldInfo<>(mod, Compat_Mod_Instance.class);
			instance.trySetValue(mod);
		}*/

		// Fill proxys
		for (ModInfo mod : mods) {
			FieldInfo<Compat_SidedProxy> instance = new FieldInfo<>(mod.getMod(), Compat_SidedProxy.class);
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
				mod.setProxy(proxy);
			}
		}
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		for (ModInfo modInfo : mods) {
			currentModId = modInfo.id;
			MethodInfo<?> methodPreInit = new MethodInfo<>(modInfo.getMod(), Compat_Mod_EventHandler.class, Compat_FMLPreInitializationEvent.class);
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

		for (ModelLocationInfo itemRegister : modelLocationInfo) {
			ModelLoader.setCustomModelResourceLocation(itemRegister.item, itemRegister.metadata, itemRegister.location);
		}
	}

	private String fixBlockstate(String text) {
		text = text.replace("\"inventory\": { }", "\"inventory\": [{ }]");
		return text;
	}

	@Override
	public void handleResource(String name, byte[] data) {
		name = name.substring("assets/".length());
		if (name.endsWith(".png") || name.endsWith(".json")) {
			String[] split = name.split("\\/");

			if (split[1].equals("blockstates")) {
				String text = new String(data);
				text = fixBlockstate(text);
				data = text.getBytes();

				split[1] = "models/item";
				CompatibilityMod.classLoader.addResource(String.join("/", split), data);
			}
			CompatibilityMod.classLoader.addResource(name, data);
		}

		if (name.endsWith(".lang")) {
			registerTranslation(name, new String(data));
		}
	}

	private void registerTranslation(String name, String text) {
		CompatibilityMod.classLoader.addResource(name, text.getBytes());
	}

	@Override
	public void registerModels(ModelRegistryEvent evt) {
	}

	@Override
	public void registerTextures(Pre evt) {

	}

	@Override
	public void init(FMLInitializationEvent event) {
		for (ModInfo modInfo : mods) {
			currentModId = modInfo.id;
			MethodInfo<?> methodInit = new MethodInfo<>(modInfo.getMod(), Compat_Mod_EventHandler.class, Compat_FMLInitializationEvent.class);
			methodInit.tryInvoke(new Compat_FMLInitializationEvent(event));
		}
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		// TODO
	}

	@Override
	public void onClientTick(ClientTickEvent event) {
		for (ModInfo modInfo : mods) {
			MethodInfo<?> method = new MethodInfo<>(modInfo.getProxy(), Compat_SubscribeEvent.class, Compat_TickEvent_ClientTickEvent.class);
			method.tryInvoke(new Compat_TickEvent_ClientTickEvent(event));
		}
	}

	@Override
	public void onRightclickBlock(RightClickBlock event) {
		for (ModInfo modInfo : mods) {
			MethodInfo<?> method = new MethodInfo<>(modInfo.getProxy(), Compat_SubscribeEvent.class, Compat_PlayerInteractEvent_RightClickBlock.class);
			method.tryInvoke(new Compat_PlayerInteractEvent_RightClickBlock(event));
		}
	}

}
