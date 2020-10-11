package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.BlockIce;

public class Compat_BlockIce extends Compat_Block {
	private BlockIce original;
	private CompatI_BlockIce thisReal;

	// When called from Mod
	public Compat_BlockIce() {
		super(ParentSelector.NULL);
		this.initialize(new CompatReal_BlockIce(this), null);
	}

	// When called from child
	protected Compat_BlockIce(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockIce(BlockIce original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_BlockIce thisReal, BlockIce original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public BlockIce getReal() {
		return original == null ? thisReal.get() : original;
	}
}
