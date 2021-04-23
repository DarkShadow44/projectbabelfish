package compat.sandbox.net.minecraft.block;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.block.BlockPane;

public class Compat_BlockPane extends Compat_Block {
	private CompatI_BlockPane wrapper;

	// When called from Mod
	public Compat_BlockPane() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockPane.class, this));
	}

	// When called from child
	protected Compat_BlockPane(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockPane(BlockPane original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockPane.class, original));
	}

	protected void initialize(CompatI_BlockPane wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public BlockPane getReal() {
		return wrapper.get();
	}
}
