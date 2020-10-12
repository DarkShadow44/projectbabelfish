package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.BlockMycelium;

public class Compat_BlockMycelium extends Compat_Block {
	private BlockMycelium original;
	private CompatI_BlockMycelium thisReal;

	// When called from Mod
	public Compat_BlockMycelium() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockMycelium.class, this), null);
	}

	// When called from child
	protected Compat_BlockMycelium(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockMycelium(BlockMycelium original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_BlockMycelium thisReal, BlockMycelium original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public BlockMycelium getReal() {
		return original == null ? thisReal.get() : original;
	}
}
