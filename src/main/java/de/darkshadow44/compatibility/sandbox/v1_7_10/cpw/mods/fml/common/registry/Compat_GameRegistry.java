package de.darkshadow44.compatibility.sandbox.v1_7_10.cpw.mods.fml.common.registry;

import de.darkshadow44.compatibility.core.CompatibilityMod;
import de.darkshadow44.compatibility.core.RegistrationInfoBlock;
import de.darkshadow44.compatibility.sandbox.v1_7_10.cpw.mods.fml.common.Compat_IFuelHandler;
import de.darkshadow44.compatibility.sandbox.v1_7_10.cpw.mods.fml.common.Compat_IWorldGenerator;
import de.darkshadow44.compatibility.sandbox.v1_7_10.cpw.mods.fml.common.Wrapper_IWorldGenerator;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block.Compat_Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Compat_GameRegistry {
	public static void Compat_registerWorldGenerator(Compat_IWorldGenerator generator, int modGenerationWeight) {
		GameRegistry.registerWorldGenerator(new Wrapper_IWorldGenerator(generator), modGenerationWeight);
	}

	public static Compat_Block Compat_registerBlock(Compat_Block block, String name) {
		// TODO
		CompatibilityMod.blocksToRegister.add(new RegistrationInfoBlock(block.getReal(), name));
		return block;
	}
	
	public static Compat_Block Compat_registerBlock(Compat_Block block, Class<?> clazz, String name) {
		// TODO ItemBlock
		CompatibilityMod.blocksToRegister.add(new RegistrationInfoBlock(block.getReal(), name));
		return block;
	}

	public static void Compat_registerFuelHandler(Compat_IFuelHandler handler) {
		// TODO
	}
}
