package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.BlockContainer;

public class Compat_BlockContainer extends Compat_Block {
	private BlockContainer original;
	private CompatI_BlockContainer thisReal;

	// When called from child
	protected Compat_BlockContainer(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockContainer(BlockContainer original) {
		super(ParentSelector.NULL);
		super.initialize(null, original);
	}

	protected void initialize(CompatI_BlockContainer thisReal, BlockContainer original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public BlockContainer getReal() {
		return original == null ? thisReal.get() : original;
	}
}
