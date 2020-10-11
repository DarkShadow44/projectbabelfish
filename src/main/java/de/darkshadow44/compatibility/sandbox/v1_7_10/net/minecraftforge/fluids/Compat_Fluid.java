package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraftforge.fluids;

import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block.Compat_Block;
import net.minecraftforge.fluids.Fluid;

public class Compat_Fluid {
	private CompatReal_Fluid thisReal;

	public Compat_Fluid(String fluidName) {
		this.thisReal = new CompatReal_Fluid(this, fluidName);
	}

	public Compat_Fluid Compat_setDensity(int density) {
		thisReal.setDensity(density);
		return this;
	}

	public Compat_Fluid Compat_setViscosity(int viscosity) {
		thisReal.setViscosity(viscosity);
		return this;
	}

	public Compat_Fluid Compat_setGaseous(boolean isGaseous) {
		thisReal.setGaseous(isGaseous);
		return this;
	}

	public Fluid getReal() {
		return thisReal;
	}

	public String Compat_getName() {
		return this.thisReal.getName();
	}

	public int Compat_getDensity() {
		return this.thisReal.getDensity();
	}

	public int Compat_getTemperature() {
		return this.thisReal.getTemperature();
	}

	public int Compat_getLuminosity() {
		return this.thisReal.getLuminosity();
	}

	public int Compat_getViscosity() {
		return this.thisReal.getViscosity();
	}

	public Compat_Fluid Compat_setBlock(Compat_Block block) {
		this.thisReal.setBlock(block.getReal());
		return this;
	}
}
