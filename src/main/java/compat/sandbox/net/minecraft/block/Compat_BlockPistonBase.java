package compat.sandbox.net.minecraft.block;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.block.BlockPistonBase;

public class Compat_BlockPistonBase extends Compat_BlockDirectional {
	private CompatI_BlockPistonBase wrapper;

	// When called from Mod
	public Compat_BlockPistonBase() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockPistonBase.class, this));
	}

	// When called from child
	protected Compat_BlockPistonBase(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockPistonBase(BlockPistonBase original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockPistonBase.class, original));
	}

	protected void initialize(CompatI_BlockPistonBase wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public BlockPistonBase getReal() {
		return wrapper.get();
	}
}
