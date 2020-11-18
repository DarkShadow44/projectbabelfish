package compat.sandbox.net.minecraft.util;

import net.minecraft.util.EnumParticleTypes;

public enum Compat_EnumParticleTypes {

	CLOUD(EnumParticleTypes.CLOUD),
	REDSTONE(EnumParticleTypes.REDSTONE),
	SMOKE_NORMAL(EnumParticleTypes.SMOKE_NORMAL),
	SNOW_SHOVEL(EnumParticleTypes.SNOW_SHOVEL);

	private EnumParticleTypes original;

	private Compat_EnumParticleTypes(EnumParticleTypes original) {
		this.original = original;
	}

	public EnumParticleTypes getReal() {
		return original;
	}

	public static Compat_EnumParticleTypes getFake(EnumParticleTypes real) {
		switch (real) {
		case CLOUD:
			return CLOUD;
		case REDSTONE:
			return REDSTONE;
		case SMOKE_NORMAL:
			return SMOKE_NORMAL;
		case SNOW_SHOVEL:
			return SNOW_SHOVEL;
		default:
			throw new RuntimeException("Unhandled " + real.name());
		}
	}

	public Compat_EnumParticleTypes Compat_get_CLOUD() {
		return CLOUD;
	}

	public Compat_EnumParticleTypes Compat_get_REDSTONE() {
		return REDSTONE;
	}

	public Compat_EnumParticleTypes Compat_get_SMOKE_NORMAL() {
		return SMOKE_NORMAL;
	}

	public Compat_EnumParticleTypes Compat_get_SNOW_SHOVEL() {
		return SNOW_SHOVEL;
	}
}
