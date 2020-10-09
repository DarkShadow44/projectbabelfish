package de.darkshadow44.compatibility.core;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

import de.darkshadow44.compatibility.core.loader.CompatibilityClassTransformer;
import de.darkshadow44.compatibility.core.loader.CompatibilityModLoader;
import de.darkshadow44.compatibility.core.loader.MemoryClassLoader;
import de.darkshadow44.compatibility.sandbox.v1_7_10.cpw.mods.fml.common.Compat_Mod_EventHandler;
import de.darkshadow44.compatibility.sandbox.v1_7_10.cpw.mods.fml.common.Compat_Mod_Instance;
import de.darkshadow44.compatibility.sandbox.v1_7_10.cpw.mods.fml.common.Compat_SidedProxy;
import de.darkshadow44.compatibility.sandbox.v1_7_10.cpw.mods.fml.common.event.Compat_FMLPreInitializationEvent;
import net.minecraft.launchwrapper.Launch;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = CompatibilityMod.MODID, name = CompatibilityMod.NAME, version = CompatibilityMod.VERSION)
public class CompatibilityMod {
	public static final String MODID = "examplemod";
	public static final String NAME = "Example Mod";
	public static final String VERSION = "1.0";

	public static MemoryClassLoader classLoader = new MemoryClassLoader(Launch.classLoader);

	private List<Object> mods = new ArrayList<Object>();

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		File directoryMods = new File(event.getModConfigurationDirectory().getParentFile(), "mods");
		loadMods(new File(directoryMods, "1.7.10"), event.getSide());

		// Execute preInit
		for (Object mod : mods) {
			MethodInfo<?> methodPreInit = new MethodInfo<>(mod, Compat_Mod_EventHandler.class, Compat_FMLPreInitializationEvent.class);
			methodPreInit.tryInvoke(new Compat_FMLPreInitializationEvent(event));
		}
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
	}

	void loadMods(File dir, Side side) {
		dir.mkdirs();
		CompatibilityModLoader loader = new CompatibilityModLoader();
		String[] modClassNames = loader.loadAllMods(dir);

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
				className = CompatibilityClassTransformer.getPrefixedClassname(className);
				className = className.replace("/", ".");
				ConstructorInfo ctor = new ConstructorInfo(className);
				Object proxy = ctor.tryConstruct();
				instance.trySetValue(proxy);
			}
		}
	}
}
