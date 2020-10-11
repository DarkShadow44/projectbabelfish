package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import net.minecraft.item.Item;

public class Compat_Item_ToolMaterial {

	Item.ToolMaterial material;

	public Compat_Item_ToolMaterial(Item.ToolMaterial material) {
		this.material = material;
	}

	public Item.ToolMaterial getReal() {
		return material;
	}
}
