package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.BlockDirectional;

public class Compat_BlockDirectional extends Compat_Block {
	private BlockDirectional original;
	private CompatI_BlockDirectional thisReal;

	// When called from Mod
	public Compat_BlockDirectional() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockDirectional.class, this), null);
	}

	// When called from child
	protected Compat_BlockDirectional(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockDirectional(BlockDirectional original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_BlockDirectional thisReal, BlockDirectional original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public BlockDirectional getReal() {
		return original == null ? thisReal.get() : original;
	}
}
