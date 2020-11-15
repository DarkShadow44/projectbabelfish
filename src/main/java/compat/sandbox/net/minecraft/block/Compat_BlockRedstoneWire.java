package compat.sandbox.net.minecraft.block;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.block.BlockRedstoneWire;

public class Compat_BlockRedstoneWire extends Compat_Block {
	private CompatI_BlockRedstoneWire wrapper;

	// When called from Mod
	public Compat_BlockRedstoneWire() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockRedstoneWire.class, this));
	}

	// When called from child
	protected Compat_BlockRedstoneWire(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockRedstoneWire(BlockRedstoneWire original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockRedstoneWire.class, original));
	}

	protected void initialize(CompatI_BlockRedstoneWire wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public BlockRedstoneWire getReal() {
		return wrapper.get();
	}
}
