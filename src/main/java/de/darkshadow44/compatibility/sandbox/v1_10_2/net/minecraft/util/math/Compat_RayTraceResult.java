package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.math;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.Compat_EnumFacing;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.RayTraceResult.Type;
import net.minecraft.util.math.Vec3d;

public class Compat_RayTraceResult {
	private RayTraceResult original;
	private CompatI_RayTraceResult thisReal;

	// When called from Mod
	public Compat_RayTraceResult(Compat_RayTraceResult_Type type, Compat_Vec3d vec, Compat_EnumFacing facing, Compat_BlockPos pos) {
		EnumFacing facing2 = facing == null ? null : facing.getReal();
		this.initialize(Factory.create(CtorPos.POS1, CompatI_RayTraceResult.class, this, type.getReal(), vec.getReal(), facing2, pos.getReal()), null);
	}

	public Compat_RayTraceResult(Compat_Vec3d vec, Compat_EnumFacing facing, Compat_BlockPos pos) {
		EnumFacing facing2 = facing == null ? null : facing.getReal();
		this.initialize(Factory.create(CtorPos.POS2, CompatI_RayTraceResult.class, this, vec.getReal(), facing2, pos.getReal()), null);
	}

	// When called from child
	protected Compat_RayTraceResult(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_RayTraceResult(RayTraceResult original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_RayTraceResult thisReal, RayTraceResult original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public RayTraceResult getReal() {
		return original == null ? thisReal.get() : original;
	}

	public Compat_RayTraceResult_Type Compat_get_field_72313_a() {
		Type type;
		if (original == null)
			type = thisReal.get_typeOfHit();
		else
			type = original.typeOfHit;
		return Compat_RayTraceResult_Type.getFake(type);
	}

	public Compat_BlockPos Compat_func_178782_a() {
		if (original == null)
			return new Compat_BlockPos(thisReal.getBlockPosSuper());
		else
			return new Compat_BlockPos(original.getBlockPos());
	}

	public Compat_Vec3d Compat_get_field_72307_f() {
		Vec3d result;
		if (original == null)
			result = thisReal.get_hitVec();
		else
			result = original.hitVec;
		return new Compat_Vec3d(result);
	}

	public Compat_EnumFacing Compat_get_field_178784_b() {
		EnumFacing result;
		if (original == null)
			result = thisReal.get_sideHit();
		else
			result = original.sideHit;
		return Compat_EnumFacing.map_real_to_fake(result);
	}

	public void Compat_set_subHit(int value) {
		if (original == null)
			thisReal.set_subHit(value);
		else
			original.subHit = value;
	}

	public void Compat_set_hitInfo(Object value) {
		if (original == null)
			thisReal.set_hitInfo(value);
		else
			original.hitInfo = value;
	}

	public int Compat_get_subHit() {
		if (original == null)
			return thisReal.get_subHit();
		else
			return original.subHit;
	}

	public Object Compat_get_hitInfo() {
		if (original == null)
			return thisReal.get_hitInfo();
		else
			return original.hitInfo;
	}
}
