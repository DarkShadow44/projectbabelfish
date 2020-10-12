package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraftforge.fluids;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block.Compat_Block;
import net.minecraftforge.fluids.Fluid;

public class Compat_Fluid {
	private Fluid original;
	private CompatI_Fluid thisReal;

	// When called from Mod
	public Compat_Fluid(String fluidName) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Fluid.class, this, fluidName, null, null), null);
	}

	// When called from child
	protected Compat_Fluid(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Fluid(Fluid original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_Fluid thisReal, Fluid original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public Fluid getReal() {
		return original == null ? thisReal.get() : original;
	}

	public Compat_Fluid Compat_setDensity(int density) {
		if (original == null)
			this.thisReal.setDensitySuper(density);
		else
			this.original.setDensity(density);

		return this;
	}

	public Compat_Fluid Compat_setViscosity(int viscosity) {
		if (original == null)
			this.thisReal.setViscositySuper(viscosity);
		else
			this.original.setViscosity(viscosity);

		return this;
	}

	public Compat_Fluid Compat_setGaseous(boolean isGaseous) {
		if (original == null)
			this.thisReal.setGaseousSuper(isGaseous);
		else
			this.original.setGaseous(isGaseous);

		return this;
	}

	public String Compat_getName() {
		if (original == null)
			return this.thisReal.getNameSuper();
		else
			return this.original.getName();
	}

	public int Compat_getDensity() {
		if (original == null)
			return this.thisReal.getDensitySuper();
		else
			return this.original.getDensity();
	}

	public int Compat_getTemperature() {
		if (original == null)
			return this.thisReal.getTemperatureSuper();
		else
			return this.original.getTemperature();
	}

	public int Compat_getLuminosity() {
		if (original == null)
			return this.thisReal.getLuminositySuper();
		else
			return this.original.getLuminosity();
	}

	public int Compat_getViscosity() {
		if (original == null)
			return this.thisReal.getViscositySuper();
		else
			return this.original.getViscosity();
	}

	public Compat_Fluid Compat_setBlock(Compat_Block block) {
		if (original == null)
			this.thisReal.setBlockSuper(block.getReal());
		else
			this.original.setBlock(block.getReal());
		return this;
	}

}
