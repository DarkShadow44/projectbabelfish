package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import net.minecraft.item.ItemArmor;

public class CompatReal_ItemArmor extends ItemArmor implements CompatI_ItemArmor {
	@SuppressWarnings("unused")
	private Compat_ItemArmor thisFake;

	public CompatReal_ItemArmor(Compat_ItemArmor thisFake) {
		super(ArmorMaterial.CHAIN, 0, null); // TODO
		this.thisFake = thisFake;
	}

	@Override
	public ItemArmor get() {
		return this;
	}
}
