package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.Block;

public class Compat_Block {
	private Block original;
	private CompatI_Block thisReal;

	// When called from Mod
	public Compat_Block() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Block.class, this), null);
	}

	// When called from child
	protected Compat_Block(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Block(Block original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_Block thisReal, Block original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public Block getReal() {
		return original == null ? thisReal.get() : original;
	}
}
