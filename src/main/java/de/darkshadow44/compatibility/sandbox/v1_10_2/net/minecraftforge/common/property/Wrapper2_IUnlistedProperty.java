package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.common.property;

import net.minecraftforge.common.property.IUnlistedProperty;

public class Wrapper2_IUnlistedProperty<T> implements Compat_IUnlistedProperty<T> {

	private final IUnlistedProperty<T> real;

	public Wrapper2_IUnlistedProperty(IUnlistedProperty<T> real) {
		this.real = real;
	}

	@Override
	public String Compat_getName() {
		return real.getName();
	}

	@Override
	public boolean Compat_isValid(T value) {
		return real.isValid(value);
	}

	@Override
	public Class<T> Compat_getType() {
		return real.getType();
	}

	@Override
	public String Compat_valueToString(T value) {
		return real.valueToString(value);
	}
}
