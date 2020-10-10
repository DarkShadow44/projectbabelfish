package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import net.minecraft.block.BlockVine;

public class CompatReal_BlockVine extends BlockVine implements CompatI_BlockVine {
	@SuppressWarnings("unused")
	private Compat_BlockVine thisFake;

	public CompatReal_BlockVine(Compat_BlockVine thisFake) {
		super();
		this.thisFake = thisFake;
	}

	@Override
	public BlockVine get() {
		return this;
	}
}
