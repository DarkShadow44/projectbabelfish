package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block.material;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class CompatReal_Material extends Material implements CompatI_Material {
	@SuppressWarnings("unused")
	private Compat_Material thisFake;

	public CompatReal_Material(Compat_Material thisFake, MapColor color) {
		super(color);
		this.thisFake = thisFake;
	}

	@Override
	public Material get() {
		return this;
	}
}
