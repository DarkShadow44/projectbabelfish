package compat.sandbox.net.minecraft.block;

import compat.autogen.Callback;
import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockFlower.EnumFlowerColor;

public class Compat_BlockFlower extends Compat_Block {
	private CompatI_BlockFlower wrapper;

	// When called from Mod
	public Compat_BlockFlower(int type) { // TODO
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockFlower.class, this));
	}

	// When called from child
	protected Compat_BlockFlower(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockFlower(BlockFlower original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockFlower.class, original));
	}

	protected void initialize(CompatI_BlockFlower wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public BlockFlower getReal() {
		return wrapper.get();
	}

	@Callback
	public EnumFlowerColor getBlockType() {
		return EnumFlowerColor.RED; // TODO ?
	}

	public static Compat_BlockFlower getFake(BlockFlower block) {
		return getFakeInternal(block, () -> new Compat_BlockFlower(block));
	}

}
