package compat.sandbox.net.minecraft.block;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.block.BlockOldLeaf;

public class Compat_BlockOldLeaf extends Compat_BlockLeaves {
	private CompatI_BlockOldLeaf wrapper;

	// When called from Mod
	public Compat_BlockOldLeaf() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockOldLeaf.class, this));
	}

	// When called from child
	protected Compat_BlockOldLeaf(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockOldLeaf(BlockOldLeaf original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockOldLeaf.class, original));
	}

	protected void initialize(CompatI_BlockOldLeaf wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public BlockOldLeaf getReal() {
		return wrapper.get();
	}
}
