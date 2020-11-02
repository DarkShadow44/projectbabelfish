package compat.sandbox.net.minecraft.block;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.block.BlockDragonEgg;

public class Compat_BlockDragonEgg extends Compat_Block {
	private CompatI_BlockDragonEgg wrapper;

	// When called from Mod
	public Compat_BlockDragonEgg() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockDragonEgg.class, this));
	}

	// When called from child
	protected Compat_BlockDragonEgg(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockDragonEgg(BlockDragonEgg original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockDragonEgg.class, original));
	}

	protected void initialize(CompatI_BlockDragonEgg wrapper) {
		this.wrapper = wrapper;
	}

	public BlockDragonEgg getReal() {
		return wrapper.get();
	}
}
