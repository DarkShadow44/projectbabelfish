package compat.sandbox.net.minecraft.block;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.block.BlockStainedGlassPane;

public class Compat_BlockStainedGlassPane extends Compat_BlockPane {
	private CompatI_BlockStainedGlassPane wrapper;

	// When called from Mod
	public Compat_BlockStainedGlassPane() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockStainedGlassPane.class, this));
	}

	// When called from child
	protected Compat_BlockStainedGlassPane(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockStainedGlassPane(BlockStainedGlassPane original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockStainedGlassPane.class, original));
	}

	protected void initialize(CompatI_BlockStainedGlassPane wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public BlockStainedGlassPane getReal() {
		return wrapper.get();
	}
}
