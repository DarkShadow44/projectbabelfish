package compat.sandbox.net.minecraft.block.material;

import net.minecraft.block.material.MaterialColor;

public class Compat_MapColor {

	private static final Compat_MapColor AIR = new Compat_MapColor(MaterialColor.AIR);
	private static final Compat_MapColor GRASS = new Compat_MapColor(MaterialColor.GRASS);
	private static final Compat_MapColor SAND = new Compat_MapColor(MaterialColor.SAND);
	private static final Compat_MapColor CLOTH = new Compat_MapColor(MaterialColor.WOOL);
	private static final Compat_MapColor TNT = new Compat_MapColor(MaterialColor.TNT);
	private static final Compat_MapColor ICE = new Compat_MapColor(MaterialColor.ICE);
	private static final Compat_MapColor IRON = new Compat_MapColor(MaterialColor.IRON);
	private static final Compat_MapColor FOLIAGE = new Compat_MapColor(MaterialColor.FOLIAGE);
	private static final Compat_MapColor SNOW = new Compat_MapColor(MaterialColor.SNOW);
	private static final Compat_MapColor CLAY = new Compat_MapColor(MaterialColor.CLAY);
	private static final Compat_MapColor DIRT = new Compat_MapColor(MaterialColor.DIRT);
	private static final Compat_MapColor STONE = new Compat_MapColor(MaterialColor.STONE);
	private static final Compat_MapColor WATER = new Compat_MapColor(MaterialColor.WATER);
	private static final Compat_MapColor WOOD = new Compat_MapColor(MaterialColor.WOOD);
	private static final Compat_MapColor QUARTZ = new Compat_MapColor(MaterialColor.QUARTZ);
	private static final Compat_MapColor ADOBE = new Compat_MapColor(MaterialColor.ADOBE);
	private static final Compat_MapColor MAGENTA = new Compat_MapColor(MaterialColor.MAGENTA);
	private static final Compat_MapColor LIGHT_BLUE = new Compat_MapColor(MaterialColor.LIGHT_BLUE);
	private static final Compat_MapColor YELLOW = new Compat_MapColor(MaterialColor.YELLOW);
	private static final Compat_MapColor LIME = new Compat_MapColor(MaterialColor.LIME);
	private static final Compat_MapColor PINK = new Compat_MapColor(MaterialColor.PINK);
	private static final Compat_MapColor GRAY = new Compat_MapColor(MaterialColor.GRAY);
	private static final Compat_MapColor SILVER = new Compat_MapColor(MaterialColor.LIGHT_GRAY);
	private static final Compat_MapColor CYAN = new Compat_MapColor(MaterialColor.CYAN);
	private static final Compat_MapColor PURPLE = new Compat_MapColor(MaterialColor.PURPLE);
	private static final Compat_MapColor BLUE = new Compat_MapColor(MaterialColor.BLUE);
	private static final Compat_MapColor BROWN = new Compat_MapColor(MaterialColor.BROWN);
	private static final Compat_MapColor GREEN = new Compat_MapColor(MaterialColor.GREEN);
	private static final Compat_MapColor RED = new Compat_MapColor(MaterialColor.RED);
	private static final Compat_MapColor BLACK = new Compat_MapColor(MaterialColor.BLACK);
	private static final Compat_MapColor GOLD = new Compat_MapColor(MaterialColor.GOLD);
	private static final Compat_MapColor DIAMOND = new Compat_MapColor(MaterialColor.DIAMOND);
	private static final Compat_MapColor LAPIS = new Compat_MapColor(MaterialColor.LAPIS);
	private static final Compat_MapColor EMERALD = new Compat_MapColor(MaterialColor.EMERALD);
	private static final Compat_MapColor OBSIDIAN = new Compat_MapColor(MaterialColor.OBSIDIAN);
	private static final Compat_MapColor NETHERRACK = new Compat_MapColor(MaterialColor.NETHERRACK);

	private static final Compat_MapColor WHITE_TERRACOTTA = new Compat_MapColor(MaterialColor.WHITE_TERRACOTTA);
	private static final Compat_MapColor ORANGE_TERRACOTTA = new Compat_MapColor(MaterialColor.ORANGE_TERRACOTTA);
	private static final Compat_MapColor MAGENTA_TERRACOTTA = new Compat_MapColor(MaterialColor.MAGENTA_TERRACOTTA);
	private static final Compat_MapColor LIGHT_BLUE_TERRACOTTA = new Compat_MapColor(
			MaterialColor.LIGHT_BLUE_TERRACOTTA);
	private static final Compat_MapColor YELLOW_TERRACOTTA = new Compat_MapColor(MaterialColor.YELLOW_TERRACOTTA);
	private static final Compat_MapColor LIME_TERRACOTTA = new Compat_MapColor(MaterialColor.LIME_TERRACOTTA);
	private static final Compat_MapColor PINK_TERRACOTTA = new Compat_MapColor(MaterialColor.PINK_TERRACOTTA);
	private static final Compat_MapColor GRAY_TERRACOTTA = new Compat_MapColor(MaterialColor.GRAY_TERRACOTTA);
	private static final Compat_MapColor SILVER_TERRACOTTA = new Compat_MapColor(MaterialColor.LIGHT_GRAY_TERRACOTTA);
	private static final Compat_MapColor CYAN_TERRACOTTA = new Compat_MapColor(MaterialColor.CYAN_TERRACOTTA);
	private static final Compat_MapColor PURPLE_TERRACOTTA = new Compat_MapColor(MaterialColor.PURPLE_TERRACOTTA);
	private static final Compat_MapColor BLUE_TERRACOTTA = new Compat_MapColor(MaterialColor.BLUE_TERRACOTTA);
	private static final Compat_MapColor BROWN_TERRACOTTA = new Compat_MapColor(MaterialColor.BROWN_TERRACOTTA);
	private static final Compat_MapColor GREEN_TERRACOTTA = new Compat_MapColor(MaterialColor.GREEN_TERRACOTTA);
	private static final Compat_MapColor RED_TERRACOTTA = new Compat_MapColor(MaterialColor.RED_TERRACOTTA);
	private static final Compat_MapColor BLACK_TERRACOTTA = new Compat_MapColor(MaterialColor.BLACK_TERRACOTTA);

