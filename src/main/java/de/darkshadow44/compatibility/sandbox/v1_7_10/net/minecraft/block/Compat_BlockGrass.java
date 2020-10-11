package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.BlockGrass;

public class Compat_BlockGrass extends Compat_Block {
	private BlockGrass original;
	private CompatI_BlockGrass thisReal;

	// When called from Mod
	public Compat_BlockGrass() {
		super(ParentSelector.NULL);
		this.initialize(new CompatReal_BlockGrass(this), null);
	}

	// When called from child
	protected Compat_BlockGrass(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockGrass(BlockGrass original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_BlockGrass thisReal, BlockGrass original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public BlockGrass getReal() {
		return original == null ? thisReal.get() : original;
	}
}
