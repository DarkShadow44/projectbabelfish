package compat.sandbox.net.minecraftforge.fml.common.registry;

import compat.sandbox.cpw.mods.fml.common.registry.Compat_FMLControlledNamespacedRegistry;
import compat.sandbox.cpw.mods.fml.common.registry.Compat_FMLControlledNamespacedRegistry.Type;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

public class Compat_GameData {

	public static Compat_FMLControlledNamespacedRegistry<Block> Compat_getBlockRegistry() {
		IForgeRegistry<Block> registry = GameRegistry.findRegistry(Block.class);
		if (registry == null)
			throw new RuntimeException("Error");
		return new Compat_FMLControlledNamespacedRegistry<Block>(registry, Type.BLOCKS);
	}

	public static Compat_FMLControlledNamespacedRegistry<Item> Compat_getItemRegistry() {
		return new Compat_FMLControlledNamespacedRegistry<Item>(ForgeRegistries.ITEMS, Type.ITEMS);
	}

	public static Compat_FMLControlledNamespacedRegistry<Block> Compat_get_blockRegistry() {
		return new Compat_FMLControlledNamespacedRegistry<Block>(ForgeRegistries.BLOCKS, Type.BLOCKS);
	}
}
