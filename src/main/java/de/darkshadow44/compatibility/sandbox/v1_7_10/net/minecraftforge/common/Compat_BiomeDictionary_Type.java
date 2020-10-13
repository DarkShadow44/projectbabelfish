package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraftforge.common;

import net.minecraftforge.common.BiomeDictionary.Type;

public class Compat_BiomeDictionary_Type {

	private static final Compat_BiomeDictionary_Type BEACH = new Compat_BiomeDictionary_Type(Type.BEACH);
	private static final Compat_BiomeDictionary_Type FOREST = new Compat_BiomeDictionary_Type(Type.FOREST);
	private static final Compat_BiomeDictionary_Type HILLS = new Compat_BiomeDictionary_Type(Type.HILLS);
	private static final Compat_BiomeDictionary_Type MESA = new Compat_BiomeDictionary_Type(Type.MESA);
	private static final Compat_BiomeDictionary_Type MOUNTAIN = new Compat_BiomeDictionary_Type(Type.MOUNTAIN);
	private static final Compat_BiomeDictionary_Type PLAINS = new Compat_BiomeDictionary_Type(Type.PLAINS);
	private static final Compat_BiomeDictionary_Type SANDY = new Compat_BiomeDictionary_Type(Type.SANDY);
	private static final Compat_BiomeDictionary_Type SNOWY = new Compat_BiomeDictionary_Type(Type.SNOWY);
	private static final Compat_BiomeDictionary_Type SWAMP = new Compat_BiomeDictionary_Type(Type.SWAMP);
	private static final Compat_BiomeDictionary_Type WASTELAND = new Compat_BiomeDictionary_Type(Type.WASTELAND);
	private static final Compat_BiomeDictionary_Type RIVER = new Compat_BiomeDictionary_Type(Type.RIVER);
	private static final Compat_BiomeDictionary_Type OCEAN = new Compat_BiomeDictionary_Type(Type.OCEAN);
	private static final Compat_BiomeDictionary_Type SPOOKY = new Compat_BiomeDictionary_Type(Type.SPOOKY);
	private static final Compat_BiomeDictionary_Type MAGICAL = new Compat_BiomeDictionary_Type(Type.MAGICAL);

	private Type original;

	public Compat_BiomeDictionary_Type(Type original) {
		this.original = original;
	}

	public Type getReal() {
		return original;
	}

	public static Compat_BiomeDictionary_Type Compat_get_BEACH() {
		return BEACH;
	}

	public static Compat_BiomeDictionary_Type Compat_get_FOREST() {
		return FOREST;
	}

	public static Compat_BiomeDictionary_Type Compat_get_HILLS() {
		return HILLS;
	}

	public static Compat_BiomeDictionary_Type Compat_get_MESA() {
		return MESA;
	}

	public static Compat_BiomeDictionary_Type Compat_get_MOUNTAIN() {
		return MOUNTAIN;
	}

	public static Compat_BiomeDictionary_Type Compat_get_PLAINS() {
		return PLAINS;
	}

	public static Compat_BiomeDictionary_Type Compat_get_SANDY() {
		return SANDY;
	}

	public static Compat_BiomeDictionary_Type Compat_get_SNOWY() {
		return SNOWY;
	}

	public static Compat_BiomeDictionary_Type Compat_get_SWAMP() {
		return SWAMP;
	}

	public static Compat_BiomeDictionary_Type Compat_get_WASTELAND() {
		return WASTELAND;
	}

	public static Compat_BiomeDictionary_Type Compat_get_RIVER() {
		return RIVER;
	}

	public static Compat_BiomeDictionary_Type Compat_get_OCEAN() {
		return OCEAN;
	}

	public static Compat_BiomeDictionary_Type Compat_get_SPOOKY() {
		return SPOOKY;
	}

	public static Compat_BiomeDictionary_Type Compat_get_MAGICAL() {
		return MAGICAL;
	}
}
