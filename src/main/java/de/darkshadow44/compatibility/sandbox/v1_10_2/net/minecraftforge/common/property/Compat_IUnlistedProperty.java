package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.common.property;

import net.minecraftforge.common.property.IUnlistedProperty;

public interface Compat_IUnlistedProperty<T> {
	public String Compat_getName();

	public boolean Compat_isValid(T value);

	public Class<T> Compat_getType();

	public String Compat_valueToString(T value);

	public static Compat_IUnlistedProperty<?> getFake(IUnlistedProperty<?> property) {
		if (property instanceof Wrapper_IUnlistedProperty) {
			return ((Wrapper_IUnlistedProperty<?>) property).getFake();
		}
		throw new RuntimeException();
	}

	public static IUnlistedProperty<?> getReal(Compat_IUnlistedProperty<?> property) {
		return new Wrapper_IUnlistedProperty<>(property);
	}
}
