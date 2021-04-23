package compat.sandbox.net.minecraft.block;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.block.BlockCauldron;

public class Compat_BlockCauldron extends Compat_Block {
	private CompatI_BlockCauldron wrapper;

	// When called from Mod
	public Compat_BlockCauldron() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockCauldron.class, this));
	}

	// When called from child
	protected Compat_BlockCauldron(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockCauldron(BlockCauldron original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockCauldron.class, original));
	}

	protected void initialize(CompatI_BlockCauldron wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public BlockCauldron getReal() {
		return wrapper.get();
	}

	public static int Compat_func_150027_b(int p1) {
		return p1;
	}
}
