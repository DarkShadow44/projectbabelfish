package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.math;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.util.math.Vec3i;

public class Compat_Vec3i implements Comparable<Compat_Vec3i> {
	private CompatI_Vec3i wrapper;

	// When called from Mod
	public Compat_Vec3i() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Vec3i.class, this));
	}

	// When called from child
	protected Compat_Vec3i(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Vec3i(Vec3i original) {
		this.initialize(Factory.createWrapper(CompatI_Vec3i.class, original));
	}

	protected void initialize(CompatI_Vec3i wrapper) {
		this.wrapper = wrapper;
	}

	public Vec3i getReal() {
		return wrapper.get();
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Compat_Vec3i) {
			other = ((Compat_Vec3i) other).getReal();
		}
		return wrapper.equalsSuper(other);
	}

	@Override
	public int hashCode() {
		return wrapper.hashCodeSuper();
	}

	@Override
	public int compareTo(Compat_Vec3i other) {
		return wrapper.compareToSuper(other.getReal());
	}

	public int Compat_func_177958_n() {
		return wrapper.getXSuper();
	}

	public int Compat_func_177956_o() {
		return wrapper.getYSuper();
	}

	public int Compat_func_177952_p() {
		return wrapper.getZSuper();
	}
}
