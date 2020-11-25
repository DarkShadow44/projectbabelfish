package compat.sandbox.cpw.mods.fml.common.registry;

import compat.sandbox.net.minecraft.block.Compat_Block;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class Compat_FMLControlledNamespacedRegistry<T extends IForgeRegistryEntry<T>> {

	private final IForgeRegistry<T> original;

	public Compat_FMLControlledNamespacedRegistry(IForgeRegistry<T> original) {
		this.original = original;
	}

	@SuppressWarnings("unchecked")
	public String Compat_func_148750_c(Object obj) {
		if (obj instanceof Compat_Block) {
			obj = ((Compat_Block) obj).getReal();
		}

		if (obj instanceof Block) {
			return ((Block) obj).getRegistryName().toString();
		}

		ResourceLocation loc = original.getKey((T) obj);
		if (loc.equals(original.getKey(null))) {
			throw new RuntimeException("Err");
		}
		return loc.toString();
	}
}
