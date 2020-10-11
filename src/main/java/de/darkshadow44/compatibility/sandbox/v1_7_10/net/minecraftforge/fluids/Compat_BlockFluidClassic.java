package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraftforge.fluids;

import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block.material.Compat_Material;
import net.minecraftforge.fluids.BlockFluidClassic;

public class Compat_BlockFluidClassic extends Compat_BlockFluidBase {
	private BlockFluidClassic original;
	private CompatI_BlockFluidClassic thisReal;

	// When called from Mod
	public Compat_BlockFluidClassic(Compat_Fluid fluid, Compat_Material material) {
		super(ParentSelector.NULL);
		this.initialize(new CompatReal_BlockFluidClassic(this, fluid.getReal(), material.getReal()), null);
	}

	// When called from child
	protected Compat_BlockFluidClassic(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockFluidClassic(BlockFluidClassic original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_BlockFluidClassic thisReal, BlockFluidClassic original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public BlockFluidClassic getReal() {
		return original == null ? thisReal.get() : original;
	}
}
