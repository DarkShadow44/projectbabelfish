package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraftforge.fluids;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

public class CompatReal_FluidStack extends FluidStack implements CompatI_FluidStack {
	@SuppressWarnings("unused")
	private Compat_FluidStack thisFake;

	public CompatReal_FluidStack(Compat_FluidStack thisFake, Fluid fluid, int amount) {
		super(fluid, amount);
		this.thisFake = thisFake;
	}

	@Override
	public FluidStack get() {
		return this;
	}
}
