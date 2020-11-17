package compat.sandbox.net.minecraftforge.fml.common.network;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;

public class Compat_NetworkRegistry_TargetPoint {
	private CompatI_NetworkRegistry_TargetPoint wrapper;

	// When called from Mod
	public Compat_NetworkRegistry_TargetPoint(int dimension, double x, double y, double z, double range) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_NetworkRegistry_TargetPoint.class, this, dimension, x, y, z, range));
	}

	// When called from child
	protected Compat_NetworkRegistry_TargetPoint(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_NetworkRegistry_TargetPoint(TargetPoint original) {
		this.initialize(Factory.createWrapper(CompatI_NetworkRegistry_TargetPoint.class, original));
	}

	protected void initialize(CompatI_NetworkRegistry_TargetPoint wrapper) {
		this.wrapper = wrapper;
	}

	public TargetPoint getReal() {
		return wrapper.get();
	}
}
