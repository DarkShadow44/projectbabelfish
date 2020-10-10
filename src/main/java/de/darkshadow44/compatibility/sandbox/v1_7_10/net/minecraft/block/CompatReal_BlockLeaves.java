package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import net.minecraft.block.BlockLeaves;

public abstract class CompatReal_BlockLeaves extends BlockLeaves implements CompatI_BlockLeaves {
	@SuppressWarnings("unused")
	private Compat_BlockLeaves thisFake;

	public CompatReal_BlockLeaves(Compat_BlockLeaves thisFake) {
		super();
		this.thisFake = thisFake;
	}

	@Override
	public BlockLeaves get() {
		return this;
	}
}
