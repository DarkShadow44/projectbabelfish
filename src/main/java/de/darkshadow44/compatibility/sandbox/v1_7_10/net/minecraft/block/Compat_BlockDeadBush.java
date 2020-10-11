package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.BlockDeadBush;

public class Compat_BlockDeadBush extends Compat_Block {
	private BlockDeadBush original;
	private CompatI_BlockDeadBush thisReal;

	// When called from Mod
	public Compat_BlockDeadBush() {
		super(ParentSelector.NULL);
		this.initialize(new CompatReal_BlockDeadBush(this), null);
	}

	// When called from child
	protected Compat_BlockDeadBush(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockDeadBush(BlockDeadBush original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_BlockDeadBush thisReal, BlockDeadBush original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public BlockDeadBush getReal() {
		return original == null ? thisReal.get() : original;
	}
}
