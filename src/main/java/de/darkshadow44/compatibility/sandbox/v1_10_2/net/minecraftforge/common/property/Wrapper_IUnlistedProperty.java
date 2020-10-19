package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.common.property;

import net.minecraftforge.common.property.IUnlistedProperty;

public class Wrapper_IUnlistedProperty<T> implements IUnlistedProperty<T> {

	private final Compat_IUnlistedProperty<T> fake;

	public Wrapper_IUnlistedProperty(Compat_IUnlistedProperty<T> fake) {
		this.fake = fake;
	}

	@Override
	public String getName() {
		return fake.Compat_getName();
	}

	@Override
	public boolean isValid(T value) {
		return fake.Compat_isValid(value);
	}

	@Override
	public Class<T> getType() {
		return fake.Compat_getType();
	}

	@Override
	public String valueToString(T value) {
		return fake.Compat_valueToString(value);
	}
}
