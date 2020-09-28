package de.darkshadow44.compatibility.core;

import java.io.File;

import de.darkshadow44.compatibility.core.loader.CompatibilityModLoader;
import de.darkshadow44.compatibility.core.loader.MemoryClassLoader;
import net.minecraft.launchwrapper.Launch;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = CompatibilityMod.MODID, name = CompatibilityMod.NAME, version = CompatibilityMod.VERSION)
public class CompatibilityMod {
	public static final String MODID = "examplemod";
	public static final String NAME = "Example Mod";
	public static final String VERSION = "1.0";

	public static MemoryClassLoader classLoader = new MemoryClassLoader(Launch.classLoader);

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		File directoryMods = new File(event.getModConfigurationDirectory().getParentFile(), "mods");
		loadMods(new File(directoryMods, "1.7.10"));
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
	}

	void loadMods(File dir) {
		dir.mkdirs();
		CompatibilityModLoader loader = new CompatibilityModLoader();
		loader.loadAllMods(dir);
	}
}
