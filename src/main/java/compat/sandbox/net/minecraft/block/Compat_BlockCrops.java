package compat.sandbox.net.minecraft.block;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.block.BlockCrops;

public class Compat_BlockCrops extends Compat_BlockBush {
	private CompatI_BlockCrops wrapper;

	// When called from Mod
	public Compat_BlockCrops() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockCrops.class, this));
	}

	// When called from child
	protected Compat_BlockCrops(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockCrops(BlockCrops original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockCrops.class, original));
	}

	protected void initialize(CompatI_BlockCrops wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public BlockCrops getReal() {
		return wrapper.get();
	}
}
