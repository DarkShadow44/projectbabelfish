package compat.sandbox.net.minecraft.block;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.block.BlockSand;

public class Compat_BlockSand extends Compat_Block {
	private CompatI_BlockSand wrapper;

	// When called from Mod
	public Compat_BlockSand() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockSand.class, this));
	}

	// When called from child
	protected Compat_BlockSand(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockSand(BlockSand original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockSand.class, original));
	}

	protected void initialize(CompatI_BlockSand wrapper) {
		this.wrapper = wrapper;
	}

	public BlockSand getReal() {
		return wrapper.get();
	}
}
