package compat.sandbox.net.minecraft.init;

import compat.sandbox.net.minecraft.block.Compat_Block;
import compat.sandbox.net.minecraft.block.Compat_BlockBush;
import compat.sandbox.net.minecraft.block.Compat_BlockChest;
import compat.sandbox.net.minecraft.block.Compat_BlockDaylightDetector;
import compat.sandbox.net.minecraft.block.Compat_BlockDeadBush;
import compat.sandbox.net.minecraft.block.Compat_BlockFire;
import compat.sandbox.net.minecraft.block.Compat_BlockFlower;
import compat.sandbox.net.minecraft.block.Compat_BlockPistonBase;
import compat.sandbox.net.minecraft.block.Compat_BlockRedstoneWire;
import compat.sandbox.net.minecraft.block.Compat_BlockSand;
import compat.sandbox.net.minecraft.block.Compat_BlockSlab;
import compat.sandbox.net.minecraft.block.Compat_BlockStainedGlass;
import net.minecraft.init.Blocks;

public class Compat_Blocks {

	private static final Compat_Block REDSTONE_LAMP = Compat_Block.getFake(Blocks.REDSTONE_LAMP);
	private static final Compat_BlockSlab STONE_SLAB = new Compat_BlockSlab(Blocks.STONE_SLAB);
	private static final Compat_Block WOOL = Compat_Block.getFake(Blocks.WOOL);
	private static final Compat_Block REDSTONE_TORCH = Compat_Block.getFake(Blocks.REDSTONE_TORCH);
	private static final Compat_Block STONE_BUTTON = Compat_Block.getFake(Blocks.STONE_BUTTON);
	private static final Compat_BlockPistonBase PISTON = new Compat_BlockPistonBase(Blocks.PISTON);
	private static final Compat_Block STONE = Compat_Block.getFake(Blocks.STONE);
	private static final Compat_BlockFire FIRE = new Compat_BlockFire(Blocks.FIRE);
	private static final Compat_Block SNOW = Compat_Block.getFake(Blocks.SNOW);
	private static final Compat_Block OAK_DOOR = Compat_Block.getFake(Blocks.OAK_DOOR);
	private static final Compat_Block IRON_DOOR = Compat_Block.getFake(Blocks.IRON_DOOR);
	private static final Compat_Block STANDING_SIGN = Compat_Block.getFake(Blocks.STANDING_SIGN);
	private static final Compat_Block WALL_SIGN = Compat_Block.getFake(Blocks.WALL_SIGN);
	private static final Compat_Block REEDS = Compat_Block.getFake(Blocks.REEDS);
	private static final Compat_Block WOODEN_PRESSURE_PLATE = Compat_Block.getFake(Blocks.WOODEN_PRESSURE_PLATE);
	private static final Compat_Block STONE_PRESSURE_PLATE = Compat_Block.getFake(Blocks.STONE_PRESSURE_PLATE);
	private static final Compat_Block DIRT = Compat_Block.getFake(Blocks.DIRT);
	private static final Compat_Block SANDSTONE = Compat_Block.getFake(Blocks.SANDSTONE);
	private static final Compat_BlockSand SAND = new Compat_BlockSand(Blocks.SAND);
	private static final Compat_Block PLANKS = Compat_Block.getFake(Blocks.PLANKS);
	private static final Compat_Block BOOKSHELF = Compat_Block.getFake(Blocks.BOOKSHELF);
	private static final Compat_BlockChest CHEST = new Compat_BlockChest(Blocks.CHEST);
	private static final Compat_Block PUMPKIN = Compat_Block.getFake(Blocks.PUMPKIN);
	private static final Compat_Block LIT_PUMPKIN = Compat_Block.getFake(Blocks.LIT_PUMPKIN);
	private static final Compat_Block WATER = Compat_Block.getFake(Blocks.WATER);
	private static final Compat_Block LAVA = Compat_Block.getFake(Blocks.LAVA);
	private static final Compat_Block FARMLAND = Compat_Block.getFake(Blocks.FARMLAND);
	private static final Compat_Block AIR = Compat_Block.getFake(Blocks.AIR);
	private static final Compat_BlockFlower RED_FLOWER = new Compat_BlockFlower(Blocks.RED_FLOWER);
	private static final Compat_BlockFlower YELLOW_FLOWER = new Compat_BlockFlower(Blocks.YELLOW_FLOWER);
	private static final Compat_BlockDeadBush DEADBUSH = new Compat_BlockDeadBush(Blocks.DEADBUSH);
	private static final Compat_Block WATERLILY = Compat_Block.getFake(Blocks.WATERLILY);
	private static final Compat_BlockBush RED_MUSHROOM = new Compat_BlockBush(Blocks.RED_MUSHROOM);
	private static final Compat_BlockBush BROWN_MUSHROOM = new Compat_BlockBush(Blocks.BROWN_MUSHROOM);
	private static final Compat_Block NETHER_BRICK = Compat_Block.getFake(Blocks.NETHER_BRICK);
	private static final Compat_Block IRON_BARS = Compat_Block.getFake(Blocks.IRON_BARS);
	private static final Compat_Block SNOW_LAYER = Compat_Block.getFake(Blocks.SNOW_LAYER);
	private static final Compat_Block STONEBRICK = Compat_Block.getFake(Blocks.STONEBRICK);
	private static final Compat_Block TORCH = Compat_Block.getFake(Blocks.TORCH);
	private static final Compat_Block SAPLING = Compat_Block.getFake(Blocks.SAPLING);
	private static final Compat_Block WEB = Compat_Block.getFake(Blocks.WEB);
	private static final Compat_Block IRON_BLOCK = Compat_Block.getFake(Blocks.IRON_BLOCK);
	private static final Compat_Block GLOWSTONE = Compat_Block.getFake(Blocks.GLOWSTONE);
	private static final Compat_Block GLASS = Compat_Block.getFake(Blocks.GLASS);
	private static final Compat_Block NETHERRACK = Compat_Block.getFake(Blocks.NETHERRACK);
	private static final Compat_Block GRAVEL = Compat_Block.getFake(Blocks.GRAVEL);
	private static final Compat_Block QUARTZ_BLOCK = Compat_Block.getFake(Blocks.QUARTZ_BLOCK);
	private static final Compat_Block LOG = Compat_Block.getFake(Blocks.LOG);
	private static final Compat_Block HAY_BLOCK = Compat_Block.getFake(Blocks.HAY_BLOCK);
	private static final Compat_Block LOG2 = Compat_Block.getFake(Blocks.LOG2);
	private static final Compat_Block FURNACE = Compat_Block.getFake(Blocks.FURNACE);
	private static final Compat_Block HEAVY_WEIGHTED_PRESSURE_PLATE = Compat_Block.getFake(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE);
	private static final Compat_Block STONE_BRICK_STAIRS = Compat_Block.getFake(Blocks.STONE_BRICK_STAIRS);
	private static final Compat_BlockDaylightDetector DAYLIGHT_DETECTOR = new Compat_BlockDaylightDetector(Blocks.DAYLIGHT_DETECTOR);
	private static final Compat_BlockStainedGlass STAINED_GLASS = new Compat_BlockStainedGlass(Blocks.STAINED_GLASS);
	private static final Compat_Block SOUL_SAND = Compat_Block.getFake(Blocks.SOUL_SAND);
	private static final Compat_Block VINE = Compat_Block.getFake(Blocks.VINE);
	private static final Compat_Block IRON_ORE = Compat_Block.getFake(Blocks.IRON_ORE);
	private static final Compat_Block GOLD_ORE = Compat_Block.getFake(Blocks.GOLD_ORE);
	private static final Compat_Block OBSIDIAN = Compat_Block.getFake(Blocks.OBSIDIAN);
	private static final Compat_Block CACTUS = Compat_Block.getFake(Blocks.CACTUS);
	private static final Compat_Block COBBLESTONE = Compat_Block.getFake(Blocks.COBBLESTONE);
	private static final Compat_Block GLASS_PANE = Compat_Block.getFake(Blocks.GLASS_PANE);
	private static final Compat_Block COAL_ORE = Compat_Block.getFake(Blocks.COAL_ORE);
	private static final Compat_BlockRedstoneWire REDSTONE_WIRE = new Compat_BlockRedstoneWire(Blocks.REDSTONE_WIRE);
	private static final Compat_Block BRICK_BLOCK = Compat_Block.getFake(Blocks.BRICK_BLOCK);
	private static final Compat_Block GOLD_BLOCK = Compat_Block.getFake(Blocks.GOLD_BLOCK);
	private static final Compat_Block MOSSY_COBBLESTONE = Compat_Block.getFake(Blocks.MOSSY_COBBLESTONE);
	private static final Compat_Block LAPIS_BLOCK = Compat_Block.getFake(Blocks.LAPIS_BLOCK);
	private static final Compat_Block END_STONE = Compat_Block.getFake(Blocks.END_STONE);
	private static final Compat_Block COAL_BLOCK = Compat_Block.getFake(Blocks.COAL_BLOCK);
	private static final Compat_Block PACKED_ICE = Compat_Block.getFake(Blocks.PACKED_ICE);
	private static final Compat_Block HARDENED_CLAY = Compat_Block.getFake(Blocks.HARDENED_CLAY);
	private static final Compat_Block STAINED_HARDENED_CLAY = Compat_Block.getFake(Blocks.STAINED_HARDENED_CLAY);
	private static final Compat_Block ICE = Compat_Block.getFake(Blocks.ICE);
	private static final Compat_Block LEVER = Compat_Block.getFake(Blocks.LEVER);
	private static final Compat_Block REDSTONE_BLOCK = Compat_Block.getFake(Blocks.REDSTONE_BLOCK);
	private static final Compat_Block CRAFTING_TABLE = Compat_Block.getFake(Blocks.CRAFTING_TABLE);
	private static final Compat_Block EMERALD_BLOCK = Compat_Block.getFake(Blocks.EMERALD_BLOCK);
	private static final Compat_Block DIAMOND_BLOCK = Compat_Block.getFake(Blocks.DIAMOND_BLOCK);
	private static final Compat_Block RED_SANDSTONE = Compat_Block.getFake(Blocks.RED_SANDSTONE);
	private static final Compat_Block PRISMARINE = Compat_Block.getFake(Blocks.PRISMARINE);
	private static final Compat_Block SEA_LANTERN = Compat_Block.getFake(Blocks.SEA_LANTERN);

