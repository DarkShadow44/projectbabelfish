package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.math;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.Compat_EnumFacing;
import net.minecraft.util.math.BlockPos;

public class Compat_BlockPos extends Compat_Vec3i {
	private BlockPos original;
	private CompatI_BlockPos thisReal;

	// When called from Mod
	public Compat_BlockPos(int x, int y, int z) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockPos.class, this, x, y, z), null);
	}

	// When called from child
	protected Compat_BlockPos(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockPos(BlockPos original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_BlockPos thisReal, BlockPos original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public BlockPos getReal() {
		return original == null ? thisReal.get() : original;
	}

	public Compat_BlockPos Compat_func_177972_a(Compat_EnumFacing facing) {
		if (original == null)
			return new Compat_BlockPos(thisReal.offsetSuper(facing.getReal()));
		else
			return new Compat_BlockPos(original.offset(facing.getReal()));
	}

	public static Compat_BlockPos Compat_get_field_177992_a() {
		return new Compat_BlockPos(BlockPos.ORIGIN);
	}

	public Compat_BlockPos Compat_func_177971_a(Compat_Vec3i vec) {
		BlockPos result;
		if (original == null)
			result = thisReal.addSuper(vec.getReal());
		else
			result = original.add(vec.getReal());
		return new Compat_BlockPos(result);
	}

	public double Compat_func_177951_i(Compat_Vec3i vec) {
		if (original == null)
			return thisReal.distanceSqSuper(vec.getReal());
		else
			return original.distanceSq(vec.getReal());
	}
}
