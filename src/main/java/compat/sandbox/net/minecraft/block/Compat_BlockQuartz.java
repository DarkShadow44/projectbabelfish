package compat.sandbox.net.minecraft.block;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.block.BlockQuartz;

public class Compat_BlockQuartz extends Compat_Block {
	private CompatI_BlockQuartz wrapper;

	// When called from Mod
	public Compat_BlockQuartz() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockQuartz.class, this));
	}

	// When called from child
	protected Compat_BlockQuartz(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockQuartz(BlockQuartz original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockQuartz.class, original));
	}

	protected void initialize(CompatI_BlockQuartz wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public BlockQuartz getReal() {
		return wrapper.get();
	}
}
