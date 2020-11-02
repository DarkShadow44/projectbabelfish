package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.BlockLiquid;

public class Compat_BlockLiquid extends Compat_Block {
	private CompatI_BlockLiquid wrapper;

	// When called from Mod
	public Compat_BlockLiquid() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockLiquid.class, this));
	}

	// When called from child
	protected Compat_BlockLiquid(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockLiquid(BlockLiquid original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockLiquid.class, original));
	}

	protected void initialize(CompatI_BlockLiquid wrapper) {
		this.wrapper = wrapper;
	}

	public BlockLiquid getReal() {
		return wrapper.get();
	}
}
