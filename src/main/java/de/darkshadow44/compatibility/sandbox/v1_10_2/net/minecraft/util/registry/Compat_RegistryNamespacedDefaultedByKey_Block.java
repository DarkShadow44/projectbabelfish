package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.registry;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.Compat_Block;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.Compat_ResourceLocation;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.RegistryNamespacedDefaultedByKey;

public class Compat_RegistryNamespacedDefaultedByKey_Block extends Compat_RegistryNamespacedDefaultedByKey {

	private final RegistryNamespacedDefaultedByKey<ResourceLocation, Block> original;

	public Compat_RegistryNamespacedDefaultedByKey_Block(RegistryNamespacedDefaultedByKey<ResourceLocation, Block> original) {
		this.original = original;
	}

	public RegistryNamespacedDefaultedByKey<ResourceLocation, Block> getReal() {
		return original;
	}

	@Override
	public Object Compat_func_177774_c(Object obj) {
		Compat_Block block = (Compat_Block) obj;
		return new Compat_ResourceLocation(original.getNameForObject(block.getReal()));
	}
}
