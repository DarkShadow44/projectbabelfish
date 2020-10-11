package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import net.minecraft.item.ItemSword;

public class CompatReal_ItemSword extends ItemSword implements CompatI_ItemSword {
	@SuppressWarnings("unused")
	private Compat_ItemSword thisFake;

	public CompatReal_ItemSword(Compat_ItemSword thisFake, ToolMaterial material) {
		super(material);
		this.thisFake = thisFake;
	}

	@Override
	public ItemSword get() {
		return this;
	}
}
