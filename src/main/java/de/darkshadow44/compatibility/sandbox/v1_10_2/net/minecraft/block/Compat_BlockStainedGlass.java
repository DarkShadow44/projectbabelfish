package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.BlockStainedGlass;

public class Compat_BlockStainedGlass extends Compat_BlockBreakable {
	private BlockStainedGlass original;
	private CompatI_BlockStainedGlass thisReal;

	// When called from Mod
	public Compat_BlockStainedGlass() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockStainedGlass.class, this), null);
	}

	// When called from child
	protected Compat_BlockStainedGlass(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockStainedGlass(BlockStainedGlass original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_BlockStainedGlass thisReal, BlockStainedGlass original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public BlockStainedGlass getReal() {
		return original == null ? thisReal.get() : original;
	}
}
