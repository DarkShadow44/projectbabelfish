package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.init;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.Compat_Block;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.Compat_BlockPistonBase;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.Compat_BlockSlab;
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
}
