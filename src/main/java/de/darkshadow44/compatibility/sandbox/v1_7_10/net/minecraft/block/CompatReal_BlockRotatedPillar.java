package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;

public class CompatReal_BlockRotatedPillar extends BlockRotatedPillar implements CompatI_BlockRotatedPillar {
	@SuppressWarnings("unused")
	private Compat_BlockRotatedPillar thisFake;

	public CompatReal_BlockRotatedPillar(Compat_BlockRotatedPillar thisFake, Material material) {
		super(material);
		this.thisFake = thisFake;
	}

	@Override
	public BlockRotatedPillar get() {
		return this;
	}
}
