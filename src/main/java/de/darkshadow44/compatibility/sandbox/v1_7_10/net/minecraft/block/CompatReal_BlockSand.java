package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import net.minecraft.block.BlockSand;

public class CompatReal_BlockSand extends BlockSand implements CompatI_BlockSand {
	@SuppressWarnings("unused")
	private Compat_BlockSand thisFake;

	public CompatReal_BlockSand(Compat_BlockSand thisFake) {
		super();
		this.thisFake = thisFake;
	}

	@Override
	public BlockSand get() {
		return this;
	}
}
