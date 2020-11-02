package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.material;

import net.minecraft.block.material.MapColor;

public class Compat_MapColor {

	private static final Compat_MapColor DIRT = new Compat_MapColor(MapColor.DIRT);
	private static final Compat_MapColor GRASS = new Compat_MapColor(MapColor.GRASS);
	private static final Compat_MapColor AIR = new Compat_MapColor(MapColor.AIR);

	private final MapColor original;

	public Compat_MapColor(MapColor original) {
		this.original = original;
	}

	public MapColor getReal() {
		return original;
	}

	public static Compat_MapColor Compat_get_field_151664_l() {
		return DIRT;
	}

	public static Compat_MapColor Compat_get_field_151661_c() {
		return GRASS;
	}

	public static Compat_MapColor Compat_get_field_151660_b() {
		return AIR;
	}
}