	public static Compat_Block Compat_get_field_150336_V() {
		return BRICK_BLOCK;
	}

	public static Compat_Block Compat_get_field_150340_R() {
		return GOLD_BLOCK;
	}

	public static Compat_Block Compat_get_field_150341_Y() {
		return MOSSY_COBBLESTONE;
	}

	public static Compat_Block Compat_get_field_150368_y() {
		return LAPIS_BLOCK;
	}

	public static Compat_Block Compat_get_field_150377_bs() {
		return END_STONE;
	}

	public static Compat_Block Compat_get_field_150402_ci() {
		return COAL_BLOCK;
	}

	public static Compat_Block Compat_get_field_150403_cj() {
		return PACKED_ICE;
	}

	public static Compat_Block Compat_get_field_150405_ch() {
		return HARDENED_CLAY;
	}

	public static Compat_Block Compat_get_field_150406_ce() {
		return STAINED_HARDENED_CLAY;
	}

	public static Compat_Block Compat_get_field_150432_aD() {
		return ICE;
	}

	public static Compat_Block Compat_get_field_150442_at() {
		return LEVER;
	}

	public static Compat_Block Compat_get_field_150451_bX() {
		return REDSTONE_BLOCK;
	}

	public static Compat_Block Compat_get_field_150462_ai() {
		return CRAFTING_TABLE;
	}

