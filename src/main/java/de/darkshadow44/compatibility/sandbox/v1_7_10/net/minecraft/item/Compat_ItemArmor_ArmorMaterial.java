package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import net.minecraft.item.ItemArmor.ArmorMaterial;

public class Compat_ItemArmor_ArmorMaterial {

	private static final Compat_ItemArmor_ArmorMaterial CLOTH = new Compat_ItemArmor_ArmorMaterial(ArmorMaterial.LEATHER);

	private ArmorMaterial original;

	public Compat_ItemArmor_ArmorMaterial(ArmorMaterial original) {
		this.original = original;
	}

	public ArmorMaterial getReal() {
		return original;
	}

	public static Compat_ItemArmor_ArmorMaterial Compat_get_CLOTH() {
		return CLOTH;
	}
}
