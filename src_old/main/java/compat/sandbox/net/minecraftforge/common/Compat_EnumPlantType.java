package compat.sandbox.net.minecraftforge.common;

import net.minecraftforge.common.EnumPlantType;

public enum Compat_EnumPlantType {

	VALUE(EnumPlantType.Plains);

	private EnumPlantType original;

	private Compat_EnumPlantType(EnumPlantType original) {
		this.original = original;
	}

	public EnumPlantType getReal() {
		return original;
	}

	public static Compat_EnumPlantType getFake(EnumPlantType real) {
		switch (real) {
		default:
			throw new RuntimeException("Unhandled " + real.name());
		}
	}

	public static Compat_EnumPlantType Compat_get_VALUE() {
		return VALUE;
	}
}
