package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraftforge.fluids;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraftforge.fluids.FluidStack;

public class Compat_FluidStack {
	private CompatI_FluidStack wrapper;

	// When called from Mod
	public Compat_FluidStack(Compat_Fluid fluid, int amount) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_FluidStack.class, this, fluid.getReal(), amount));
	}

	// When called from child
	protected Compat_FluidStack(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_FluidStack(FluidStack original) {
		this.initialize(Factory.createWrapper(CompatI_FluidStack.class, original));
	}

	protected void initialize(CompatI_FluidStack wrapper) {
		this.wrapper = wrapper;
	}

	public FluidStack getReal() {
		return wrapper.get();
	}
}
