package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.BlockDragonEgg;

public class Compat_BlockDragonEgg extends Compat_Block {
	private BlockDragonEgg original;
	private CompatI_BlockDragonEgg thisReal;

	// When called from Mod
	public Compat_BlockDragonEgg() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockDragonEgg.class, this), null);
	}

	// When called from child
	protected Compat_BlockDragonEgg(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockDragonEgg(BlockDragonEgg original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_BlockDragonEgg thisReal, BlockDragonEgg original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public BlockDragonEgg getReal() {
		return original == null ? thisReal.get() : original;
	}
}
