package compat.sandbox.net.minecraft.block;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.block.BlockVine;

public class Compat_BlockVine extends Compat_Block {
	private CompatI_BlockVine wrapper;

	// When called from Mod
	public Compat_BlockVine() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockVine.class, this));
	}

	// When called from child
	protected Compat_BlockVine(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockVine(BlockVine original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockVine.class, original));
	}

	protected void initialize(CompatI_BlockVine wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public BlockVine getReal() {
		return wrapper.get();
	}
}
