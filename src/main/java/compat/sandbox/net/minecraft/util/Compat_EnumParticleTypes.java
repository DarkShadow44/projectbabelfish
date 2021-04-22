package compat.sandbox.net.minecraft.util;

public enum Compat_EnumParticleTypes {

	CLOUD(),
	REDSTONE(),
	SMOKE_NORMAL(),
	SNOW_SHOVEL();

	private Compat_EnumParticleTypes() {

	}


	/*public static Compat_EnumParticleTypes getFake(Particles) {
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
	}*/

	public static Compat_EnumParticleTypes Compat_get_CLOUD() {
		return CLOUD;
	}

	public static Compat_EnumParticleTypes Compat_get_REDSTONE() {
		return REDSTONE;
	}

	public static Compat_EnumParticleTypes Compat_get_SMOKE_NORMAL() {
		return SMOKE_NORMAL;
	}

	public static Compat_EnumParticleTypes Compat_get_SNOW_SHOVEL() {
		return SNOW_SHOVEL;
	}

	/*public static EnumParticleTypes getByName(String particleName) {
		switch (particleName) {
		default:
			throw new RuntimeException("Unknown particle: " + particleName);
		}
	}*/
}
