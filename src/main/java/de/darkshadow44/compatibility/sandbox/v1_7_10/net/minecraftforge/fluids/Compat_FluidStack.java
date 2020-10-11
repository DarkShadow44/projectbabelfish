package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraftforge.fluids;

import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraftforge.fluids.FluidStack;

public class Compat_FluidStack {
	private FluidStack original;
	private CompatI_FluidStack thisReal;

	// When called from Mod
	public Compat_FluidStack(Compat_Fluid fluid, int amount) {
		initialize(new CompatReal_FluidStack(this, fluid.getReal(), amount), null);
	}

	// When called from child
	protected Compat_FluidStack(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_FluidStack(FluidStack original) {
		initialize(null, original);
	}

	protected void initialize(CompatI_FluidStack thisReal, FluidStack original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public FluidStack getReal() {
		return original == null ? thisReal.get() : original;
	}
}
