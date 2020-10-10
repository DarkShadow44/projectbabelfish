package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.BlockDaylightDetector;

public class Compat_BlockDaylightDetector extends Compat_Block {
	private BlockDaylightDetector original;
	private CompatI_BlockDaylightDetector thisReal;

	// When called from Mod
	public Compat_BlockDaylightDetector(boolean p1) {
		super(ParentSelector.NULL);
		super.initialize(new CompatReal_BlockDaylightDetector(this, p1), null);
	}

	// When called from child
	protected Compat_BlockDaylightDetector(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockDaylightDetector(BlockDaylightDetector original) {
		super(ParentSelector.NULL);
		super.initialize(null, original);
	}

	protected void initialize(CompatI_BlockDaylightDetector thisReal, BlockDaylightDetector original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public BlockDaylightDetector getReal() {
		return original == null ? thisReal.get() : original;
	}
}
