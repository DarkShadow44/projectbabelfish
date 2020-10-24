package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.math;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.Compat_EnumFacing;
import net.minecraft.util.math.BlockPos;

public class Compat_BlockPos extends Compat_Vec3i {
	private BlockPos original;
	private CompatI_BlockPos thisReal;

	// When called from Mod
	public Compat_BlockPos() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockPos.class, this), null);
	}

	// When called from child
	protected Compat_BlockPos(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockPos(BlockPos original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_BlockPos thisReal, BlockPos original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public BlockPos getReal() {
		return original == null ? thisReal.get() : original;
	}

	public Compat_BlockPos Compat_func_177972_a(Compat_EnumFacing facing) {
		if (original == null)
			return new Compat_BlockPos(thisReal.offsetSuper(facing.getReal()));
		else
			return new Compat_BlockPos(original.offset(facing.getReal()));
	}
}
