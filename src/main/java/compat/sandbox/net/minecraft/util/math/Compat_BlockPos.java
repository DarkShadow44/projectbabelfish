package compat.sandbox.net.minecraft.util.math;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.util.Compat_EnumFacing;
import net.minecraft.util.math.BlockPos;

public class Compat_BlockPos extends Compat_Vec3i {
	private CompatI_BlockPos wrapper;

	// When called from Mod
	public Compat_BlockPos(int x, int y, int z) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockPos.class, this, x, y, z));
	}

	// When called from child
	protected Compat_BlockPos(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockPos(BlockPos original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockPos.class, original));
	}

	protected void initialize(CompatI_BlockPos wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public BlockPos getReal() {
		return wrapper.get();
	}

	public Compat_BlockPos Compat_func_177972_a(Compat_EnumFacing facing) {
		return new Compat_BlockPos(wrapper.offsetSuper(facing.getReal()));
	}

	public static Compat_BlockPos Compat_get_field_177992_a() {
		return new Compat_BlockPos(BlockPos.ORIGIN);
	}

	public Compat_BlockPos Compat_func_177971_a(Compat_Vec3i vec) {
		BlockPos result = wrapper.addSuper(vec.getReal());
		return new Compat_BlockPos(result);
	}

	public double Compat_func_177951_i(Compat_Vec3i vec) {
		return wrapper.distanceSqSuper(vec.getReal());
	}
}
