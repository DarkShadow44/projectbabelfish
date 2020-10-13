package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import net.minecraft.inventory.EntityEquipmentSlot;

public class EntityEquipmentSlotHelper {

	public static EntityEquipmentSlot getSlotForPosition(int position) {
		switch (position) {
		case 0:
			return EntityEquipmentSlot.HEAD;
		case 1:
			return EntityEquipmentSlot.CHEST;
		case 2:
			return EntityEquipmentSlot.LEGS;
		case 3:
			return EntityEquipmentSlot.FEET;
		}
		throw new RuntimeException("Invalid slot!");
	}
}
