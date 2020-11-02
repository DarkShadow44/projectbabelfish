package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.material.Compat_Material;
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
		this.wrapper = wrapper;
	}

	public BlockRotatedPillar getReal() {
		return wrapper.get();
	}
}
