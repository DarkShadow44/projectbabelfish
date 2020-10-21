package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.item;

import net.minecraft.item.EnumDyeColor;

public enum Compat_EnumDyeColor {

	VALUE(EnumDyeColor.WHITE);

	private EnumDyeColor original;

	private Compat_EnumDyeColor(EnumDyeColor original) {
		this.original = original;
	}

	public EnumDyeColor getReal() {
		return original;
	}

	public static Compat_EnumDyeColor Compat_get_VALUE() {
		return VALUE;
	}
}
