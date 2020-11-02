package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.BlockLilyPad;

public class Compat_BlockLilyPad extends Compat_Block {
	private CompatI_BlockLilyPad wrapper;

	// When called from Mod
	public Compat_BlockLilyPad() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockLilyPad.class, this));
	}

	// When called from child
	protected Compat_BlockLilyPad(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockLilyPad(BlockLilyPad original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockLilyPad.class, original));
	}

	protected void initialize(CompatI_BlockLilyPad wrapper) {
		this.wrapper = wrapper;
	}

	public BlockLilyPad getReal() {
		return wrapper.get();
	}
}
