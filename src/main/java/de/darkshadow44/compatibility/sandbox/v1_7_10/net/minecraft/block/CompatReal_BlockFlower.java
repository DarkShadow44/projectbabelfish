package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import net.minecraft.block.BlockFlower;

public abstract class CompatReal_BlockFlower extends BlockFlower implements CompatI_BlockFlower {
	@SuppressWarnings("unused")
	private Compat_BlockFlower thisFake;

	public CompatReal_BlockFlower(Compat_BlockFlower thisFake) {
		super();
		this.thisFake = thisFake;
	}

	@Override
	public BlockFlower get() {
		return this;
	}
}
