package compat.sandbox.net.minecraft.block;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.block.BlockLeaves;

public class Compat_BlockLeaves extends Compat_Block {
	private CompatI_BlockLeaves wrapper;

	// When called from Mod
	public Compat_BlockLeaves() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockLeaves.class, this));
	}

	// When called from child
	protected Compat_BlockLeaves(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockLeaves(BlockLeaves original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockLeaves.class, original));
	}

	protected void initialize(CompatI_BlockLeaves wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public BlockLeaves getReal() {
		return wrapper.get();
	}
}
