package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util;

import net.minecraft.util.EnumParticleTypes;

public enum Compat_EnumParticleTypes {

	VALUE(EnumParticleTypes.EXPLOSION_NORMAL);

	private EnumParticleTypes original;

	private Compat_EnumParticleTypes(EnumParticleTypes original) {
		this.original = original;
	}

	public EnumParticleTypes getReal() {
		return original;
	}

	public static Compat_EnumParticleTypes Compat_get_VALUE() {
		return VALUE;
	}
}
