package compat.sandbox.net.minecraftforge.common.property;

import net.minecraftforge.common.property.IUnlistedProperty;

public class Wrapper_IUnlistedProperty<T> implements IUnlistedProperty<T> {

	private final Compat_IUnlistedProperty<T> fake;

	public Wrapper_IUnlistedProperty(Compat_IUnlistedProperty<T> fake) {
		this.fake = fake;
	}

	public Compat_IUnlistedProperty<T> getFake() {
		return fake;
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

	public static String getId(Object obj) {
		if (obj instanceof IUnlistedProperty)
			return ((IUnlistedProperty<?>) obj).getName();

		if (obj instanceof Compat_IUnlistedProperty)
			return ((Compat_IUnlistedProperty<?>) obj).Compat_getName();

		return null;
	}

	@Override
	public boolean equals(Object other) {
		return getId(this).equals(getId(other));
	}

	@Override
	public int hashCode() {
		return fake.hashCode();
	}
}
