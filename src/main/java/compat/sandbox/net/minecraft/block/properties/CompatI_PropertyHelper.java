package compat.sandbox.net.minecraft.block.properties;

import net.minecraft.state.AbstractProperty;

public interface CompatI_PropertyHelper<T extends Comparable<T>> {
	public AbstractProperty<T> get();
}
