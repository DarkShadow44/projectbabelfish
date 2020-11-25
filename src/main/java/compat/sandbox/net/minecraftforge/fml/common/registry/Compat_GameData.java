package compat.sandbox.net.minecraftforge.fml.common.registry;

import compat.sandbox.cpw.mods.fml.common.registry.Compat_FMLControlledNamespacedRegistry;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public class Compat_GameData {

	public static Compat_FMLControlledNamespacedRegistry<Block> Compat_getBlockRegistry() {
		IForgeRegistry<Block> registry = GameRegistry.findRegistry(Block.class);
		if (registry == null)
			throw new RuntimeException("Error");
		return new Compat_FMLControlledNamespacedRegistry<Block>(registry);
	}
}
