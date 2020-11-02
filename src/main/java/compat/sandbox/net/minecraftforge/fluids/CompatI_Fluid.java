package compat.sandbox.net.minecraftforge.fluids;

import net.minecraft.block.Block;
import net.minecraftforge.fluids.Fluid;

public interface CompatI_Fluid {
	public Fluid get();

	public Fluid setDensitySuper(int density);

	public Fluid setViscositySuper(int viscosity);

	public Fluid setGaseousSuper(boolean isGaseous);

	public String getNameSuper();

	public int getDensitySuper();

	public int getTemperatureSuper();

	public int getLuminositySuper();

	public int getViscositySuper();

	public Fluid setBlockSuper(Block real);
}
