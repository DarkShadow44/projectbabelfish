package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util;

import net.minecraft.util.EnumBlockRenderType;

public enum Compat_EnumBlockRenderType {

	MODEL(EnumBlockRenderType.MODEL);

	private EnumBlockRenderType original;

	private Compat_EnumBlockRenderType(EnumBlockRenderType original) {
		this.original = original;
	}

	public EnumBlockRenderType getReal() {
		return original;
	}

	public static Compat_EnumBlockRenderType Compat_get_MODEL() {
		return MODEL;
	}

	public static Compat_EnumBlockRenderType get_fake(EnumBlockRenderType real) {
		switch (real) {
		case MODEL:
			return MODEL;
		default:
			throw new RuntimeException("Unmapped " + real.toString());
		}
	}
}
