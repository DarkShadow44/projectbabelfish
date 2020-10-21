package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util;

import net.minecraft.util.EnumFacing;

public enum Compat_EnumFacing {

	EAST(EnumFacing.EAST);

	private EnumFacing original;

	private Compat_EnumFacing(EnumFacing original) {
		this.original = original;
	}

	public EnumFacing getReal() {
		return original;
	}

	public static Compat_EnumFacing Compat_get_EAST() {
		return EAST;
	}
}
