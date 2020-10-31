package de.darkshadow44.compatibility.core.layer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import de.darkshadow44.compatibility.autogen.ClassGenerator;
import de.darkshadow44.compatibility.core.ModInfo;
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
import net.minecraftforge.fml.relauncher.Side;

public abstract class CompatibilityLayer {

	static final String prefixFake = "Compat_";
	static final String prefixInterface = "CompatI_";
	static final String prefixReal = "CompatReal_";
	static final String prefixGet = "Compat_get_";
	static final String prefixSet = "Compat_set_";

	private final String pathSandbox;
	protected final String version;

	protected final List<ModInfo> mods = new ArrayList<>();

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
}
