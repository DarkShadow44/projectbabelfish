package compat.sandbox.net.minecraft.block;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockChest.Type;

public class Compat_BlockChest extends Compat_Block {
	private CompatI_BlockChest wrapper;

	// When called from Mod
	public Compat_BlockChest(int p1) { // TODO
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockChest.class, this, Type.BASIC));
	}

	// When called from child
	protected Compat_BlockChest(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockChest(BlockChest original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockChest.class, original));
	}

	protected void initialize(CompatI_BlockChest wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public BlockChest getReal() {
		return wrapper.get();
	}
}
