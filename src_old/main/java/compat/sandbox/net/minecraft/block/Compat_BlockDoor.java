package compat.sandbox.net.minecraft.block;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.block.material.Compat_Material;
import net.minecraft.block.BlockDoor;

public class Compat_BlockDoor extends Compat_Block {
	private CompatI_BlockDoor wrapper;

	// When called from Mod
	public Compat_BlockDoor(Compat_Material material) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockDoor.class, this, material.getReal()));
	}

	// When called from child
	protected Compat_BlockDoor(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockDoor(BlockDoor original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockDoor.class, original));
	}

	protected void initialize(CompatI_BlockDoor wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public BlockDoor getReal() {
		return wrapper.get();
	}
}
