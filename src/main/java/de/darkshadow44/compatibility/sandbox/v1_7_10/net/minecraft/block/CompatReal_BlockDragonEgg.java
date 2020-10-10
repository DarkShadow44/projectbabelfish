package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import net.minecraft.block.BlockDragonEgg;

public class CompatReal_BlockDragonEgg extends BlockDragonEgg implements CompatI_BlockDragonEgg {
	@SuppressWarnings("unused")
	private Compat_BlockDragonEgg thisFake;

	public CompatReal_BlockDragonEgg(Compat_BlockDragonEgg thisFake) {
		super();
		this.thisFake = thisFake;
	}

	@Override
	public BlockDragonEgg get() {
		return this;
	}
}
