package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.math;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.util.math.AxisAlignedBB;

public class Compat_AxisAlignedBB {
	private AxisAlignedBB original;
	private CompatI_AxisAlignedBB thisReal;

	// When called from Mod
	public Compat_AxisAlignedBB(double p1, double p2, double p3, double p4, double p5, double p6) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_AxisAlignedBB.class, this, p1, p2, p3, p4, p5, p6), null);
	}

	// When called from child
	protected Compat_AxisAlignedBB(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_AxisAlignedBB(AxisAlignedBB original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_AxisAlignedBB thisReal, AxisAlignedBB original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public AxisAlignedBB getReal() {
		return original == null ? thisReal.get() : original;
	}

	public double Compat_get_field_72340_a() {
		if (original == null)
			return thisReal.get_minX();
		else
			return original.minX;
	}

	public double Compat_get_field_72338_b() {
		if (original == null)
			return thisReal.get_minY();
		else
			return original.minY;
	}

	public double Compat_get_field_72339_c() {
		if (original == null)
			return thisReal.get_minZ();
		else
			return original.minZ;
	}

	public double Compat_get_field_72336_d() {
		if (original == null)
			return thisReal.get_maxX();
		else
			return original.maxX;
	}

	public double Compat_get_field_72337_e() {
		if (original == null)
			return thisReal.get_maxY();
		else
			return original.maxY;
	}

	public double Compat_get_field_72334_f() {
		if (original == null)
			return thisReal.get_maxZ();
		else
			return original.maxZ;
	}

	public boolean Compat_func_72326_a(Compat_AxisAlignedBB other) {
		if (original == null)
			return thisReal.intersectsSuper(other.getReal());
		else
			return original.intersects(other.getReal());
	}

	public Compat_AxisAlignedBB Compat_func_72317_d(double x, double y, double z) {
		AxisAlignedBB axis;
		if (original == null)
			axis = thisReal.offsetSuper(x, y, z);
		else
			axis = original.offset(x, y, z);
		return new Compat_AxisAlignedBB(axis);
	}

	public Compat_AxisAlignedBB Compat_func_186662_g(double p1) {
		AxisAlignedBB axis;
		if (original == null)
			axis = thisReal.growSuper(p1);
		else
			axis = original.grow(p1);
		return new Compat_AxisAlignedBB(axis);
	}

	public Compat_AxisAlignedBB Compat_func_111270_a(Compat_AxisAlignedBB bb) {
		AxisAlignedBB axis;
		if (original == null)
			axis = thisReal.unionSuper(bb.getReal());
		else
			axis = original.union(bb.getReal());
		return new Compat_AxisAlignedBB(axis);
	}
}
