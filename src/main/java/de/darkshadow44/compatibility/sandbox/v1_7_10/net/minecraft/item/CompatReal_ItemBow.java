package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import net.minecraft.item.ItemBow;

public class CompatReal_ItemBow extends ItemBow implements CompatI_ItemBow {
	@SuppressWarnings("unused")
	private Compat_ItemBow thisFake;

	public CompatReal_ItemBow(Compat_ItemBow thisFake) {
		super();
		this.thisFake = thisFake;
	}

	@Override
	public ItemBow get() {
		return this;
	}
}
