package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import net.minecraft.item.ItemPotion;

public class CompatReal_ItemPotion extends ItemPotion implements CompatI_ItemPotion {
	@SuppressWarnings("unused")
	private Compat_ItemPotion thisFake;

	public CompatReal_ItemPotion(Compat_ItemPotion thisFake) {
		super();
		this.thisFake = thisFake;
	}

	@Override
	public ItemPotion get() {
		return this;
	}
}