	private final MaterialColor original;

	public Compat_MapColor(MaterialColor original) {
		this.original = original;
	}

	public MaterialColor getReal() {
		return original;
	}

	public static Compat_MapColor Compat_get_field_151664_l() {
		return DIRT;
	}

	public static Compat_MapColor Compat_get_field_151661_c() {
		return GRASS;
	}

	public static Compat_MapColor Compat_get_field_151660_b() {
		return AIR;
	}

	public static Compat_MapColor getFake(MaterialColor real) {
		if (real == MaterialColor.AIR)
			return AIR;

		if (real == MaterialColor.GRASS)
			return GRASS;

		if (real == MaterialColor.SAND)
			return SAND;

		if (real == MaterialColor.WOOL)
			return CLOTH;

		if (real == MaterialColor.TNT)
			return TNT;

		if (real == MaterialColor.ICE)
			return ICE;

		if (real == MaterialColor.IRON)
			return IRON;

		if (real == MaterialColor.FOLIAGE)
			return FOLIAGE;

		if (real == MaterialColor.SNOW)
			return SNOW;

		if (real == MaterialColor.CLAY)
			return CLAY;

		if (real == MaterialColor.DIRT)
			return DIRT;

		if (real == MaterialColor.STONE)
			return STONE;

		if (real == MaterialColor.WATER)
			return WATER;

		if (real == MaterialColor.WOOD)
			return WOOD;

		if (real == MaterialColor.QUARTZ)
			return QUARTZ;

		if (real == MaterialColor.ADOBE)
			return ADOBE;

		if (real == MaterialColor.MAGENTA)
			return MAGENTA;

		if (real == MaterialColor.LIGHT_BLUE)
			return LIGHT_BLUE;

		if (real == MaterialColor.YELLOW)
			return YELLOW;

		if (real == MaterialColor.LIME)
			return LIME;

		if (real == MaterialColor.PINK)
			return PINK;

		if (real == MaterialColor.GRAY)
			return GRAY;

		if (real == MaterialColor.LIGHT_GRAY)
			return SILVER;

		if (real == MaterialColor.CYAN)
			return CYAN;

		if (real == MaterialColor.PURPLE)
			return PURPLE;

		if (real == MaterialColor.BLUE)
			return BLUE;

		if (real == MaterialColor.BROWN)
			return BROWN;

		if (real == MaterialColor.GREEN)
			return GREEN;

		if (real == MaterialColor.RED)
			return RED;

		if (real == MaterialColor.BLACK)
			return BLACK;

		if (real == MaterialColor.GOLD)
			return GOLD;

		if (real == MaterialColor.DIAMOND)
			return DIAMOND;

		if (real == MaterialColor.LAPIS)
			return LAPIS;

		if (real == MaterialColor.EMERALD)
			return EMERALD;

		if (real == MaterialColor.OBSIDIAN)
			return OBSIDIAN;

		if (real == MaterialColor.NETHERRACK)
			return NETHERRACK;

		if (real == MaterialColor.WHITE_TERRACOTTA)
			return WHITE_TERRACOTTA;

		if (real == MaterialColor.ORANGE_TERRACOTTA)
			return ORANGE_TERRACOTTA;

		if (real == MaterialColor.MAGENTA_TERRACOTTA)
			return MAGENTA_TERRACOTTA;

		if (real == MaterialColor.LIGHT_BLUE_TERRACOTTA)
			return LIGHT_BLUE_TERRACOTTA;

		if (real == MaterialColor.YELLOW_TERRACOTTA)
			return YELLOW_TERRACOTTA;

		if (real == MaterialColor.LIME_TERRACOTTA)
			return LIME_TERRACOTTA;

		if (real == MaterialColor.PINK_TERRACOTTA)
			return PINK_TERRACOTTA;

		if (real == MaterialColor.GRAY_TERRACOTTA)
			return GRAY_TERRACOTTA;

		if (real == MaterialColor.LIGHT_GRAY_TERRACOTTA)
			return SILVER_TERRACOTTA;

		if (real == MaterialColor.CYAN_TERRACOTTA)
			return CYAN_TERRACOTTA;

		if (real == MaterialColor.PURPLE_TERRACOTTA)
			return PURPLE_TERRACOTTA;

		if (real == MaterialColor.BLUE_TERRACOTTA)
			return BLUE_TERRACOTTA;

		if (real == MaterialColor.BROWN_TERRACOTTA)
			return BROWN_TERRACOTTA;

		if (real == MaterialColor.GREEN_TERRACOTTA)
			return GREEN_TERRACOTTA;

		if (real == MaterialColor.RED_TERRACOTTA)
			return RED_TERRACOTTA;

		if (real == MaterialColor.BLACK_TERRACOTTA)
			return BLACK_TERRACOTTA;

		throw new RuntimeException("Unhandled " + real);
	}

	public int Compat_get_field_76291_p() {
		return original.colorValue;
	}

	public static Compat_MapColor Compat_get_field_151656_f() {
		return TNT;
	}

	public static Compat_MapColor Compat_get_field_151646_E() {
		return BLACK;
	}

}
