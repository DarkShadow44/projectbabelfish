package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.math;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.util.math.RayTraceResult;

public class Compat_RayTraceResult {
	private RayTraceResult original;
	private CompatI_RayTraceResult thisReal;

	// When called from Mod
	public Compat_RayTraceResult() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_RayTraceResult.class, this), null);
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
}
