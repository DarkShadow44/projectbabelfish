package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.BlockBreakable;

public class Compat_BlockBreakable extends Compat_Block {
	private CompatI_BlockBreakable wrapper;

	// When called from Mod
	public Compat_BlockBreakable() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockBreakable.class, this));
	}

	// When called from child
	protected Compat_BlockBreakable(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockBreakable(BlockBreakable original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockBreakable.class, original));
	}

	protected void initialize(CompatI_BlockBreakable wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public BlockBreakable getReal() {
		return wrapper.get();
	}
}
