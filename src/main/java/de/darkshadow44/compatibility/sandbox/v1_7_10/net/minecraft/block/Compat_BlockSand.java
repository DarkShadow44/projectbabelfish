package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.BlockSand;

public class Compat_BlockSand extends Compat_Block {
	private BlockSand original;
	private CompatI_BlockSand thisReal;

	// When called from Mod
	public Compat_BlockSand() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockSand.class, this), null);
	}

	// When called from child
	protected Compat_BlockSand(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockSand(BlockSand original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_BlockSand thisReal, BlockSand original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public BlockSand getReal() {
		return original == null ? thisReal.get() : original;
	}
}
