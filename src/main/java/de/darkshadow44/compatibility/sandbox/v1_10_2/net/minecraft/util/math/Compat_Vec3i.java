package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.math;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.util.math.Vec3i;

public class Compat_Vec3i implements Comparable<Compat_Vec3i> {
	private Vec3i original;
	private CompatI_Vec3i thisReal;

	// When called from Mod
	public Compat_Vec3i() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Vec3i.class, this), null);
	}

	// When called from child
	protected Compat_Vec3i(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Vec3i(Vec3i original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_Vec3i thisReal, Vec3i original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public Vec3i getReal() {
		return original == null ? thisReal.get() : original;
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Compat_Vec3i) {
			other = ((Compat_Vec3i) other).getReal();
		}
		if (original == null)
			return thisReal.equalsSuper(other);
		else
			return original.equals(other);
	}

	@Override
	public int hashCode() {
		if (original == null)
			return thisReal.hashCodeSuper();
		else
			return original.hashCode();
	}

	@Override
	public int compareTo(Compat_Vec3i other) {
		if (original == null)
			return thisReal.compareToSuper(other.getReal());
		else
			return original.compareTo(other.getReal());
	}

	public int Compat_func_177958_n() {
		if (original == null)
			return thisReal.getXSuper();
		else
			return original.getX();
	}

	public int Compat_func_177956_o() {
		if (original == null)
			return thisReal.getYSuper();
		else
			return original.getY();
	}

	public int Compat_func_177952_p() {
		if (original == null)
			return thisReal.getZSuper();
		else
			return original.getZ();
	}
}
