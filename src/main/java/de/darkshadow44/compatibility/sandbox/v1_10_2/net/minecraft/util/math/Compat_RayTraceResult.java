package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.math;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.RayTraceResult.Type;

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
}
