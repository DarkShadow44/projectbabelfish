package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.BlockPistonBase;

public class Compat_BlockPistonBase extends Compat_BlockDirectional {
	private BlockPistonBase original;
	private CompatI_BlockPistonBase thisReal;

	// When called from Mod
	public Compat_BlockPistonBase() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockPistonBase.class, this), null);
	}

	// When called from child
	protected Compat_BlockPistonBase(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockPistonBase(BlockPistonBase original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_BlockPistonBase thisReal, BlockPistonBase original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public BlockPistonBase getReal() {
		return original == null ? thisReal.get() : original;
	}
}
