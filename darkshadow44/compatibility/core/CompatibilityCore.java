package darkshadow44.compatibility.core;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.LoaderState.ModState;
import cpw.mods.fml.common.discovery.ASMDataTable;
import cpw.mods.fml.common.discovery.ASMDataTable.ASMData;
import cpw.mods.fml.common.event.FMLConstructionEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.event.FMLServerStoppingEvent;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import darkshadow44.testmod.TestMod;
import scala.Console;

@IFMLLoadingPlugin.MCVersion
@Mod(modid = "compatibilitycore", name = "Dark's Compatibility Mod", version = "0.0.1", acceptableRemoteVersions = "*")
public class CompatibilityCore implements IFMLLoadingPlugin {

	@Mod.Instance
	public static CompatibilityCore instance;

	TestMod test = new TestMod();

	@Override
	public String[] getASMTransformerClass() {
		return null;
	}

	@Override
	public String getModContainerClass() {
		return null;
	}

	@Override
	public String getSetupClass() {
		return null;
	}

	@Override
	public void injectData(Map<String, Object> data) {

	}

	@Override
	public String getAccessTransformerClass() {
		return null;
	}

	void loadMods(FMLConstructionEvent event) {
	}

	@Mod.EventHandler
	public void load(FMLConstructionEvent event) {
		loadMods(event);
	}

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		test.preInit(event);
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		File pathMods = new File(net.minecraft.client.Minecraft.getMinecraft().mcDataDir, "compatibility/1.2.5/mods");
		pathMods.mkdirs();

		ArchiveHandler archiveHandler = new ArchiveHandler();
		archiveHandler.LoadAllMods(pathMods.getPath());
		Console.out().println("Loaded successfully.");
	}

	@Mod.EventHandler
	public void onServerStarting(FMLServerStartingEvent event) {
	}

	@Mod.EventHandler
	public void onServerStopping(FMLServerStoppingEvent event) {
	}

}
