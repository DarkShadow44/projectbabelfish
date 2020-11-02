package compat.sandbox.net.minecraft.init;

import compat.sandbox.net.minecraft.block.Compat_Block;
import compat.sandbox.net.minecraft.block.Compat_BlockBush;
import compat.sandbox.net.minecraft.block.Compat_BlockChest;
import compat.sandbox.net.minecraft.block.Compat_BlockDaylightDetector;
import compat.sandbox.net.minecraft.block.Compat_BlockDeadBush;
import compat.sandbox.net.minecraft.block.Compat_BlockFire;
import compat.sandbox.net.minecraft.block.Compat_BlockFlower;
import compat.sandbox.net.minecraft.block.Compat_BlockPistonBase;
import compat.sandbox.net.minecraft.block.Compat_BlockSand;
import compat.sandbox.net.minecraft.block.Compat_BlockSlab;
import compat.sandbox.net.minecraft.block.Compat_BlockStainedGlass;
import net.minecraft.init.Blocks;

public class Compat_Blocks {

	private static final Compat_Block REDSTONE_LAMP = new Compat_Block(Blocks.REDSTONE_LAMP);
	private static final Compat_BlockSlab STONE_SLAB = new Compat_BlockSlab(Blocks.STONE_SLAB);
	private static final Compat_Block WOOL = new Compat_Block(Blocks.WOOL);
	private static final Compat_Block REDSTONE_TORCH = new Compat_Block(Blocks.REDSTONE_TORCH);
	private static final Compat_Block STONE_BUTTON = new Compat_Block(Blocks.STONE_BUTTON);
	private static final Compat_BlockPistonBase PISTON = new Compat_BlockPistonBase(Blocks.PISTON);
	private static final Compat_Block STONE = new Compat_Block(Blocks.STONE);

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
	
	// TODO!
	public static Compat_BlockFire Compat_get_field_150480_ab() {
		return new Compat_BlockFire(Blocks.FIRE);
	}

	public static Compat_Block Compat_get_field_150433_aE() {
		return new Compat_Block(Blocks.SNOW);
	}

	public static Compat_Block Compat_get_field_150466_ao() {
		return new Compat_Block(Blocks.OAK_DOOR);
	}

	public static Compat_Block Compat_get_field_150454_av() {
		return new Compat_Block(Blocks.IRON_DOOR);
	}

	public static Compat_Block Compat_get_field_150472_an() {
		return new Compat_Block(Blocks.STANDING_SIGN);
	}

	public static Compat_Block Compat_get_field_150444_as() {
		return new Compat_Block(Blocks.WALL_SIGN);
	}

	public static Compat_Block Compat_get_field_150436_aH() {
		return new Compat_Block(Blocks.REEDS);
	}

	public static Compat_Block Compat_get_field_150452_aw() {
		return new Compat_Block(Blocks.WOODEN_PRESSURE_PLATE);
	}

	public static Compat_Block Compat_get_field_150456_au() {
		return new Compat_Block(Blocks.STONE_PRESSURE_PLATE);
	}

	public static Compat_Block Compat_get_field_150346_d() {
		return new Compat_Block(Blocks.DIRT);
	}

	public static Compat_Block Compat_get_field_150322_A() {
		return new Compat_Block(Blocks.SANDSTONE);
	}

	public static Compat_BlockSand Compat_get_field_150354_m() {
		return new Compat_BlockSand(Blocks.SAND);
	}

	public static Compat_Block Compat_get_field_150344_f() {
		return new Compat_Block(Blocks.PLANKS);
	}

	public static Compat_Block Compat_get_field_150342_X() {
		return new Compat_Block(Blocks.BOOKSHELF);
	}

	public static Compat_BlockChest Compat_get_field_150486_ae() {
		return new Compat_BlockChest(Blocks.CHEST);
	}

	public static Compat_Block Compat_get_field_150423_aK() {
		return new Compat_Block(Blocks.PUMPKIN);
	}

	public static Compat_Block Compat_get_field_150428_aP() {
		return new Compat_Block(Blocks.LIT_PUMPKIN);
	}

	public static Compat_Block Compat_get_field_150355_j() {
		return new Compat_Block(Blocks.WATER);
	}

	public static Compat_Block Compat_get_field_150353_l() {
		return new Compat_Block(Blocks.LAVA);
	}

	public static Compat_Block Compat_get_field_150458_ak() {
		return new Compat_Block(Blocks.FARMLAND);
	}

	public static Compat_Block Compat_get_field_150350_a() {
		return new Compat_Block(Blocks.AIR);
	}

	public static Compat_BlockFlower Compat_get_field_150328_O() {
		return new Compat_BlockFlower(Blocks.RED_FLOWER);
	}

