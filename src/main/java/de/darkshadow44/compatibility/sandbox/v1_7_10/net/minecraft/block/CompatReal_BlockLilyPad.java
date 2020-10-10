package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import net.minecraft.block.BlockLilyPad;

public class CompatReal_BlockLilyPad extends BlockLilyPad implements CompatI_BlockLilyPad {
	@SuppressWarnings("unused")
	private Compat_BlockLilyPad thisFake;

	public CompatReal_BlockLilyPad(Compat_BlockLilyPad thisFake) {
		super();
		this.thisFake = thisFake;
	}

	@Override
	public BlockLilyPad get() {
		return this;
	}
}
