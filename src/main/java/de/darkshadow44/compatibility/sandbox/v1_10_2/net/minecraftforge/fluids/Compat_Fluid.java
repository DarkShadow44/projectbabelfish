package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fluids;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.Compat_Block;
import net.minecraftforge.fluids.Fluid;

public class Compat_Fluid {
	private CompatI_Fluid wrapper;

	// When called from Mod
	public Compat_Fluid(String fluidName) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Fluid.class, this, fluidName, null, null));
	}

	// When called from child
	protected Compat_Fluid(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Fluid(Fluid original) {
		this.initialize(Factory.createWrapper(CompatI_Fluid.class, original));
	}

	protected void initialize(CompatI_Fluid wrapper) {
		this.wrapper = wrapper;
	}

	public Fluid getReal() {
		return wrapper.get();
	}

	public Compat_Fluid Compat_setDensity(int density) {
		this.wrapper.setDensitySuper(density);

		return this;
	}

	public Compat_Fluid Compat_setViscosity(int viscosity) {
		this.wrapper.setViscositySuper(viscosity);

		return this;
	}

	public Compat_Fluid Compat_setGaseous(boolean isGaseous) {
		this.wrapper.setGaseousSuper(isGaseous);

		return this;
	}

	public String Compat_getName() {
		return this.wrapper.getNameSuper();
	}

	public int Compat_getDensity() {
		return this.wrapper.getDensitySuper();
	}

	public int Compat_getTemperature() {
		return this.wrapper.getTemperatureSuper();
	}

	public int Compat_getLuminosity() {
		return this.wrapper.getLuminositySuper();
	}

	public int Compat_getViscosity() {
		return this.wrapper.getViscositySuper();
	}

	public Compat_Fluid Compat_setBlock(Compat_Block block) {
		this.wrapper.setBlockSuper(block.getReal());
		return this;
	}

}
