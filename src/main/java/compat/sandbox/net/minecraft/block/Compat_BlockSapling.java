package compat.sandbox.net.minecraft.block;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.block.BlockSapling;

public class Compat_BlockSapling extends Compat_BlockBush {
	private CompatI_BlockSapling wrapper;

	// When called from Mod
	public Compat_BlockSapling() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockSapling.class, this));
	}

	// When called from child
	protected Compat_BlockSapling(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockSapling(BlockSapling original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockSapling.class, original));
	}

	protected void initialize(CompatI_BlockSapling wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public BlockSapling getReal() {
		return wrapper.get();
	}
}
