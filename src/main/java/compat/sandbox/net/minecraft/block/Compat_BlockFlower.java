package compat.sandbox.net.minecraft.block;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.block.BlockFlower;

public class Compat_BlockFlower extends Compat_Block {
	private CompatI_BlockFlower wrapper;

	// When called from Mod
	public Compat_BlockFlower() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockFlower.class, this));
	}

	// When called from child
	protected Compat_BlockFlower(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockFlower(BlockFlower original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockFlower.class, original));
	}

	protected void initialize(CompatI_BlockFlower wrapper) {
		this.wrapper = wrapper;
	}

	public BlockFlower getReal() {
		return wrapper.get();
	}
}
