package compat.core.layer;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;

import compat.autogen.ClassGenerator;
import compat.core.CompatibilityMod;
import compat.core.ConstructorInfo;
import compat.core.FieldInfo;
import compat.core.MethodInfo;
import compat.core.ModInfo;
import compat.core.RegistrationInfoBlock;
import compat.core.RegistrationInfoItem;
import compat.core.loader.CompatibilityModLoader;
import compat.sandbox.net.minecraftforge.client.event.Compat_DrawBlockHighlightEvent;
import compat.sandbox.net.minecraftforge.client.event.Compat_ModelBakeEvent;
import compat.sandbox.net.minecraftforge.common.capabilities.Compat_Capability;
import compat.sandbox.net.minecraftforge.common.capabilities.Compat_CapabilityInject;
import compat.sandbox.net.minecraftforge.common.capabilities.Compat_CapabilityManager;
import compat.sandbox.net.minecraftforge.event.Compat_AttachCapabilitiesEvent_TileEntity;
import compat.sandbox.net.minecraftforge.event.entity.player.Compat_PlayerInteractEvent_RightClickBlock;
import compat.sandbox.net.minecraftforge.fml.common.Compat_Mod;
import compat.sandbox.net.minecraftforge.fml.common.Compat_Mod_EventHandler;
import compat.sandbox.net.minecraftforge.fml.common.Compat_SidedProxy;
import compat.sandbox.net.minecraftforge.fml.common.event.Compat_FMLInitializationEvent;
import compat.sandbox.net.minecraftforge.fml.common.event.Compat_FMLPreInitializationEvent;
import compat.sandbox.net.minecraftforge.fml.common.eventhandler.Compat_SubscribeEvent;
import compat.sandbox.net.minecraftforge.fml.common.gameevent.Compat_TickEvent_ClientTickEvent;
import compat.sandbox.net.minecraftforge.fml.common.gameevent.Compat_TickEvent_ServerTickEvent;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.TextureStitchEvent.Pre;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ServerTickEvent;
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
				mods.add(new ModInfo(annotation.modid(), c.getName(), annotation.dependencies()));
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

		ModSorter modSorter = new ModSorter(modInfos);
		modInfos = modSorter.sortMods();
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

	private void fillCapabilities() throws Exception {
		ClassPath classesPath = ClassPath.from(ClassGenerator.class.getClassLoader());

		String sandbox = getPathSandbox().replace("/", ".");
		sandbox = sandbox.substring(0, sandbox.length() - 1);
		ImmutableSet<ClassInfo> classInfos = classesPath.getTopLevelClassesRecursive(sandbox);

		for (ClassInfo classInfo : classInfos) {
			Class<?> clazz = Class.forName(classInfo.getName(), false, CompatibilityMod.classLoader);

			for (Field field : clazz.getDeclaredFields()) {
				Compat_CapabilityInject annotation = field.getAnnotation(Compat_CapabilityInject.class);
				if (annotation != null) {
					String capabilityName = annotation.value().getName();
					Compat_Capability<?> capability = Compat_CapabilityManager.getCapability(capabilityName);
					if (capability != null) { // Some mods are broken
						field.set(null, capability);
					}
				}
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

		// Fill capabilities
		try {
			fillCapabilities();
		} catch (Exception e) {
			throw new RuntimeException(e);
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
			for (Object eventObj : modInfo.eventObjects) {
				MethodInfo<?> method = new MethodInfo<>(eventObj, Compat_SubscribeEvent.class, Compat_PlayerInteractEvent_RightClickBlock.class);
				method.tryInvoke(new Compat_PlayerInteractEvent_RightClickBlock(event));
			}
		}
	}

	@Override
	public void onModelBake(ModelBakeEvent event) {
		for (ModInfo modInfo : mods) {
			for (Object eventObj : modInfo.eventObjects) {
				MethodInfo<?> method = new MethodInfo<>(eventObj, Compat_SubscribeEvent.class, Compat_ModelBakeEvent.class);
				method.tryInvoke(new Compat_ModelBakeEvent(event));
			}
		}
	}

	@Override
	public void onDrawBlockHighlight(DrawBlockHighlightEvent event) {
		for (ModInfo modInfo : mods) {
			for (Object eventObj : modInfo.eventObjects) {
				MethodInfo<?> method = new MethodInfo<>(eventObj, Compat_SubscribeEvent.class, Compat_DrawBlockHighlightEvent.class);
				method.tryInvoke(new Compat_DrawBlockHighlightEvent(event));
			}
		}
	}

	@Override
	public void onAttachCapabilities(AttachCapabilitiesEvent<TileEntity> event) {
		for (ModInfo modInfo : mods) {
			for (Object eventObj : modInfo.eventObjects) {
				MethodInfo<?> method = new MethodInfo<>(eventObj, Compat_SubscribeEvent.class, Compat_AttachCapabilitiesEvent_TileEntity.class);
				method.tryInvoke(new Compat_AttachCapabilitiesEvent_TileEntity(event));
			}
		}
	}

	@Override
	public void onServerTick(ServerTickEvent event) {
		for (ModInfo modInfo : mods) {
			MethodInfo<?> method = new MethodInfo<>(modInfo.getProxy(), Compat_SubscribeEvent.class, Compat_TickEvent_ServerTickEvent.class);
			method.tryInvoke(new Compat_TickEvent_ServerTickEvent(event));
		}
	}

}
