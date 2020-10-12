package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.BlockVine;

public class Compat_BlockVine extends Compat_Block {
	private BlockVine original;
	private CompatI_BlockVine thisReal;

	// When called from Mod
	public Compat_BlockVine() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, this), null);
	}

	// When called from child
	protected Compat_BlockVine(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockVine(BlockVine original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_BlockVine thisReal, BlockVine original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public BlockVine getReal() {
		return original == null ? thisReal.get() : original;
	}
}
