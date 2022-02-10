package net.projectbabelfish.core;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import net.minecraftforge.fml.LogicalSide;
import net.projectbabelfish.ProjectBabelfish;
import net.projectbabelfish.compat.sandbox.net.minecraftforge.fml.common.Compat_SidedProxy;
import net.projectbabelfish.core.loader.CompatibilityClassTransformer;
import net.projectbabelfish.core.loader.CompatibilityModLoader;
import net.projectbabelfish.sandbox.net.minecraftforge.fml.common.Compat_Mod;

public class CompatibilityLayer {

	//public List<RegistrationInfoBlock> blocksToRegister = new ArrayList<>();
	//public List<RegistrationInfoItem> itemsToRegister = new ArrayList<>();
	//public List<RegistrationInfoIcon> iconsToRegister = new ArrayList<>();
	//public List<ModelLocationInfo> modelLocationInfo = new ArrayList<>();

	static final String prefixFake = "Compat_";
	static final String prefixInterface = "CompatI_";
	static final String prefixReal = "CompatReal_";
	static final String prefixGet = "Compat_get_";
	static final String prefixSet = "Compat_set_";

	public static final String pathSandbox = "net/projectbabelfish/sandbox/";
	protected final Version version;

	public final List<ModInfo> mods = new ArrayList<>();
	private Map<String, String> classRedirects = new HashMap<>();
	private Map<String, String> methodRedirects = new HashMap<>();

	public CompatibilityLayer(Version version) {
		this.version = version;
		//readClassRedirects(classRedirects, "classRedirects.txt");
		//readClassRedirects(methodRedirects, "methodRedirects.txt");
	}

	private void readClassRedirects(Map<String, String> target, String name) {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(name);
		List<String> lines;
		try {
			lines = IOUtils.readLines(inputStream, StandardCharsets.UTF_8);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		for (String line : lines) {
			line = line.trim().replace(' ', '\t').replace('.', '/');
			String[] split = StringUtils.split(line);
			if (split.length == 0)
				continue;
			if (split.length != 2) {
				throw new RuntimeException("Invalid line: " + line);
			}
			target.put(split[0], split[1]);
		}
	}

	public Version getVersion() {
		return version;
	}

	public String getPathSandbox() {
		return pathSandbox;
	}

	public String getRedirectedClass(String name) {
		name = name.replace('$', '_');
		String key = name;
		if (key.startsWith(pathSandbox)) {
			key = key.substring(pathSandbox.length());
		}
		if (classRedirects.containsKey(key)) {
			name = pathSandbox + classRedirects.get(key);
		}
		return name;
	}

	public String getRedirectedMethod(String name, String desc) {
		if (methodRedirects.containsKey(name + desc)) {
			name = methodRedirects.get(name + desc);
		}
		return name;
	}

	public String getPrefixedClassname(String name) {
		String[] names = name.split("\\/");
		if (CompatibilityClassTransformer.isMcClass(name)) {
			names[names.length - 1] = prefixFake + names[names.length - 1];
		}
		String prefixedPath = pathSandbox + String.join("/", names);
		return getRedirectedClass(prefixedPath);
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

	public ModInfo getModById(String id) {
		for (ModInfo mod : mods) {
			if (mod.id.equals(id)) {
				return mod;
			}
		}
		return null;
	}

	//public abstract void preInit(FMLPreInitializationEvent event);

	//public abstract void init(FMLInitializationEvent event);

	//public abstract void postInit(FMLPostInitializationEvent event);

	/*public abstract void onBlocksRegistration(Register<Block> blockRegisterEvent);

	public abstract void onItemsRegistration(Register<Item> itemRegisterEvent);

	public abstract void registerModels(ModelRegistryEvent evt);

	public abstract void registerTextures(Pre evt);*/

	private String fixBlockstate(String text) {
		text = text.replace("\"inventory\": { }", "\"inventory\": [{ }]");
		return text;
	}

	private void registerTranslation(String name, String text) {
		ProjectBabelfish.classLoader.addResource(name, text.getBytes());
	}
	
	public void handleResource(String name, byte[] data) {
		name = name.substring("assets/".length());
		if (name.endsWith(".png") || name.endsWith(".json")) {
			String[] split = name.split("\\/");

			if (split.length >= 2 && split[1].equals("blockstates")) {
				String text = new String(data);
				text = fixBlockstate(text);
				data = text.getBytes();

				split[1] = "models/item";
				ProjectBabelfish.classLoader.addResource(String.join("/", split), data);
			}
			ProjectBabelfish.classLoader.addResource(name, data);
		}

		if (name.endsWith(".lang")) {
			registerTranslation(name, new String(data));
		}
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
	
	public void loadMods(File modsDirectory, LogicalSide side) {
		File dir = new File(modsDirectory, version.getString());
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
				if (side == LogicalSide.CLIENT) {
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

	/*public abstract void onClientTick(ClientTickEvent event);

	public abstract void onRightclickBlock(RightClickBlock event);

	public abstract void onModelBake(ModelBakeEvent event);

	//public abstract void onDrawBlockHighlight(DrawBlockHighlightEvent event);

	public abstract void onAttachCapabilities(AttachCapabilitiesEvent<BlockEntity> event);

	public abstract void onServerTick(ServerTickEvent event);

	public abstract String getCurrentModId();*/
}

