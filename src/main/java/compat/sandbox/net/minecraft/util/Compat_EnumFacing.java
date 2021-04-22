package compat.sandbox.net.minecraft.util;

import compat.sandbox.net.minecraftforge.common.util.Compat_ForgeDirection;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;

public enum Compat_EnumFacing implements IStringSerializable {

	UP(EnumFacing.UP),
	DOWN(EnumFacing.DOWN),
	EAST(EnumFacing.EAST),
	WEST(EnumFacing.WEST),
	SOUTH(EnumFacing.SOUTH),
	NORTH(EnumFacing.NORTH);

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

	public static Compat_EnumFacing getFake(EnumFacing real) {
		if (real == null) {
			return null;
		}
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
		return getFake(EnumFacing.byIndex(index));
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

	public int Compat_func_82601_c() {
		return original.getXOffset();
	}

	public int Compat_func_96559_d() {
		return original.getYOffset();
	}

	public int Compat_func_82599_e() {
		return original.getZOffset();
	}

	public Compat_EnumFacing Compat_func_176734_d() {
		return getFake(original.getOpposite());
	}

	public Compat_EnumFacing_Axis Compat_func_176740_k() {
		return Compat_EnumFacing_Axis.getFake(original.getAxis());
	}

	public int Compat_func_176736_b() {
		return original.getHorizontalIndex();
	}

	public static Compat_EnumFacing Compat_func_176737_a(float x, float y, float z) {
		return getFake(EnumFacing.getFacingFromVector(x, y, z));
	}

	public static EnumFacing getReal(Compat_EnumFacing facing) {
		return facing == null ? null : facing.getReal();
	}

	public static Compat_EnumFacing getFromSideInt(int side) {
		switch (side) { // TODO Correct?
		case 0:
			return Compat_EnumFacing.DOWN;
		case 1:
			return Compat_EnumFacing.UP;
		case 2:
			return Compat_EnumFacing.NORTH;
		case 3:
			return Compat_EnumFacing.SOUTH;
		case 4:
			return Compat_EnumFacing.WEST;
		case 5:
			return Compat_EnumFacing.EAST;
		default:
			throw new RuntimeException("Unexpected " + side);
		}
	}

	public static int getSideInt(EnumFacing side) {
		switch (side) { // TODO Correct?
		case DOWN:
			return 0;
		case UP:
			return 1;
		case NORTH:
			return 2;
		case SOUTH:
			return 3;
		case WEST:
			return 4;
		case EAST:
			return 5;
		default:
			throw new RuntimeException("Unexpected " + side.ordinal());
		}
	}

	EnumFacing getFromDirection(Compat_ForgeDirection direction) {
		// TODO Auto-generated method stub
		return null;
	}
}
