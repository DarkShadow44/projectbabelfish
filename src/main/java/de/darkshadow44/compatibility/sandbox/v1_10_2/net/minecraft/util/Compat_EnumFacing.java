package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;

public enum Compat_EnumFacing implements IStringSerializable {

	UP(EnumFacing.UP), DOWN(EnumFacing.DOWN), EAST(EnumFacing.EAST), WEST(EnumFacing.WEST), SOUTH(EnumFacing.SOUTH), NORTH(EnumFacing.NORTH);

	static Compat_EnumFacing[] VALUES = new Compat_EnumFacing[6];

	static {
		VALUES[0] = DOWN;
		VALUES[1] = UP;
		VALUES[2] = NORTH;
		VALUES[3] = SOUTH;
		VALUES[4] = WEST;
		VALUES[5] = EAST;
	}

	private EnumFacing original;

	private Compat_EnumFacing(EnumFacing original) {
		this.original = original;
	}

	public EnumFacing getReal() {
		return original;
	}

	public static Compat_EnumFacing Compat_get_EAST() {
		return EAST;
	}

	public static Compat_EnumFacing Compat_get_DOWN() {
		return DOWN;
	}

	public static Compat_EnumFacing Compat_get_UP() {
		return UP;
	}

	public static Compat_EnumFacing Compat_get_NORTH() {
		return NORTH;
	}

	public static Compat_EnumFacing Compat_get_WEST() {
		return WEST;
	}

	public static Compat_EnumFacing Compat_get_SOUTH() {
		return SOUTH;
	}

	private static Compat_EnumFacing map_real_to_fake(EnumFacing real) {
		switch (real) {
		case DOWN:
			return DOWN;
		case EAST:
			return EAST;
		case NORTH:
			return NORTH;
		case SOUTH:
			return SOUTH;
		case UP:
			return UP;
		case WEST:
			return WEST;
		}
		return null;
	}

	public static Compat_EnumFacing Compat_func_82600_a(int index) {
		return map_real_to_fake(EnumFacing.getFront(index));
	}

	@Override
	public String getName() {
		return original.getName();
	}

	public static Compat_EnumFacing[] Compat_get_field_82609_l() {
		return VALUES;
	}

	public int Compat_ordinal() {
		return original.ordinal();
	}
}
