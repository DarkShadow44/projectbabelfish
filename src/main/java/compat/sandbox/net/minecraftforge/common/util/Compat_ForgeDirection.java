package compat.sandbox.net.minecraftforge.common.util;

import net.minecraft.util.EnumFacing;

public enum Compat_ForgeDirection {

	UP(),
	DOWN(),
	EAST(),
	NORTH(),
	WEST(),
	SOUTH();

	public static Compat_ForgeDirection Compat_get_UP() {
		return UP;
	}

	public static Compat_ForgeDirection Compat_get_DOWN() {
		return DOWN;
	}

	public static Compat_ForgeDirection Compat_get_EAST() {
		return EAST;
	}

	public static Compat_ForgeDirection Compat_get_NORTH() {
		return NORTH;
	}

	public static Compat_ForgeDirection Compat_get_WEST() {
		return WEST;
	}

	public static Compat_ForgeDirection Compat_get_SOUTH() {
		return SOUTH;
	}

	public static EnumFacing getReal(Compat_ForgeDirection fake) {
		if (fake == null)
			return null;

		switch (fake) {
		case UP:
			return EnumFacing.UP;
		case DOWN:
			return EnumFacing.DOWN;
		case EAST:
			return EnumFacing.EAST;
		case NORTH:
			return EnumFacing.NORTH;
		case WEST:
			return EnumFacing.WEST;
		case SOUTH:
			return EnumFacing.SOUTH;
		default:
			throw new RuntimeException("Unhandled " + fake.name());
		}
	}

	public Compat_ForgeDirection Compat_getOpposite() {
		switch (this) {
		case UP:
			return DOWN;
		case DOWN:
			return UP;
		case EAST:
			return WEST;
		case NORTH:
			return SOUTH;
		case WEST:
			return EAST;
		case SOUTH:
			return NORTH;
		default:
			throw new RuntimeException("Unhandled " + this.name());
		}
	}
}
