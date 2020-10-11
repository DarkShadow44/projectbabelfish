package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import net.minecraft.item.ItemPickaxe;

public class CompatReal_ItemPickaxe extends ItemPickaxe implements CompatI_ItemPickaxe {
	@SuppressWarnings("unused")
	private Compat_ItemPickaxe thisFake;

	public CompatReal_ItemPickaxe(Compat_ItemPickaxe thisFake, ToolMaterial material) {
		super(material);
		this.thisFake = thisFake;
	}

	@Override
	public ItemPickaxe get() {
		return this;
	}
}
