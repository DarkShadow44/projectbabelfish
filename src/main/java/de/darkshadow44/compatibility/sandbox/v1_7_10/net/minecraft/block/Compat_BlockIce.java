package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.BlockIce;

public class Compat_BlockIce extends Compat_Block {
	private CompatI_BlockIce wrapper;

	// When called from Mod
	public Compat_BlockIce() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockIce.class, this));
	}

	// When called from child
	protected Compat_BlockIce(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockIce(BlockIce original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockIce.class, original));
	}

	protected void initialize(CompatI_BlockIce wrapper) {
		this.wrapper = wrapper;
	}

	public BlockIce getReal() {
		return wrapper.get();
	}
}
