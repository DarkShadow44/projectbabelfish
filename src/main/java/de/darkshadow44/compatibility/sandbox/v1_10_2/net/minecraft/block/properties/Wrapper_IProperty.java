package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.properties;

import net.minecraft.block.properties.IProperty;

public class Wrapper_IProperty<T extends Comparable<T>> implements Compat_IProperty<T> {

	private final IProperty<T> original;

	public Wrapper_IProperty(IProperty<T> original) {
		this.original = original;
	}

	@Override
	public IProperty<T> getReal() {
		return original;
	}

	@Override
	public int hashCode() {
		return original.hashCode();
	};
}
