package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import net.minecraft.block.BlockDaylightDetector;

public class CompatReal_BlockDaylightDetector extends BlockDaylightDetector implements CompatI_BlockDaylightDetector {
	@SuppressWarnings("unused")
	private Compat_BlockDaylightDetector thisFake;

	public CompatReal_BlockDaylightDetector(Compat_BlockDaylightDetector thisFake, boolean p1) {
		super(p1);
		this.thisFake = thisFake;
	}

	@Override
	public BlockDaylightDetector get() {
		return this;
	}
}
