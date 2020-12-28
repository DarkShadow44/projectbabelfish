package compat.sandbox.net.minecraft.util.math;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.util.Compat_EnumFacing;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.RayTraceResult.Type;
import net.minecraft.util.math.Vec3d;

public class Compat_RayTraceResult {
	private CompatI_RayTraceResult wrapper;

	// When called from Mod
	public Compat_RayTraceResult(Compat_RayTraceResult_Type type, Compat_Vec3d vec, Compat_EnumFacing facing, Compat_BlockPos pos) {
		EnumFacing facing2 = facing == null ? null : facing.getReal();
		this.initialize(Factory.create(CtorPos.POS1, CompatI_RayTraceResult.class, this, type.getReal(), vec.getReal(), facing2, pos.getReal()));
	}

	public Compat_RayTraceResult(Compat_Vec3d vec, Compat_EnumFacing facing, Compat_BlockPos pos) {
		EnumFacing facing2 = facing == null ? null : facing.getReal();
		this.initialize(Factory.create(CtorPos.POS2, CompatI_RayTraceResult.class, this, vec.getReal(), facing2, pos.getReal()));
	}

	// When called from child
	protected Compat_RayTraceResult(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_RayTraceResult(RayTraceResult original) {
		this.initialize(Factory.createWrapper(CompatI_RayTraceResult.class, original));
	}

	protected void initialize(CompatI_RayTraceResult wrapper) {
		this.wrapper = wrapper;
	}

	public RayTraceResult getReal() {
		return wrapper.get();
	}

	public Compat_RayTraceResult_Type Compat_get_field_72313_a() {
		Type result = wrapper.get_typeOfHit();
		return Compat_RayTraceResult_Type.getFake(result);
	}

	public Compat_BlockPos Compat_func_178782_a() {
		return Compat_BlockPos.getFake(wrapper.getBlockPosSuper());
	}

	public Compat_Vec3d Compat_get_field_72307_f() {
		Vec3d result = wrapper.get_hitVec();
		return new Compat_Vec3d(result);
	}

	public Compat_EnumFacing Compat_get_field_178784_b() {
		EnumFacing result = wrapper.get_sideHit();
		return Compat_EnumFacing.getFake(result);
	}

	public void Compat_set_subHit(int value) {
		wrapper.set_subHit(value);
	}

	public void Compat_set_hitInfo(Object value) {
		wrapper.set_hitInfo(value);
	}

	public int Compat_get_subHit() {
		return wrapper.get_subHit();
	}

	public Object Compat_get_hitInfo() {
		return wrapper.get_hitInfo();
	}

	public static Compat_RayTraceResult getFake(RayTraceResult objectMouseOver) {
		if (objectMouseOver instanceof CompatI_RayTraceResult) {
			return ((CompatI_RayTraceResult) objectMouseOver).getFake();
		}
		return new Compat_RayTraceResult(objectMouseOver);
	}

	public int Compat_get_field_72310_e() {
		EnumFacing result = getReal().sideHit;
		return Compat_EnumFacing.getSideInt(result);
	}

	public int Compat_get_field_72311_b() {
		BlockPos result = wrapper.getBlockPosSuper();
		return result.getX();
	}

	public int Compat_get_field_72312_c() {
		BlockPos result = wrapper.getBlockPosSuper();
		return result.getY();
	}

	public int Compat_get_field_72309_d() {
		BlockPos result = wrapper.getBlockPosSuper();
		return result.getZ();
	}
}
