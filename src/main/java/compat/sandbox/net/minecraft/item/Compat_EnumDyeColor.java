package compat.sandbox.net.minecraft.item;

import net.minecraft.item.EnumDyeColor;

public enum Compat_EnumDyeColor {

	BLUE(EnumDyeColor.BLUE),
	RED(EnumDyeColor.RED);

	private EnumDyeColor original;

	private Compat_EnumDyeColor(EnumDyeColor original) {
		this.original = original;
	}

	public EnumDyeColor getReal() {
		return original;
	}

	public static Compat_EnumDyeColor Compat_get_BLUE() {
		return BLUE;
	}

	public static Compat_EnumDyeColor Compat_get_RED() {
		return RED;
	}

	public int Compat_func_176767_b() {
		return original.getDyeDamage();
	}
}
