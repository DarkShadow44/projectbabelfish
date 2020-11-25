package compat.sandbox.net.minecraft.block.material;

import net.minecraft.block.material.MapColor;

public class Compat_MapColor {

	private static final Compat_MapColor AIR = new Compat_MapColor(MapColor.AIR);
	private static final Compat_MapColor GRASS = new Compat_MapColor(MapColor.GRASS);
	private static final Compat_MapColor SAND = new Compat_MapColor(MapColor.SAND);
	private static final Compat_MapColor CLOTH = new Compat_MapColor(MapColor.CLOTH);
	private static final Compat_MapColor TNT = new Compat_MapColor(MapColor.TNT);
	private static final Compat_MapColor ICE = new Compat_MapColor(MapColor.ICE);
	private static final Compat_MapColor IRON = new Compat_MapColor(MapColor.IRON);
	private static final Compat_MapColor FOLIAGE = new Compat_MapColor(MapColor.FOLIAGE);
	private static final Compat_MapColor SNOW = new Compat_MapColor(MapColor.SNOW);
	private static final Compat_MapColor CLAY = new Compat_MapColor(MapColor.CLAY);
	private static final Compat_MapColor DIRT = new Compat_MapColor(MapColor.DIRT);
	private static final Compat_MapColor STONE = new Compat_MapColor(MapColor.STONE);
	private static final Compat_MapColor WATER = new Compat_MapColor(MapColor.WATER);
	private static final Compat_MapColor WOOD = new Compat_MapColor(MapColor.WOOD);
	private static final Compat_MapColor QUARTZ = new Compat_MapColor(MapColor.QUARTZ);
	private static final Compat_MapColor ADOBE = new Compat_MapColor(MapColor.ADOBE);
	private static final Compat_MapColor MAGENTA = new Compat_MapColor(MapColor.MAGENTA);
	private static final Compat_MapColor LIGHT_BLUE = new Compat_MapColor(MapColor.LIGHT_BLUE);
	private static final Compat_MapColor YELLOW = new Compat_MapColor(MapColor.YELLOW);
	private static final Compat_MapColor LIME = new Compat_MapColor(MapColor.LIME);
	private static final Compat_MapColor PINK = new Compat_MapColor(MapColor.PINK);
	private static final Compat_MapColor GRAY = new Compat_MapColor(MapColor.GRAY);
	private static final Compat_MapColor SILVER = new Compat_MapColor(MapColor.SILVER);
	private static final Compat_MapColor CYAN = new Compat_MapColor(MapColor.CYAN);
	private static final Compat_MapColor PURPLE = new Compat_MapColor(MapColor.PURPLE);
	private static final Compat_MapColor BLUE = new Compat_MapColor(MapColor.BLUE);
	private static final Compat_MapColor BROWN = new Compat_MapColor(MapColor.BROWN);
	private static final Compat_MapColor GREEN = new Compat_MapColor(MapColor.GREEN);
	private static final Compat_MapColor RED = new Compat_MapColor(MapColor.RED);
	private static final Compat_MapColor BLACK = new Compat_MapColor(MapColor.BLACK);
	private static final Compat_MapColor GOLD = new Compat_MapColor(MapColor.GOLD);
	private static final Compat_MapColor DIAMOND = new Compat_MapColor(MapColor.DIAMOND);
	private static final Compat_MapColor LAPIS = new Compat_MapColor(MapColor.LAPIS);
	private static final Compat_MapColor EMERALD = new Compat_MapColor(MapColor.EMERALD);
	private static final Compat_MapColor OBSIDIAN = new Compat_MapColor(MapColor.OBSIDIAN);
	private static final Compat_MapColor NETHERRACK = new Compat_MapColor(MapColor.NETHERRACK);

	private static final Compat_MapColor WHITE_STAINED_HARDENED_CLAY = new Compat_MapColor(MapColor.WHITE_STAINED_HARDENED_CLAY);
	private static final Compat_MapColor ORANGE_STAINED_HARDENED_CLAY = new Compat_MapColor(MapColor.ORANGE_STAINED_HARDENED_CLAY);
	private static final Compat_MapColor MAGENTA_STAINED_HARDENED_CLAY = new Compat_MapColor(MapColor.MAGENTA_STAINED_HARDENED_CLAY);
	private static final Compat_MapColor LIGHT_BLUE_STAINED_HARDENED_CLAY = new Compat_MapColor(MapColor.LIGHT_BLUE_STAINED_HARDENED_CLAY);
	private static final Compat_MapColor YELLOW_STAINED_HARDENED_CLAY = new Compat_MapColor(MapColor.YELLOW_STAINED_HARDENED_CLAY);
	private static final Compat_MapColor LIME_STAINED_HARDENED_CLAY = new Compat_MapColor(MapColor.LIME_STAINED_HARDENED_CLAY);
	private static final Compat_MapColor PINK_STAINED_HARDENED_CLAY = new Compat_MapColor(MapColor.PINK_STAINED_HARDENED_CLAY);
	private static final Compat_MapColor GRAY_STAINED_HARDENED_CLAY = new Compat_MapColor(MapColor.GRAY_STAINED_HARDENED_CLAY);
	private static final Compat_MapColor SILVER_STAINED_HARDENED_CLAY = new Compat_MapColor(MapColor.SILVER_STAINED_HARDENED_CLAY);
	private static final Compat_MapColor CYAN_STAINED_HARDENED_CLAY = new Compat_MapColor(MapColor.CYAN_STAINED_HARDENED_CLAY);
	private static final Compat_MapColor PURPLE_STAINED_HARDENED_CLAY = new Compat_MapColor(MapColor.PURPLE_STAINED_HARDENED_CLAY);
	private static final Compat_MapColor BLUE_STAINED_HARDENED_CLAY = new Compat_MapColor(MapColor.BLUE_STAINED_HARDENED_CLAY);
	private static final Compat_MapColor BROWN_STAINED_HARDENED_CLAY = new Compat_MapColor(MapColor.BROWN_STAINED_HARDENED_CLAY);
	private static final Compat_MapColor GREEN_STAINED_HARDENED_CLAY = new Compat_MapColor(MapColor.GREEN_STAINED_HARDENED_CLAY);
	private static final Compat_MapColor RED_STAINED_HARDENED_CLAY = new Compat_MapColor(MapColor.RED_STAINED_HARDENED_CLAY);
	private static final Compat_MapColor BLACK_STAINED_HARDENED_CLAY = new Compat_MapColor(MapColor.BLACK_STAINED_HARDENED_CLAY);

