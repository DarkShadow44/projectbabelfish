package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity;

import net.minecraft.entity.EnumCreatureType;

public class Compat_EnumCreatureType {

	private static final Compat_EnumCreatureType CREATURE = new Compat_EnumCreatureType(EnumCreatureType.CREATURE);
	private static final Compat_EnumCreatureType AMBIENT = new Compat_EnumCreatureType(EnumCreatureType.AMBIENT);
	private static final Compat_EnumCreatureType MONSTER = new Compat_EnumCreatureType(EnumCreatureType.MONSTER);

	private final EnumCreatureType original;

	public Compat_EnumCreatureType(EnumCreatureType original) {
		this.original = original;
	}

	public EnumCreatureType getReal() {
		return original;
	}

	public static Compat_EnumCreatureType Compat_get_creature() {
		return CREATURE;
	}

	public static Compat_EnumCreatureType Compat_get_ambient() {
		return AMBIENT;
	}

	public static Compat_EnumCreatureType Compat_get_monster() {
		return MONSTER;
	}
}
