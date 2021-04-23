package compat.sandbox.net.minecraft.block.properties;

import net.minecraft.block.properties.PropertyHelper;

public interface CompatI_PropertyHelper<T extends Comparable<T>> {
	public PropertyHelper<T> get();
}
