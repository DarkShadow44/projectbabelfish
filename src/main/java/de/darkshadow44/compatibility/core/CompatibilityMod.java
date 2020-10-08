package de.darkshadow44.compatibility.core;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

import de.darkshadow44.compatibility.core.loader.CompatibilityModLoader;
import de.darkshadow44.compatibility.core.loader.MemoryClassLoader;
import de.darkshadow44.compatibility.sandbox.v1_7_10.cpw.mods.fml.common.Compat_Mod_EventHandler;
import de.darkshadow44.compatibility.sandbox.v1_7_10.cpw.mods.fml.common.Compat_Mod_Instance;
import de.darkshadow44.compatibility.sandbox.v1_7_10.cpw.mods.fml.common.event.Compat_FMLPreInitializationEvent;
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

	private List<Object> mods = new ArrayList<Object>();

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		File directoryMods = new File(event.getModConfigurationDirectory().getParentFile(), "mods");
		loadMods(new File(directoryMods, "1.7.10"));

		// Execute preInit
		for (Object mod : mods) {
			Method methodPreInit = findAnnotateMethod(mod, Compat_Mod_EventHandler.class, Compat_FMLPreInitializationEvent.class);
			if (methodPreInit != null) {
				Compat_FMLPreInitializationEvent ev = new Compat_FMLPreInitializationEvent(event);
				try {
					methodPreInit.invoke(mod, ev);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
	}

	static <T extends Annotation> Field findAnnotatedField(Object obj, Class<T> annotation) {
		for (Field field : obj.getClass().getFields()) {
			if (field.getAnnotation(annotation) != null)
				return field;
		}
		return null;
	}

	static <T extends Annotation> Method findAnnotateMethod(Object obj, Class<T> annotation, Class<?> event) {
		for (Method method : obj.getClass().getMethods()) {
			if (method.getAnnotation(annotation) != null) {
				Parameter[] params = method.getParameters();
				if (params.length == 1 && params[0].getParameterizedType().getTypeName().equals(event.getTypeName())) {
					return method;
				}
			}
		}
		return null;
	}

	void loadMods(File dir) {
		dir.mkdirs();
		CompatibilityModLoader loader = new CompatibilityModLoader();
		Class<?>[] modClasses = loader.loadAllMods(dir);
		for (Class<?> mod : modClasses) {
			Constructor<?> ctor;
			try {
				ctor = mod.getConstructor();
				Object object = ctor.newInstance();
				mods.add(object);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

		// Fill instances
		for (Object mod : mods) {
			Field instance = findAnnotatedField(mod, Compat_Mod_Instance.class);
			if (instance != null) {
				try {
					instance.set(mod, mod);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
}
