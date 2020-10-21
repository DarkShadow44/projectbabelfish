package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.math;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.util.math.Vec3d;

public class Compat_Vec3d {
	private Vec3d original;
	private CompatI_Vec3d thisReal;

	// When called from Mod
	public Compat_Vec3d(double p1, double p2, double p3) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Vec3d.class, this, p1, p2, p3), null);
	}

	// When called from child
	protected Compat_Vec3d(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Vec3d(Vec3d original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_Vec3d thisReal, Vec3d original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public Vec3d getReal() {
		return original == null ? thisReal.get() : original;
	}

	public double Compat_get_field_72450_a() {
		if (original == null)
			return thisReal.get_x();
		else
			return original.x;
	}

	public double Compat_get_field_72448_b() {
		if (original == null)
			return thisReal.get_y();
		else
			return original.y;
	}

	public double Compat_get_field_72449_c() {
		if (original == null)
			return thisReal.get_z();
		else
			return original.z;
	}
}
