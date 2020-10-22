package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.BlockSlab;

public class Compat_BlockSlab extends Compat_Block {
	private BlockSlab original;
	private CompatI_BlockSlab thisReal;

	// When called from Mod
	public Compat_BlockSlab() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockSlab.class, this), null);
	}

	// When called from child
	protected Compat_BlockSlab(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockSlab(BlockSlab original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_BlockSlab thisReal, BlockSlab original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public BlockSlab getReal() {
		return original == null ? thisReal.get() : original;
	}
}
