package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraftforge.fluids;

import net.minecraftforge.fluids.Fluid;

public interface CompatI_Fluid {
	public Fluid get();

	public Fluid setDensitySuper(int density);

	public Fluid setViscositySuper(int viscosity);

	public Fluid setGaseousSuper(boolean isGaseous);
}
