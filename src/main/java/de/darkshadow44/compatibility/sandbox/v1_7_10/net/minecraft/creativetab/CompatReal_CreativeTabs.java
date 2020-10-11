package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CompatReal_CreativeTabs extends CreativeTabs implements CompatI_CreativeTabs {
	@SuppressWarnings("unused")
	private Compat_CreativeTabs thisFake;

	public CompatReal_CreativeTabs(Compat_CreativeTabs thisFake, String label) {
		super(label);
		this.thisFake = thisFake;
	}

	@Override
	public CreativeTabs get() {
		return this;
	}

	@Override
	public ItemStack getTabIconItem() {
		// TODO
		return null;
	}
}
