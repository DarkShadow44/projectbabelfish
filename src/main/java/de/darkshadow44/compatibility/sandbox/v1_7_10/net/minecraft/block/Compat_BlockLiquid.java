package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.BlockLiquid;

public class Compat_BlockLiquid extends Compat_Block {
	private BlockLiquid original;
	private CompatI_BlockLiquid thisReal;

	// When called from Mod
	public Compat_BlockLiquid() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockLiquid.class, this), null);
	}

	// When called from child
	protected Compat_BlockLiquid(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockLiquid(BlockLiquid original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_BlockLiquid thisReal, BlockLiquid original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public BlockLiquid getReal() {
		return original == null ? thisReal.get() : original;
	}
}
