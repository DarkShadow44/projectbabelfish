package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.BlockFire;

public class Compat_BlockFire extends Compat_Block {
	private BlockFire original;
	private CompatI_BlockFire thisReal;

	// When called from Mod
	public Compat_BlockFire() {
		super(ParentSelector.NULL);
		this.initialize(new CompatReal_BlockFire(this), null);
	}

	// When called from child
	protected Compat_BlockFire(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockFire(BlockFire original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_BlockFire thisReal, BlockFire original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public BlockFire getReal() {
		return original == null ? thisReal.get() : original;
	}

	public void Compat_setFireInfo(Compat_Block block, int encouragement, int flammability) {
		if (original == null)
			thisReal.setFireInfoSuper(block.getReal(), encouragement, flammability);
		else
			original.setFireInfo(block.getReal(), encouragement, flammability);
	}
}
