package de.darkshadow44.compatibility.core.layer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import com.google.common.collect.Lists;

import de.darkshadow44.compatibility.core.CompatibilityMod;
import de.darkshadow44.compatibility.core.ConstructorInfo;
import de.darkshadow44.compatibility.core.FieldInfo;
import de.darkshadow44.compatibility.core.MethodInfo;
import de.darkshadow44.compatibility.core.ModInfo;
import de.darkshadow44.compatibility.core.RegistrationInfoBlock;
import de.darkshadow44.compatibility.core.RegistrationInfoItem;
import de.darkshadow44.compatibility.core.loader.CompatibilityModLoader;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.Compat_Mod;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.Compat_Mod_EventHandler;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.Compat_SidedProxy;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.event.Compat_FMLPreInitializationEvent;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.TextureStitchEvent.Pre;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

public class CompatibilityLayer_1_10_2 extends CompatibilityLayer {

	public List<RegistrationInfoBlock> blocksToRegister = new ArrayList<>();
	public List<RegistrationInfoItem> itemsToRegister = new ArrayList<>();

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

		// Construct mod objects
		for (ModInfo modInfo : modInfos) {
			ConstructorInfo ctor = new ConstructorInfo(modInfo.className);
			Object mod = ctor.tryConstruct();
			mods.put(modInfo.id, mod);
		}

		// Fill instances TODO
		/*for (Object mod : mods) {
			FieldInfo<?> instance = new FieldInfo<>(mod, Compat_Mod_Instance.class);
			instance.trySetValue(mod);
		}*/

		// Fill proxys
		for (Entry<String, Object> mod : mods.entrySet()) {
			FieldInfo<Compat_SidedProxy> instance = new FieldInfo<>(mod.getValue(), Compat_SidedProxy.class);
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
		for (String modId : mods.keySet()) {
			currentModId = modId;
			MethodInfo<?> methodPreInit = new MethodInfo<>(mods.get(modId), Compat_Mod_EventHandler.class, Compat_FMLPreInitializationEvent.class);
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

	private String makeItemModelJson(String pathTexture) {
		return "{\n" + "    \"parent\": \"item/generated\",\n" + "    \"textures\": {\n" + "        \"layer0\": \"" + pathTexture + "\"\n" + "    }\n" + "}";
	}

	@Override
	public void onItemsRegistration(Register<Item> itemRegisterEvent) {
		for (RegistrationInfoItem itemRegister : itemsToRegister) {
			Item item = itemRegister.getItem();
			if (itemRegister.getLocation() != null) {
				item.setRegistryName(itemRegister.getLocation());
			}
			itemRegisterEvent.getRegistry().register(item);

			ResourceLocation location = item.getRegistryName();

			String itemModelJson = makeItemModelJson(location.getResourceDomain() + ":items/" + location.getResourcePath());

			String path = location.getResourceDomain() + "/models/item/" + location.getResourcePath() + ".json";

			CompatibilityMod.classLoader.addResource(path, itemModelJson.getBytes());
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
			}
			CompatibilityMod.classLoader.addResource(name, data);
		}
	}

	@Override
	public void registerModels(ModelRegistryEvent evt) {

	}

	@Override
	public void registerTextures(Pre evt) {

	}

}
