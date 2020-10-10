package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraftforge.fluids;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class CompatReal_Fluid extends Fluid {

	@SuppressWarnings("unused")
	private Compat_Fluid thisFake;

	public CompatReal_Fluid(Compat_Fluid thisFake, String fluidName) {
		super(fluidName, new ResourceLocation("dummy"), new ResourceLocation("dummy")); // TODO
		this.thisFake = thisFake;
	}

}