	public static Compat_Block Compat_get_field_150475_bE() {
		return EMERALD_BLOCK;
	}

	public static Compat_Block Compat_get_field_150484_ah() {
		return DIAMOND_BLOCK;
	}

	public static Compat_Block Compat_get_field_180395_cM() {
		return RED_SANDSTONE;
	}

	public static Compat_Block Compat_get_field_180397_cI() {
		return PRISMARINE;
	}

	public static Compat_Block Compat_get_field_180398_cJ() {
		return SEA_LANTERN;
	}

	public static Compat_Block Compat_get_field_150379_bu() {
		return REDSTONE_LAMP;
	}

	public static Compat_BlockSlab Compat_get_field_150333_U() {
		return STONE_SLAB;
	}

	public static Compat_Block Compat_get_field_150325_L() {
		return WOOL;
	}

	public static Compat_Block Compat_get_field_150429_aA() {
		return REDSTONE_TORCH;
	}

	public static Compat_Block Compat_get_field_150430_aB() {
		return STONE_BUTTON;
	}

	public static Compat_BlockPistonBase Compat_get_field_150331_J() {
		return PISTON;
	}

	public static Compat_Block Compat_get_field_150348_b() {
		return STONE;
	}

	public static Compat_BlockFire Compat_get_field_150480_ab() {
		return FIRE;
	}

	public static Compat_Block Compat_get_field_150433_aE() {
		return SNOW;
	}

	public static Compat_Block Compat_get_field_150466_ao() {
		return OAK_DOOR;
	}

	public static Compat_Block Compat_get_field_150454_av() {
		return IRON_DOOR;
	}

	public static Compat_Block Compat_get_field_150472_an() {
		return STANDING_SIGN;
	}

	public static Compat_Block Compat_get_field_150444_as() {
		return WALL_SIGN;
	}

	public static Compat_Block Compat_get_field_150436_aH() {
		return REEDS;
	}

	public static Compat_Block Compat_get_field_150452_aw() {
		return WOODEN_PRESSURE_PLATE;
	}

	public static Compat_Block Compat_get_field_150456_au() {
		return STONE_PRESSURE_PLATE;
	}

	public static Compat_Block Compat_get_field_150346_d() {
		return DIRT;
	}

	public static Compat_Block Compat_get_field_150322_A() {
		return SANDSTONE;
	}

