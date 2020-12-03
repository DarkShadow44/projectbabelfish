package compat.sandbox.net.minecraft.block;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.block.BlockGrass;

public class Compat_BlockGrass extends Compat_Block {
	private CompatI_BlockGrass wrapper;

	// When called from Mod
	public Compat_BlockGrass() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockGrass.class, this));
	}

	// When called from child
	protected Compat_BlockGrass(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockGrass(BlockGrass original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockGrass.class, original));
	}

	protected void initialize(CompatI_BlockGrass wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public BlockGrass getReal() {
		return wrapper.get();
	}

	public static Compat_BlockGrass getFake(BlockGrass block) {
		return getFakeInternal(block, () -> new Compat_BlockGrass(block));
	}
}
