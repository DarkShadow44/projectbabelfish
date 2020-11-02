package compat.sandbox.net.minecraft.block;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.block.BlockSlab;

public class Compat_BlockSlab extends Compat_Block {
	private CompatI_BlockSlab wrapper;

	// When called from Mod
	public Compat_BlockSlab() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockSlab.class, this));
	}

	// When called from child
	protected Compat_BlockSlab(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockSlab(BlockSlab original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockSlab.class, original));
	}

	protected void initialize(CompatI_BlockSlab wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public BlockSlab getReal() {
		return wrapper.get();
	}
}
