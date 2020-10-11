package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.BlockLilyPad;

public class Compat_BlockLilyPad extends Compat_Block {
	private BlockLilyPad original;
	private CompatI_BlockLilyPad thisReal;

	// When called from Mod
	public Compat_BlockLilyPad() {
		super(ParentSelector.NULL);
		this.initialize(new CompatReal_BlockLilyPad(this), null);
	}

	// When called from child
	protected Compat_BlockLilyPad(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockLilyPad(BlockLilyPad original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_BlockLilyPad thisReal, BlockLilyPad original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public BlockLilyPad getReal() {
		return original == null ? thisReal.get() : original;
	}
}
