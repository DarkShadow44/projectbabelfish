package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import net.minecraft.item.Item;

public class CompatReal_Item extends Item implements CompatI_Item {
	@SuppressWarnings("unused")
	private Compat_Item thisFake;

	public CompatReal_Item(Compat_Item thisFake) {
		super();
		this.thisFake = thisFake;
	}

	@Override
	public Item get() {
		return this;
	}
}
