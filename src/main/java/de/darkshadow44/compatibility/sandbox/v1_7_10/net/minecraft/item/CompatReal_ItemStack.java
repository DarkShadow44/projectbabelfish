package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CompatReal_ItemStack extends ItemStack implements CompatI_ItemStack {
	@SuppressWarnings("unused")
	private Compat_ItemStack thisFake;

	public CompatReal_ItemStack(Compat_ItemStack thisFake, Item item) {
		super(item);
		this.thisFake = thisFake;
	}

	@Override
	public ItemStack get() {
		return this;
	}
}
