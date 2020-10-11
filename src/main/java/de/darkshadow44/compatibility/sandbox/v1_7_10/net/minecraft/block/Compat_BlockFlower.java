package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.BlockFlower;

public class Compat_BlockFlower extends Compat_Block {
	private BlockFlower original;
	private CompatI_BlockFlower thisReal;

	// When called from child
	protected Compat_BlockFlower(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockFlower(BlockFlower original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_BlockFlower thisReal, BlockFlower original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public BlockFlower getReal() {
		return original == null ? thisReal.get() : original;
	}
}
