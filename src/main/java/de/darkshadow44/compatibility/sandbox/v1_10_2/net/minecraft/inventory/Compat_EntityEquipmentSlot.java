package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.inventory;

import net.minecraft.inventory.EntityEquipmentSlot;

public class Compat_EntityEquipmentSlot {

	private static final Compat_EntityEquipmentSlot HEAD = new Compat_EntityEquipmentSlot(EntityEquipmentSlot.HEAD);

	private EntityEquipmentSlot original;

	public Compat_EntityEquipmentSlot(EntityEquipmentSlot original) {
		this.original = original;
	}

	public EntityEquipmentSlot getReal() {
		return original;
	}

	public static Compat_EntityEquipmentSlot Compat_get_HEAD() {
		return HEAD;
	}
}
