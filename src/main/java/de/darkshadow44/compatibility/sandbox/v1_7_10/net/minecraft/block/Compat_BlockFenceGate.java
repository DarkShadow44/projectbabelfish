package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockPlanks.EnumType;

public class Compat_BlockFenceGate extends Compat_Block {
	private BlockFenceGate original;
	private CompatI_BlockFenceGate thisReal;

	// When called from Mod
	public Compat_BlockFenceGate() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockFenceGate.class, this, EnumType.BIRCH), null); // TODO
	}

	// When called from child
	protected Compat_BlockFenceGate(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockFenceGate(BlockFenceGate original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_BlockFenceGate thisReal, BlockFenceGate original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public BlockFenceGate getReal() {
		return original == null ? thisReal.get() : original;
	}
}
