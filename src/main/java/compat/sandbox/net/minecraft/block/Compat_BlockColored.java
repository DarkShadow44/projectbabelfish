package compat.sandbox.net.minecraft.block;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.block.BlockColored;

public class Compat_BlockColored extends Compat_Block {
	private CompatI_BlockColored wrapper;

	// When called from Mod
	public Compat_BlockColored() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockColored.class, this));
	}

	// When called from child
	protected Compat_BlockColored(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockColored(BlockColored original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockColored.class, original));
	}

	protected void initialize(CompatI_BlockColored wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public BlockColored getReal() {
		return wrapper.get();
	}

	public static int Compat_func_150032_b(int p1) {
		return Compat_func_150031_c(p1);
	}

	public static int Compat_func_150031_c(int p1) {
		return ~p1 & 15;
	}
}
