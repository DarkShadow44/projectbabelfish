package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.properties;

import net.minecraft.block.properties.IProperty;

public interface Compat_IProperty<T extends Comparable<T>> {
	public IProperty<T> getReal();
}
