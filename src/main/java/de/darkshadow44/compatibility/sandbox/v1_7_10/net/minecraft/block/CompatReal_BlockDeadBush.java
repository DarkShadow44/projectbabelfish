package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import net.minecraft.block.BlockDeadBush;

public class CompatReal_BlockDeadBush extends BlockDeadBush implements CompatI_BlockDeadBush {
	@SuppressWarnings("unused")
	private Compat_BlockDeadBush thisFake;

	public CompatReal_BlockDeadBush(Compat_BlockDeadBush thisFake) {
		super();
		this.thisFake = thisFake;
	}

	@Override
	public BlockDeadBush get() {
		return this;
	}
}
