package compat.sandbox.net.minecraft.block;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockStairs;

public class Compat_BlockStairs extends Compat_Block {
	private CompatI_BlockStairs wrapper;

	// When called from Mod
	public Compat_BlockStairs(Compat_Block block, int p1) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockStairs.class, this, new BlockPlanks().getDefaultState())); // TODO
	}

	// When called from child
	protected Compat_BlockStairs(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockStairs(BlockStairs original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockStairs.class, original));
	}

	protected void initialize(CompatI_BlockStairs wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public BlockStairs getReal() {
		return wrapper.get();
	}
}
