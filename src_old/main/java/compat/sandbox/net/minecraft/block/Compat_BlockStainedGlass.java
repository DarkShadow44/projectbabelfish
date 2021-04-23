package compat.sandbox.net.minecraft.block;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.block.BlockStainedGlass;

public class Compat_BlockStainedGlass extends Compat_BlockBreakable {
	private CompatI_BlockStainedGlass wrapper;

	// When called from Mod
	public Compat_BlockStainedGlass() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockStainedGlass.class, this));
	}

	// When called from child
	protected Compat_BlockStainedGlass(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockStainedGlass(BlockStainedGlass original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockStainedGlass.class, original));
	}

	protected void initialize(CompatI_BlockStainedGlass wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public BlockStainedGlass getReal() {
		return wrapper.get();
	}

	public static Compat_BlockStainedGlass getFake(BlockStainedGlass block) {
		return getFakeInternal(block, () -> new Compat_BlockStainedGlass(block));
	}
}
