package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util;

import net.minecraft.util.EnumFacing;

public enum Compat_EnumFacing {

	UP(EnumFacing.UP), DOWN(EnumFacing.DOWN), EAST(EnumFacing.EAST), WEST(EnumFacing.WEST), SOUTH(EnumFacing.SOUTH), NORTH(EnumFacing.NORTH);

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
}
