package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class CompatReal_BlockLeavesBase extends Block implements CompatI_BlockLeavesBase {
	@SuppressWarnings("unused")
	private Compat_BlockLeavesBase thisFake;

	public CompatReal_BlockLeavesBase(Compat_BlockLeavesBase thisFake, Material material) {
		super(material);
		this.thisFake = thisFake;
	}

	@Override
	public Block get() {
		return this;
	}
}