	private final MapColor original;

	public Compat_MapColor(MapColor original) {
		this.original = original;
	}

	public MapColor getReal() {
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

	public static Compat_MapColor getFake(MapColor real) {
		if (real == MapColor.AIR)
			return AIR;

		if (real == MapColor.GRASS)
			return GRASS;

		if (real == MapColor.SAND)
			return SAND;

		if (real == MapColor.CLOTH)
			return CLOTH;

		if (real == MapColor.TNT)
			return TNT;

		if (real == MapColor.ICE)
			return ICE;

		if (real == MapColor.IRON)
			return IRON;

		if (real == MapColor.FOLIAGE)
			return FOLIAGE;

		if (real == MapColor.SNOW)
			return SNOW;

		if (real == MapColor.CLAY)
			return CLAY;

		if (real == MapColor.DIRT)
			return DIRT;

		if (real == MapColor.STONE)
			return STONE;

		if (real == MapColor.WATER)
			return WATER;

		if (real == MapColor.WOOD)
			return WOOD;

		if (real == MapColor.QUARTZ)
			return QUARTZ;

		if (real == MapColor.ADOBE)
			return ADOBE;

		if (real == MapColor.MAGENTA)
			return MAGENTA;

		if (real == MapColor.LIGHT_BLUE)
			return LIGHT_BLUE;

		if (real == MapColor.YELLOW)
			return YELLOW;

		if (real == MapColor.LIME)
			return LIME;

		if (real == MapColor.PINK)
			return PINK;

		if (real == MapColor.GRAY)
			return GRAY;

		if (real == MapColor.SILVER)
			return SILVER;

		if (real == MapColor.CYAN)
			return CYAN;

		if (real == MapColor.PURPLE)
			return PURPLE;

		if (real == MapColor.BLUE)
			return BLUE;

		if (real == MapColor.BROWN)
			return BROWN;

		if (real == MapColor.GREEN)
			return GREEN;

		if (real == MapColor.RED)
			return RED;

		if (real == MapColor.BLACK)
			return BLACK;

		if (real == MapColor.GOLD)
			return GOLD;

		if (real == MapColor.DIAMOND)
			return DIAMOND;

		if (real == MapColor.LAPIS)
			return LAPIS;

		if (real == MapColor.EMERALD)
			return EMERALD;

		if (real == MapColor.OBSIDIAN)
			return OBSIDIAN;

		if (real == MapColor.NETHERRACK)
			return NETHERRACK;

		if (real == MapColor.WHITE_STAINED_HARDENED_CLAY)
			return WHITE_STAINED_HARDENED_CLAY;

		if (real == MapColor.ORANGE_STAINED_HARDENED_CLAY)
			return ORANGE_STAINED_HARDENED_CLAY;

		if (real == MapColor.MAGENTA_STAINED_HARDENED_CLAY)
			return MAGENTA_STAINED_HARDENED_CLAY;

		if (real == MapColor.LIGHT_BLUE_STAINED_HARDENED_CLAY)
			return LIGHT_BLUE_STAINED_HARDENED_CLAY;

		if (real == MapColor.YELLOW_STAINED_HARDENED_CLAY)
			return YELLOW_STAINED_HARDENED_CLAY;

		if (real == MapColor.LIME_STAINED_HARDENED_CLAY)
			return LIME_STAINED_HARDENED_CLAY;

		if (real == MapColor.PINK_STAINED_HARDENED_CLAY)
			return PINK_STAINED_HARDENED_CLAY;

		if (real == MapColor.GRAY_STAINED_HARDENED_CLAY)
			return GRAY_STAINED_HARDENED_CLAY;

		if (real == MapColor.SILVER_STAINED_HARDENED_CLAY)
			return SILVER_STAINED_HARDENED_CLAY;

		if (real == MapColor.CYAN_STAINED_HARDENED_CLAY)
			return CYAN_STAINED_HARDENED_CLAY;

		if (real == MapColor.PURPLE_STAINED_HARDENED_CLAY)
			return PURPLE_STAINED_HARDENED_CLAY;

		if (real == MapColor.BLUE_STAINED_HARDENED_CLAY)
			return BLUE_STAINED_HARDENED_CLAY;

		if (real == MapColor.BROWN_STAINED_HARDENED_CLAY)
			return BROWN_STAINED_HARDENED_CLAY;

		if (real == MapColor.GREEN_STAINED_HARDENED_CLAY)
			return GREEN_STAINED_HARDENED_CLAY;

		if (real == MapColor.RED_STAINED_HARDENED_CLAY)
			return RED_STAINED_HARDENED_CLAY;

		if (real == MapColor.BLACK_STAINED_HARDENED_CLAY)
			return BLACK_STAINED_HARDENED_CLAY;

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
