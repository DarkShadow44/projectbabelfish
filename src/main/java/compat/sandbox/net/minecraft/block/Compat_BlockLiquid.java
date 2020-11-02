package compat.sandbox.net.minecraft.block;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.block.BlockLiquid;

public class Compat_BlockLiquid extends Compat_Block {
	private CompatI_BlockLiquid wrapper;

	// When called from Mod
	public Compat_BlockLiquid() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockLiquid.class, this));
	}

	// When called from child
	protected Compat_BlockLiquid(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockLiquid(BlockLiquid original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockLiquid.class, original));
	}

	protected void initialize(CompatI_BlockLiquid wrapper) {
		this.wrapper = wrapper;
	}

	public BlockLiquid getReal() {
		return wrapper.get();
	}
}
