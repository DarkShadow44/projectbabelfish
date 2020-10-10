package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import net.minecraft.block.BlockStainedGlass;
import net.minecraft.block.material.Material;

public class CompatReal_BlockStainedGlass extends BlockStainedGlass implements CompatI_BlockStainedGlass {
	@SuppressWarnings("unused")
	private Compat_BlockStainedGlass thisFake;

	public CompatReal_BlockStainedGlass(Compat_BlockStainedGlass thisFake, Material material) {
		super(material);
		this.thisFake = thisFake;
	}

	@Override
	public BlockStainedGlass get() {
		return this;
	}
}
