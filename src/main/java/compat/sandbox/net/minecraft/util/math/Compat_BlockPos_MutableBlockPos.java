package compat.sandbox.net.minecraft.util.math;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.util.math.BlockPos.MutableBlockPos;

public class Compat_BlockPos_MutableBlockPos extends Compat_BlockPos {
	private CompatI_BlockPos_MutableBlockPos wrapper;

	// When called from Mod
	public Compat_BlockPos_MutableBlockPos() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockPos_MutableBlockPos.class, this));
	}

	// When called from child
	protected Compat_BlockPos_MutableBlockPos(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockPos_MutableBlockPos(MutableBlockPos original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockPos_MutableBlockPos.class, original));
	}

	protected void initialize(CompatI_BlockPos_MutableBlockPos wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public MutableBlockPos getReal() {
		return wrapper.get();
	}

	public Compat_BlockPos_MutableBlockPos Compat_func_181079_c(int p1, int p2, int p3) {
		return new Compat_BlockPos_MutableBlockPos(wrapper.setPosSuper(p1, p2, p3));
	}
}
