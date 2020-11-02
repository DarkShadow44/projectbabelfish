package compat.sandbox.net.minecraft.block;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.block.material.Compat_Material;
import net.minecraft.block.BlockPressurePlate;

public class Compat_BlockPressurePlate extends Compat_Block {
	private CompatI_BlockPressurePlate wrapper;

	// When called from Mod
	public Compat_BlockPressurePlate(String p1, Compat_Material material, Compat_BlockPressurePlate_Sensitivity sensitivity) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockPressurePlate.class, this, material.getReal(), sensitivity.getReal())); // TODO
	}

	// When called from child
	protected Compat_BlockPressurePlate(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockPressurePlate(BlockPressurePlate original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockPressurePlate.class, original));
	}

	protected void initialize(CompatI_BlockPressurePlate wrapper) {
		this.wrapper = wrapper;
	}

	public BlockPressurePlate getReal() {
		return wrapper.get();
	}
}
