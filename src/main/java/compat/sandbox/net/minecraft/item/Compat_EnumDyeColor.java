package compat.sandbox.net.minecraft.item;

import compat.sandbox.net.minecraft.block.material.Compat_MapColor;
import net.minecraft.block.material.MapColor;
import net.minecraft.item.EnumDyeColor;

public enum Compat_EnumDyeColor {

	BLUE(EnumDyeColor.BLUE),
	SILVER(EnumDyeColor.SILVER),
	WHITE(EnumDyeColor.WHITE),
	YELLOW(EnumDyeColor.YELLOW),
	RED(EnumDyeColor.RED);

	private EnumDyeColor original;

	private Compat_EnumDyeColor(EnumDyeColor original) {
		this.original = original;
	}

	public EnumDyeColor getReal() {
		return original;
	}

	public static Compat_EnumDyeColor getFake(EnumDyeColor real) {
		switch (real) {
		case BLUE:
			return BLUE;
		case SILVER:
			return SILVER;
		case WHITE:
			return WHITE;
		case YELLOW:
			return YELLOW;
		case RED:
			return RED;
		default:
			throw new RuntimeException("Unhandled " + real);
		}
	}

	public static Compat_EnumDyeColor Compat_get_BLUE() {
		return BLUE;
	}

	public static Compat_EnumDyeColor Compat_get_RED() {
		return RED;
	}

	public int Compat_func_176767_b() {
		return original.getDyeDamage();
	}

	public String Compat_func_176610_l() {
		return original.getName();
	}

	public static Compat_EnumDyeColor Compat_func_176764_b(int meta) {
		return getFake(EnumDyeColor.byMetadata(meta));
	}

	public int Compat_func_176765_a() {
		return original.getMetadata();
	}

	public int Compat_ordinal() {
		return original.ordinal();
	}

	public String Compat_name() {
		return original.name();
	}

	Compat_MapColor Compat_func_176768_e() {
		return Compat_MapColor.getFake(MapColor.getBlockColor(this.getReal()));
	}

	public static Compat_EnumDyeColor Compat_get_SILVER() {
		return SILVER;
	}

	public static Compat_EnumDyeColor Compat_get_WHITE() {
		return WHITE;
	}

	public static Compat_EnumDyeColor Compat_get_YELLOW() {
		return YELLOW;
	}
}