	public static Compat_BlockFlower Compat_get_field_150327_N() {
		return new Compat_BlockFlower(Blocks.YELLOW_FLOWER);
	}

	public static Compat_BlockDeadBush Compat_get_field_150330_I() {
		return new Compat_BlockDeadBush(Blocks.DEADBUSH);
	}

	public static Compat_Block Compat_get_field_150392_bi() {
		return new Compat_Block(Blocks.WATERLILY);
	}

	public static Compat_BlockBush Compat_get_field_150337_Q() {
		return new Compat_BlockBush(Blocks.RED_MUSHROOM);
	}

	public static Compat_BlockBush Compat_get_field_150338_P() {
		return new Compat_BlockBush(Blocks.BROWN_MUSHROOM);
	}

	public static Compat_Block Compat_get_field_150385_bj() {
		return new Compat_Block(Blocks.NETHER_BRICK);
	}

	public static Compat_Block Compat_get_field_150411_aY() {
		return new Compat_Block(Blocks.IRON_BARS);
	}

	public static Compat_Block Compat_get_field_150431_aC() {
		return new Compat_Block(Blocks.SNOW_LAYER);
	}

	public static Compat_Block Compat_get_field_150417_aV() {
		return new Compat_Block(Blocks.STONEBRICK);
	}

	public static Compat_Block Compat_get_field_150478_aa() {
		return new Compat_Block(Blocks.TORCH);
	}

	public static Compat_Block Compat_get_field_150345_g() {
		return new Compat_Block(Blocks.SAPLING);
	}

	public static Compat_Block Compat_get_field_150321_G() {
		return new Compat_Block(Blocks.WEB);
	}

	public static Compat_Block Compat_get_field_150339_S() {
		return new Compat_Block(Blocks.IRON_BLOCK);
	}

	public static Compat_Block Compat_get_field_150426_aN() {
		return new Compat_Block(Blocks.GLOWSTONE);
	}

	public static Compat_Block Compat_get_field_150359_w() {
		return new Compat_Block(Blocks.GLASS);
	}

	public static Compat_Block Compat_get_field_150424_aL() {
		return new Compat_Block(Blocks.NETHERRACK);
	}

	public static Compat_Block Compat_get_field_150351_n() {
		return new Compat_Block(Blocks.GRAVEL);
	}

	public static Compat_Block Compat_get_field_150371_ca() {
		return new Compat_Block(Blocks.QUARTZ_BLOCK);
	}

	public static Compat_Block Compat_get_field_150364_r() {
		return new Compat_Block(Blocks.LOG);
	}

	public static Compat_Block Compat_get_field_150407_cf() {
		return new Compat_Block(Blocks.HAY_BLOCK);
	}

	public static Compat_Block Compat_get_field_150363_s() {
		return new Compat_Block(Blocks.LOG2);
	}

	public static Compat_Block Compat_get_field_150460_al() {
		return new Compat_Block(Blocks.FURNACE);
	}

	public static Compat_Block Compat_get_field_150443_bT() {
		return new Compat_Block(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE);
	}

	public static Compat_Block Compat_get_field_150390_bg() {
		return new Compat_Block(Blocks.STONE_BRICK_STAIRS);
	}

	public static Compat_BlockDaylightDetector Compat_get_field_150453_bW() {
		return new Compat_BlockDaylightDetector(Blocks.DAYLIGHT_DETECTOR);
	}

	public static Compat_BlockStainedGlass Compat_get_field_150399_cn() {
		return new Compat_BlockStainedGlass(Blocks.STAINED_GLASS);
	}

	public static Compat_Block Compat_get_field_150425_aM() {
		return new Compat_Block(Blocks.SOUL_SAND);
	}

	public static Compat_Block Compat_get_field_150395_bd() {
		return new Compat_Block(Blocks.VINE);
	}

	public static Compat_Block Compat_get_field_150366_p() {
		return new Compat_Block(Blocks.IRON_ORE);
	}

	public static Compat_Block Compat_get_field_150352_o() {
		return new Compat_Block(Blocks.GOLD_ORE);
	}

	public static Compat_Block Compat_get_field_150343_Z() {
		return new Compat_Block(Blocks.OBSIDIAN);
	}

	public static Compat_Block Compat_get_field_150434_aF() {
		return new Compat_Block(Blocks.CACTUS);
	}

	public static Compat_Block Compat_get_field_150347_e() {
		return new Compat_Block(Blocks.COBBLESTONE);
	}

	public static Compat_Block Compat_get_field_150410_aZ() {
		return new Compat_Block(Blocks.GLASS_PANE);
	}

	public static Compat_Block Compat_get_field_150365_q() {
		return new Compat_Block(Blocks.COAL_ORE);
	}
}
