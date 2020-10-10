package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;

public class CompatReal_BlockBreakable extends BlockBreakable implements CompatI_BlockBreakable {
	@SuppressWarnings("unused")
	private Compat_BlockBreakable thisFake;

	public CompatReal_BlockBreakable(Compat_BlockBreakable thisFake, Material material, boolean p1) {
		super(material, p1);
		this.thisFake = thisFake;
	}

	@Override
	public BlockBreakable get() {
		return this;
	}
}
