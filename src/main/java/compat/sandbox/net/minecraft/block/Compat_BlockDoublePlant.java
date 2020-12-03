package compat.sandbox.net.minecraft.block;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.block.BlockDoublePlant;

public class Compat_BlockDoublePlant extends Compat_BlockBush {
	private CompatI_BlockDoublePlant wrapper;

	// When called from Mod
	public Compat_BlockDoublePlant() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockDoublePlant.class, this));
	}

	// When called from child
	protected Compat_BlockDoublePlant(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockDoublePlant(BlockDoublePlant original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockDoublePlant.class, original));
	}

	protected void initialize(CompatI_BlockDoublePlant wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public BlockDoublePlant getReal() {
		return wrapper.get();
	}

	public static Compat_BlockDoublePlant getFake(BlockDoublePlant block) {
		return getFakeInternal(block, () -> new Compat_BlockDoublePlant(block));
	}
}
