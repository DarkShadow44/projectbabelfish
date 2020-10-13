package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import net.minecraft.item.ItemArmor.ArmorMaterial;

public class Compat_ItemArmor_ArmorMaterial {

	private static final Compat_ItemArmor_ArmorMaterial CLOTH = new Compat_ItemArmor_ArmorMaterial(ArmorMaterial.LEATHER);
	private static final Compat_ItemArmor_ArmorMaterial IRON = new Compat_ItemArmor_ArmorMaterial(ArmorMaterial.IRON);
	private static final Compat_ItemArmor_ArmorMaterial DIAMOND = new Compat_ItemArmor_ArmorMaterial(ArmorMaterial.DIAMOND);

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

	public static Compat_ItemArmor_ArmorMaterial Compat_get_IRON() {
		return IRON;
	}

	public static Compat_ItemArmor_ArmorMaterial Compat_get_DIAMOND() {
		return DIAMOND;
	}

	public int Compat_func_78046_a(int slot) {
		return original.getDurability(EntityEquipmentSlotHelper.getSlotForPosition(slot));
	}

	public int Compat_func_78044_b(int slot) {
		return this.original.getDamageReductionAmount(EntityEquipmentSlotHelper.getSlotForPosition(slot));
	}
}
