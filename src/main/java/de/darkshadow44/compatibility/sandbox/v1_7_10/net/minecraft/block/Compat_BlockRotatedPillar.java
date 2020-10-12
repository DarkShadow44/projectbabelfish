package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block.material.Compat_Material;
import net.minecraft.block.BlockRotatedPillar;

public class Compat_BlockRotatedPillar extends Compat_Block {
	private BlockRotatedPillar original;
	private CompatI_BlockRotatedPillar thisReal;

	// When called from Mod
	public Compat_BlockRotatedPillar(Compat_Material material) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, this, material.getReal()), null);
	}

	// When called from child
	protected Compat_BlockRotatedPillar(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockRotatedPillar(BlockRotatedPillar original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_BlockRotatedPillar thisReal, BlockRotatedPillar original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public BlockRotatedPillar getReal() {
		return original == null ? thisReal.get() : original;
	}
}
