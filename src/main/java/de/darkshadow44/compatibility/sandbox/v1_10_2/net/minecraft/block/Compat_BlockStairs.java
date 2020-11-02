package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
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
		this.wrapper = wrapper;
	}

	public BlockStairs getReal() {
		return wrapper.get();
	}
}
