package compat.sandbox.net.minecraft.inventory;

import net.minecraft.inventory.EntityEquipmentSlot;

public enum Compat_EntityEquipmentSlot {

	MAINHAND(EntityEquipmentSlot.MAINHAND),
	OFFHAND(EntityEquipmentSlot.OFFHAND),
	FEET(EntityEquipmentSlot.FEET),
	LEGS(EntityEquipmentSlot.LEGS),
	CHEST(EntityEquipmentSlot.CHEST),
	HEAD(EntityEquipmentSlot.HEAD);

	private final EntityEquipmentSlot original;

	private Compat_EntityEquipmentSlot(EntityEquipmentSlot original) {
		this.original = original;
	}

	public EntityEquipmentSlot getReal() {
		return original;
	}

	public static Compat_EntityEquipmentSlot Compat_get_HEAD() {
		return HEAD;
	}

	public static Compat_EntityEquipmentSlot getFake(EntityEquipmentSlot real) {
		switch (real) {
		case MAINHAND:
			return MAINHAND;
		case OFFHAND:
			return OFFHAND;
		case FEET:
			return FEET;
		case LEGS:
			return LEGS;
		case CHEST:
			return CHEST;
		case HEAD:
			return HEAD;
		default:
			throw new RuntimeException("Unhandled " + real.name());
		}
	}
}
