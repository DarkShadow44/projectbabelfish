package compat.sandbox.net.minecraft.block;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.block.material.Compat_Material;
import net.minecraft.block.BlockRotatedPillar;

public class Compat_BlockRotatedPillar extends Compat_Block {
	private CompatI_BlockRotatedPillar wrapper;

	// When called from Mod
	public Compat_BlockRotatedPillar(Compat_Material material) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockRotatedPillar.class, this, material.getReal()));
	}

	// When called from child
	protected Compat_BlockRotatedPillar(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockRotatedPillar(BlockRotatedPillar original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockRotatedPillar.class, original));
	}

	protected void initialize(CompatI_BlockRotatedPillar wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public BlockRotatedPillar getReal() {
		return wrapper.get();
	}
}
