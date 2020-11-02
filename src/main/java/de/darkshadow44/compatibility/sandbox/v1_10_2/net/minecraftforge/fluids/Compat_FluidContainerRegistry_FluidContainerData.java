package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fluids;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.item.Compat_ItemStack;

public class Compat_FluidContainerRegistry_FluidContainerData {

	private final Compat_FluidStack stack;
	private final Compat_ItemStack filledContainer;
	private final Compat_ItemStack emptyContainer;

	public Compat_FluidContainerRegistry_FluidContainerData(Compat_FluidStack stack, Compat_ItemStack filledContainer, Compat_ItemStack emptyContainer) {
		this.stack = stack;
		this.filledContainer = filledContainer;
		this.emptyContainer = emptyContainer;
	}

	public Compat_FluidStack getStack() {
		return stack;
	}

	public Compat_ItemStack getFilledContainer() {
		return filledContainer;
	}

	public Compat_ItemStack getEmptyContainer() {
		return emptyContainer;
	}
}
