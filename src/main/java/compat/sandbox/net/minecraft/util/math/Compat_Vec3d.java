package compat.sandbox.net.minecraft.util.math;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.util.math.Vec3d;

public class Compat_Vec3d {
	private CompatI_Vec3d wrapper;

	// When called from Mod
	public Compat_Vec3d(Compat_Vec3i vec) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Vec3d.class, this, vec.getReal()));
	}

	// When called from Mod
	public Compat_Vec3d(double p1, double p2, double p3) {
		this.initialize(Factory.create(CtorPos.POS2, CompatI_Vec3d.class, this, p1, p2, p3));
	}

	// When called from child
	protected Compat_Vec3d(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Vec3d(Vec3d original) {
		this.initialize(Factory.createWrapper(CompatI_Vec3d.class, original));
	}

	protected void initialize(CompatI_Vec3d wrapper) {
		this.wrapper = wrapper;
	}

	public Vec3d getReal() {
		return wrapper.get();
	}

	public double Compat_get_field_72450_a() {
		return wrapper.get_x();
	}

	public double Compat_get_field_72448_b() {
		return wrapper.get_y();
	}

	public double Compat_get_field_72449_c() {
		return wrapper.get_z();
	}

	public Compat_Vec3d Compat_func_72441_c(double x, double y, double z) {
		return new Compat_Vec3d(wrapper.addVectorSuper(x, y, z));
	}

	public double Compat_func_72436_e(Compat_Vec3d vec) {
		return wrapper.squareDistanceToSuper(vec.getReal());
	}

	public Compat_Vec3d Compat_func_178786_a(double x, double y, double z) {
		return new Compat_Vec3d(wrapper.subtractSuper(x, y, z));
	}

	public Compat_Vec3d Compat_func_178787_e(Compat_Vec3d other) {
		return new Compat_Vec3d(wrapper.addSuper(other.getReal()));
	}

	public Compat_Vec3d Compat_func_178788_d(Compat_Vec3d vec) {
		return new Compat_Vec3d(wrapper.subtractSuper(vec.getReal()));
	}

	public Compat_Vec3d Compat_func_186678_a(double factor) {
		return new Compat_Vec3d(wrapper.scaleSuper(factor));
	}
}
