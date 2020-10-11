package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.BlockStairs;

public class Compat_BlockStairs extends Compat_Block {
	private BlockStairs original;
	private CompatI_BlockStairs thisReal;

	// When called from Mod
	public Compat_BlockStairs() {
		super(ParentSelector.NULL);
		this.initialize(new CompatReal_BlockStairs(this, null), null); // TODO
	}

	// When called from child
	protected Compat_BlockStairs(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockStairs(BlockStairs original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_BlockStairs thisReal, BlockStairs original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public BlockStairs getReal() {
		return original == null ? thisReal.get() : original;
	}
}
