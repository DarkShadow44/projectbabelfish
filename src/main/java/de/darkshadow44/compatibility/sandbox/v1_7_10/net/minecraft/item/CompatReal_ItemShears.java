package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import net.minecraft.item.ItemShears;

public class CompatReal_ItemShears extends ItemShears implements CompatI_ItemShears {
	@SuppressWarnings("unused")
	private Compat_ItemShears thisFake;

	public CompatReal_ItemShears(Compat_ItemShears thisFake) {
		super();
		this.thisFake = thisFake;
	}

	@Override
	public ItemShears get() {
		return this;
	}
}
