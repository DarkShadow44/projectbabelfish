package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util;

import net.minecraft.util.EnumHand;

public enum Compat_EnumHand {

	MAIN_HAND(EnumHand.MAIN_HAND),
	OFF_HAND(EnumHand.OFF_HAND);

	private EnumHand original;

	private Compat_EnumHand(EnumHand original) {
		this.original = original;
	}

	public EnumHand getReal() {
		return original;
	}

	public static Compat_EnumHand map_real_to_fake(EnumHand real) {
		switch (real) {
		case MAIN_HAND:
			return MAIN_HAND;
		case OFF_HAND:
			return OFF_HAND;
		}
		return null;
	}

	public static Compat_EnumHand Compat_get_OFF_HAND() {
		return OFF_HAND;
	}

	public static Compat_EnumHand Compat_get_MAIN_HAND() {
		return MAIN_HAND;
	}
}
