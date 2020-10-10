package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import net.minecraft.block.BlockIce;

public class CompatReal_BlockIce extends BlockIce implements CompatI_BlockIce {
	@SuppressWarnings("unused")
	private Compat_BlockIce thisFake;

	public CompatReal_BlockIce(Compat_BlockIce thisFake) {
		super();
		this.thisFake = thisFake;
	}

	@Override
	public BlockIce get() {
		return this;
	}
}
