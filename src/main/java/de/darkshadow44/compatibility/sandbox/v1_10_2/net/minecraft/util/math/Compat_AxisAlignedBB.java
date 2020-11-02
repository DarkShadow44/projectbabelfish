package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.math;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceResult;

public class Compat_AxisAlignedBB {
	private CompatI_AxisAlignedBB wrapper;

	// When called from Mod
	public Compat_AxisAlignedBB(double p1, double p2, double p3, double p4, double p5, double p6) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_AxisAlignedBB.class, this, p1, p2, p3, p4, p5, p6));
	}

	// When called from child
	protected Compat_AxisAlignedBB(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_AxisAlignedBB(AxisAlignedBB original) {
		this.initialize(Factory.createWrapper(CompatI_AxisAlignedBB.class, original));
	}

	protected void initialize(CompatI_AxisAlignedBB wrapper) {
		this.wrapper = wrapper;
	}

	public AxisAlignedBB getReal() {
		return wrapper.get();
	}

	public double Compat_get_field_72340_a() {
		return wrapper.get_minX();
	}

	public double Compat_get_field_72338_b() {
		return wrapper.get_minY();
	}

	public double Compat_get_field_72339_c() {
		return wrapper.get_minZ();
	}

	public double Compat_get_field_72336_d() {
		return wrapper.get_maxX();
	}

	public double Compat_get_field_72337_e() {
		return wrapper.get_maxY();
	}

	public double Compat_get_field_72334_f() {
		return wrapper.get_maxZ();
	}

	public boolean Compat_func_72326_a(Compat_AxisAlignedBB other) {
		return wrapper.intersectsSuper(other.getReal());
	}

	public Compat_AxisAlignedBB Compat_func_72317_d(double x, double y, double z) {
		AxisAlignedBB result = wrapper.offsetSuper(x, y, z);
		return new Compat_AxisAlignedBB(result);
	}

	public Compat_AxisAlignedBB Compat_func_186662_g(double p1) {
		AxisAlignedBB result = wrapper.growSuper(p1);
		return new Compat_AxisAlignedBB(result);
	}

	public Compat_AxisAlignedBB Compat_func_111270_a(Compat_AxisAlignedBB bb) {
		AxisAlignedBB result = wrapper.unionSuper(bb.getReal());
		return new Compat_AxisAlignedBB(result);
	}

	public Compat_AxisAlignedBB Compat_func_186670_a(Compat_BlockPos pos) {
		AxisAlignedBB result = wrapper.offsetSuper(pos.getReal());
		return new Compat_AxisAlignedBB(result);
	}

	public Compat_RayTraceResult Compat_func_72327_a(Compat_Vec3d start, Compat_Vec3d end) {
		RayTraceResult result = wrapper.calculateInterceptSuper(start.getReal(), end.getReal());
		return result == null ? null : new Compat_RayTraceResult(result);
	}

}
