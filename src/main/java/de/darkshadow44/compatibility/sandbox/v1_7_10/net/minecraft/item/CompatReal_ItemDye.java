package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import net.minecraft.item.ItemDye;

public class CompatReal_ItemDye extends ItemDye implements CompatI_ItemDye {
	@SuppressWarnings("unused")
	private Compat_ItemDye thisFake;

	public CompatReal_ItemDye(Compat_ItemDye thisFake) {
		super();
		this.thisFake = thisFake;
	}

	@Override
	public ItemDye get() {
		return this;
	}
}
