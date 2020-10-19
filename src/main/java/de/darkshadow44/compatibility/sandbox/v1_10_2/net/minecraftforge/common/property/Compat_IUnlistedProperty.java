package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.common.property;

public interface Compat_IUnlistedProperty<T> {
	public String Compat_getName();

	public boolean Compat_isValid(T value);

	public Class<T> Compat_getType();

	public String Compat_valueToString(T value);
}
