package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.BlockFlower;

public class Compat_BlockFlower extends Compat_Block {
	private CompatI_BlockFlower wrapper;

	// When called from Mod
	public Compat_BlockFlower() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockFlower.class, this));
	}

	// When called from child
	protected Compat_BlockFlower(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockFlower(BlockFlower original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockFlower.class, original));
	}

	protected void initialize(CompatI_BlockFlower wrapper) {
		this.wrapper = wrapper;
	}

	public BlockFlower getReal() {
		return wrapper.get();
	}
}
