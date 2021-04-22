package compat.sandbox.net.minecraft.util.registry;

import compat.sandbox.net.minecraft.block.Compat_Block;
import compat.sandbox.net.minecraft.util.Compat_ResourceLocation;
import net.minecraft.block.Block;
import net.minecraft.util.registry.RegistryNamespacedDefaultedByKey;

public class Compat_RegistryNamespacedDefaultedByKey_Block extends Compat_RegistryNamespacedDefaultedByKey {

	private final RegistryNamespacedDefaultedByKey<Block> original;

	public Compat_RegistryNamespacedDefaultedByKey_Block(RegistryNamespacedDefaultedByKey<Block> original) {
		this.original = original;
	}

	public RegistryNamespacedDefaultedByKey<Block> getReal() {
		return original;
	}

	@Override
	public Object Compat_func_177774_c(Object obj) {
		Compat_Block block = (Compat_Block) obj;
		return new Compat_ResourceLocation(original.getKey(block.getReal()));
	}
}
