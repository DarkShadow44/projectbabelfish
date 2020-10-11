package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import net.minecraft.item.ItemFood;

public class CompatReal_ItemFood extends ItemFood implements CompatI_ItemFood {
	@SuppressWarnings("unused")
	private Compat_ItemFood thisFake;

	public CompatReal_ItemFood(Compat_ItemFood thisFake, int p1, boolean p2) {
		super(p1, p2);
		this.thisFake = thisFake;
	}

	@Override
	public ItemFood get() {
		return this;
	}
}
