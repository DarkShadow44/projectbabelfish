package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block.material;

import net.minecraft.block.material.MapColor;

public class Compat_MapColor {
	private MapColor original;

	public Compat_MapColor(MapColor original) {
		this.original = original;
	}

	public MapColor getReal() {
		return original;
	}
}
