package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.BlockLeaves;

public class Compat_BlockLeaves extends Compat_Block {
	private BlockLeaves original;
	private CompatI_BlockLeaves thisReal;

	// When called from child
	protected Compat_BlockLeaves(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockLeaves(BlockLeaves original) {
		super(ParentSelector.NULL);
		super.initialize(null, original);
	}

	protected void initialize(CompatI_BlockLeaves thisReal, BlockLeaves original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public BlockLeaves getReal() {
		return original == null ? thisReal.get() : original;
	}
}
