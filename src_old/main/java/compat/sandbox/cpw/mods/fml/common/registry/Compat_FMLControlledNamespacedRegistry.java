package compat.sandbox.cpw.mods.fml.common.registry;

import compat.core.CompatibilityMod;
import compat.core.RegistrationInfoBlock;
import compat.sandbox.net.minecraft.block.Compat_Block;
import compat.sandbox.net.minecraft.item.Compat_Item;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class Compat_FMLControlledNamespacedRegistry<T extends IForgeRegistryEntry<T>> {

	public enum Type {
		UNKNOWN,
		BLOCKS,
		ITEMS;
	}

	private final IForgeRegistry<T> original;
	private final Type type;

	public Compat_FMLControlledNamespacedRegistry(IForgeRegistry<T> original, Type type) {
		this.original = original;
		this.type = type;
	}

	private Object getRealObj(Object obj) {
		if (obj instanceof Compat_Block) {
			return ((Compat_Block) obj).getReal();
		}

		if (obj instanceof Compat_Item) {
			return ((Compat_Item) obj).getReal();
		}

		throw new RuntimeException("Unexpected");
	}

	@SuppressWarnings("unchecked")
	public String Compat_func_148750_c(Object obj) {
		obj = getRealObj(obj);

		if (CompatibilityMod.CURRENT_LAYER != null)
		{
			if (obj instanceof Block) {
				for (RegistrationInfoBlock info : CompatibilityMod.CURRENT_LAYER.blocksToRegister) {
					if (info.getBlock() == obj) {
						return info.getLocation().toString();
					}
				}
				return ((Block) obj).getRegistryName().toString();
			}
		}

		ResourceLocation loc = original.getKey((T) obj);
		if (obj != Blocks.AIR && loc.equals(original.getKey(null))) {
			throw new RuntimeException("Err");
		}
		return loc.toString();
	}

	public Object Compat_func_148754_a(int id) {
		return Compat_get(id);
	}

	public Object Compat_func_82594_a(String name) {
		Object result = original.getValue(new ResourceLocation(name));
		if (result == null) {
			throw new RuntimeException("Is Null");
		}
		return result;
	}

	public Object Compat_get(int id) {
		switch (type) {
		case BLOCKS:
			return Compat_Block.getFake(Block.getBlockById(id));
		case ITEMS:
			return Compat_Item.getFake(Item.getItemById(id));
		case UNKNOWN:
		default:
			throw new RuntimeException("Unexpected");
		}
	}

	public int Compat_getId(Object obj) {
		obj = getRealObj(obj);
		switch (type) {
		case BLOCKS:
			return Block.getIdFromBlock((Block) obj);
		case ITEMS:
			return Item.getIdFromItem((Item) obj);
		case UNKNOWN:
		default:
			throw new RuntimeException("Unexpected");
		}
	}
}
