package de.darkshadow44.compatibility.sandbox.v1_7_10.cpw.mods.fml.common.registry;

import de.darkshadow44.compatibility.sandbox.v1_7_10.cpw.mods.fml.common.Compat_IWorldGenerator;
import de.darkshadow44.compatibility.sandbox.v1_7_10.cpw.mods.fml.common.Wrapper_IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Compat_GameRegistry {
	public static void Compat_registerWorldGenerator(Compat_IWorldGenerator generator, int modGenerationWeight) {
		GameRegistry.registerWorldGenerator(new Wrapper_IWorldGenerator(generator), modGenerationWeight);
	}
}
