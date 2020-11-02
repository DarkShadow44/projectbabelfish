package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.BlockLeaves;

public class Compat_BlockLeaves extends Compat_Block {
	private CompatI_BlockLeaves wrapper;

	// When called from Mod
	public Compat_BlockLeaves() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockLeaves.class, this));
	}

	// When called from child
	protected Compat_BlockLeaves(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockLeaves(BlockLeaves original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockLeaves.class, original));
	}

	protected void initialize(CompatI_BlockLeaves wrapper) {
		this.wrapper = wrapper;
	}

	public BlockLeaves getReal() {
		return wrapper.get();
	}
}
