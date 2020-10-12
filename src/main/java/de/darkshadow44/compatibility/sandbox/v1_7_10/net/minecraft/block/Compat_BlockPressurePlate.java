package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block.material.Compat_Material;
import net.minecraft.block.BlockPressurePlate;

public class Compat_BlockPressurePlate extends Compat_Block {
	private BlockPressurePlate original;
	private CompatI_BlockPressurePlate thisReal;

	// When called from Mod
	public Compat_BlockPressurePlate(String p1, Compat_Material material, Compat_BlockPressurePlate_Sensitivity sensitivity) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, this, material.getReal(), sensitivity.getReal()), null); // TODO
	}

	// When called from child
	protected Compat_BlockPressurePlate(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockPressurePlate(BlockPressurePlate original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_BlockPressurePlate thisReal, BlockPressurePlate original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public BlockPressurePlate getReal() {
		return original == null ? thisReal.get() : original;
	}
}
