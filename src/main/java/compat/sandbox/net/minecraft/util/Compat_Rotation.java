package compat.sandbox.net.minecraft.util;

import net.minecraft.util.Rotation;

public enum Compat_Rotation {

	NONE(Rotation.NONE),
	CLOCKWISE_90(Rotation.CLOCKWISE_90),
	CLOCKWISE_180(Rotation.CLOCKWISE_180),
	COUNTERCLOCKWISE_90(Rotation.COUNTERCLOCKWISE_90);

	private Rotation original;

	private Compat_Rotation(Rotation original) {
		this.original = original;
	}

	public Rotation getReal() {
		return original;
	}

	public Compat_Rotation getFake(Rotation real) {
		switch (real) {
		case NONE:
			return NONE;
		case CLOCKWISE_90:
			return CLOCKWISE_90;
		case CLOCKWISE_180:
			return CLOCKWISE_180;
		case COUNTERCLOCKWISE_90:
			return COUNTERCLOCKWISE_90;
		default:
			throw new RuntimeException();
		}
	}

	public static Compat_Rotation Compat_get_NONE() {
		return NONE;
	}
}