	public static Compat_BlockSand Compat_get_field_150354_m() {
		return SAND;
	}

	public static Compat_Block Compat_get_field_150344_f() {
		return PLANKS;
	}

	public static Compat_Block Compat_get_field_150342_X() {
		return BOOKSHELF;
	}

	public static Compat_BlockChest Compat_get_field_150486_ae() {
		return CHEST;
	}

	public static Compat_Block Compat_get_field_150423_aK() {
		return PUMPKIN;
	}

	public static Compat_Block Compat_get_field_150428_aP() {
		return LIT_PUMPKIN;
	}

	public static Compat_Block Compat_get_field_150355_j() {
		return WATER;
	}

	public static Compat_Block Compat_get_field_150353_l() {
		return LAVA;
	}

	public static Compat_Block Compat_get_field_150458_ak() {
		return FARMLAND;
	}

	public static Compat_Block Compat_get_field_150350_a() {
		return AIR;
	}

	public static Compat_BlockFlower Compat_get_field_150328_O() {
		return RED_FLOWER;
	}

	public static Compat_BlockFlower Compat_get_field_150327_N() {
		return YELLOW_FLOWER;
	}

	public static Compat_BlockDeadBush Compat_get_field_150330_I() {
		return DEADBUSH;
	}

	public static Compat_Block Compat_get_field_150392_bi() {
		return WATERLILY;
	}

	public static Compat_BlockBush Compat_get_field_150337_Q() {
		return RED_MUSHROOM;
	}

	public static Compat_BlockBush Compat_get_field_150338_P() {
		return BROWN_MUSHROOM;
	}

	public static Compat_Block Compat_get_field_150385_bj() {
		return NETHER_BRICK;
	}

	public static Compat_Block Compat_get_field_150411_aY() {
		return IRON_BARS;
	}

	public static Compat_Block Compat_get_field_150431_aC() {
		return SNOW_LAYER;
	}

	public static Compat_Block Compat_get_field_150417_aV() {
		return STONEBRICK;
	}

	public static Compat_Block Compat_get_field_150478_aa() {
		return TORCH;
	}

	public static Compat_Block Compat_get_field_150345_g() {
		return SAPLING;
	}

	public static Compat_Block Compat_get_field_150321_G() {
		return WEB;
	}

	public static Compat_Block Compat_get_field_150339_S() {
		return IRON_BLOCK;
	}

	public static Compat_Block Compat_get_field_150426_aN() {
		return GLOWSTONE;
	}

	public static Compat_Block Compat_get_field_150359_w() {
		return GLASS;
	}

	public static Compat_Block Compat_get_field_150424_aL() {
		return NETHERRACK;
	}

	public static Compat_Block Compat_get_field_150351_n() {
		return GRAVEL;
	}

	public static Compat_Block Compat_get_field_150371_ca() {
		return QUARTZ_BLOCK;
	}

	public static Compat_Block Compat_get_field_150364_r() {
		return LOG;
	}

	public static Compat_Block Compat_get_field_150407_cf() {
		return HAY_BLOCK;
	}

	public static Compat_Block Compat_get_field_150363_s() {
		return LOG2;
	}

	public static Compat_Block Compat_get_field_150460_al() {
		return FURNACE;
	}

	public static Compat_Block Compat_get_field_150443_bT() {
		return HEAVY_WEIGHTED_PRESSURE_PLATE;
	}

	public static Compat_Block Compat_get_field_150390_bg() {
		return STONE_BRICK_STAIRS;
	}

	public static Compat_BlockDaylightDetector Compat_get_field_150453_bW() {
		return DAYLIGHT_DETECTOR;
	}

	public static Compat_BlockStainedGlass Compat_get_field_150399_cn() {
		return STAINED_GLASS;
	}

	public static Compat_Block Compat_get_field_150425_aM() {
		return SOUL_SAND;
	}

	public static Compat_Block Compat_get_field_150395_bd() {
		return VINE;
	}

	public static Compat_Block Compat_get_field_150366_p() {
		return IRON_ORE;
	}

	public static Compat_Block Compat_get_field_150352_o() {
		return GOLD_ORE;
	}

	public static Compat_Block Compat_get_field_150343_Z() {
		return OBSIDIAN;
	}

	public static Compat_Block Compat_get_field_150434_aF() {
		return CACTUS;
	}

	public static Compat_Block Compat_get_field_150347_e() {
		return COBBLESTONE;
	}

	public static Compat_Block Compat_get_field_150410_aZ() {
		return GLASS_PANE;
	}

	public static Compat_Block Compat_get_field_150365_q() {
		return COAL_ORE;
	}

	public static Compat_BlockRedstoneWire Compat_get_field_150488_af() {
		return REDSTONE_WIRE;
	}
}
