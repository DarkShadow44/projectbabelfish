package compat.sandbox.net.minecraft.block;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.block.BlockMycelium;

public class Compat_BlockMycelium extends Compat_Block {
	private CompatI_BlockMycelium wrapper;

	// When called from Mod
	public Compat_BlockMycelium() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockMycelium.class, this));
	}

	// When called from child
	protected Compat_BlockMycelium(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockMycelium(BlockMycelium original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockMycelium.class, original));
	}

	protected void initialize(CompatI_BlockMycelium wrapper) {
		this.wrapper = wrapper;
	}

	public BlockMycelium getReal() {
		return wrapper.get();
	}
}
