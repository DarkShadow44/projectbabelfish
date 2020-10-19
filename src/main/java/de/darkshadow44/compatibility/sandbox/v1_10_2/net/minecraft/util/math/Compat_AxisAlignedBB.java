package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.math;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.util.math.AxisAlignedBB;

public class Compat_AxisAlignedBB {
	private AxisAlignedBB original;
	private CompatI_AxisAlignedBB thisReal;

	// When called from Mod
	public Compat_AxisAlignedBB() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_AxisAlignedBB.class, this), null);
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
}
