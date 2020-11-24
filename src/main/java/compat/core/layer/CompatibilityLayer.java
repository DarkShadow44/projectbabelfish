package compat.core.layer;

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

import compat.core.ModInfo;
import compat.core.RegistrationInfoBlock;
import compat.core.RegistrationInfoIcon;
import compat.core.RegistrationInfoItem;
import compat.core.Version;
import compat.core.loader.CompatibilityClassTransformer;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.TextureStitchEvent.Pre;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ServerTickEvent;
import net.minecraftforge.fml.relauncher.Side;

public abstract class CompatibilityLayer {

	public List<RegistrationInfoBlock> blocksToRegister = new ArrayList<>();
	public List<RegistrationInfoItem> itemsToRegister = new ArrayList<>();
	public List<RegistrationInfoIcon> iconsToRegister = new ArrayList<>();
	public List<ModelLocationInfo> modelLocationInfo = new ArrayList<>();

	static final String prefixFake = "Compat_";
	static final String prefixInterface = "CompatI_";
	static final String prefixReal = "CompatReal_";
	static final String prefixGet = "Compat_get_";
	static final String prefixSet = "Compat_set_";

	public static final String pathSandbox = "compat/sandbox/";
	protected final Version version;

	protected final List<ModInfo> mods = new ArrayList<>();
	private Map<String, String> classRedirects = new HashMap<>();

	public CompatibilityLayer(Version version) {
		this.version = version;
		readRedirects();
	}

	private void readRedirects() {

		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("classRedirects.txt");
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
			classRedirects.put(split[0], split[1]);
		}
	}

	public Version getVersion() {
		return version;
	}

	public String getPathSandbox() {
		return pathSandbox;
	}

	public String getRedirected(String name) {
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

	public String getPrefixedClassname(String name) {
		String[] names = name.split("\\/");
		if (CompatibilityClassTransformer.isMcClass(name)) {
			names[names.length - 1] = prefixFake + names[names.length - 1];
		}
		String prefixedPath = pathSandbox + String.join("/", names);
		return getRedirected(prefixedPath);
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

	public abstract void preInit(FMLPreInitializationEvent event);

	public abstract void init(FMLInitializationEvent event);

	public abstract void postInit(FMLPostInitializationEvent event);

	public abstract void onBlocksRegistration(Register<Block> blockRegisterEvent);

	public abstract void onItemsRegistration(Register<Item> itemRegisterEvent);

	public abstract void registerModels(ModelRegistryEvent evt);

	public abstract void registerTextures(Pre evt);

	public abstract void handleResource(String nameLower, byte[] data);

	public abstract void loadMods(File directoryMods, Side side);

	public abstract void onClientTick(ClientTickEvent event);

	public abstract void onRightclickBlock(RightClickBlock event);

	public abstract void onModelBake(ModelBakeEvent event);

	public abstract void onDrawBlockHighlight(DrawBlockHighlightEvent event);

	public abstract void onAttachCapabilities(AttachCapabilitiesEvent<TileEntity> event);

	public abstract void onServerTick(ServerTickEvent event);

	public abstract String getCurrentModId();
}
