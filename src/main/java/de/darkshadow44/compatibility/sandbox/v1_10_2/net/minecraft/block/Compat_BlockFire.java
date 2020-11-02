package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
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
		this.wrapper = wrapper;
	}

	public BlockFire getReal() {
		return wrapper.get();
	}

	public void Compat_setFireInfo(Compat_Block block, int encouragement, int flammability) {
		wrapper.setFireInfoSuper(block.getReal(), encouragement, flammability);
	}
}
