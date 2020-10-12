package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraftforge.fluids;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block.Compat_Block;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block.material.Compat_Material;
import net.minecraftforge.fluids.BlockFluidBase;

public class Compat_BlockFluidBase extends Compat_Block {
	private BlockFluidBase original;
	private CompatI_BlockFluidBase thisReal;

	// When called from Mod
	public Compat_BlockFluidBase(Compat_Fluid fluid, Compat_Material material) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, this, fluid.getReal(), material.getReal()), null);
	}

	// When called from child
	protected Compat_BlockFluidBase(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockFluidBase(BlockFluidBase original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_BlockFluidBase thisReal, BlockFluidBase original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public BlockFluidBase getReal() {
		return original == null ? thisReal.get() : original;
	}

	public void Compat_set_quantaPerBlock(int value) {
		if (original == null)
			this.thisReal.setQuantaPerBlockSuper(value);
		else
			this.original.setQuantaPerBlock(value);
	}
}
