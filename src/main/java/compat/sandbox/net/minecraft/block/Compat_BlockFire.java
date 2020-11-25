package compat.sandbox.net.minecraft.block;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.block.BlockFire;

public class Compat_BlockFire extends Compat_Block {
	private CompatI_BlockFire wrapper;

	// When called from Mod
	public Compat_BlockFire() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, Compat_BlockFire.class, this));
	}

	// When called from child
	protected Compat_BlockFire(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockFire(BlockFire original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockFire.class, original));
	}

	protected void initialize(CompatI_BlockFire wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public BlockFire getReal() {
		return wrapper.get();
	}

	public void Compat_setFireInfo(Compat_Block block, int encouragement, int flammability) {
		wrapper.setFireInfoSuper(block.getReal(), encouragement, flammability);
	}
}
