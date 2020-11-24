package compat.sandbox.net.minecraft.block;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.block.Block;

public class Compat_BlockCompressed extends Compat_Block {
	private CompatI_Block wrapper;

	// When called from Mod
	public Compat_BlockCompressed() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Block.class, this));
	}

	// When called from child
	protected Compat_BlockCompressed(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockCompressed(Block original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_Block.class, original));
	}

	protected void initialize(CompatI_Block wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public Block getReal() {
		return wrapper.get();
	}
}
