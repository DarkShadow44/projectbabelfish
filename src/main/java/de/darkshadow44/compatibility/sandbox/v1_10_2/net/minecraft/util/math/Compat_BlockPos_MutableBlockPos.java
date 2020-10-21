package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.math;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.util.math.BlockPos.MutableBlockPos;

public class Compat_BlockPos_MutableBlockPos extends Compat_BlockPos {
	private MutableBlockPos original;
	private CompatI_BlockPos_MutableBlockPos thisReal;

	// When called from Mod
	public Compat_BlockPos_MutableBlockPos() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockPos_MutableBlockPos.class, this), null);
	}

	// When called from child
	protected Compat_BlockPos_MutableBlockPos(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockPos_MutableBlockPos(MutableBlockPos original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_BlockPos_MutableBlockPos thisReal, MutableBlockPos original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public MutableBlockPos getReal() {
		return original == null ? thisReal.get() : original;
	}
}
