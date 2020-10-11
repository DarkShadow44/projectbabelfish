package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block.material.Compat_Material;
import net.minecraft.block.BlockBreakable;

public class Compat_BlockBreakable extends Compat_Block {
	private BlockBreakable original;
	private CompatI_BlockBreakable thisReal;

	// When called from Mod
	public Compat_BlockBreakable(String p0, Compat_Material material, boolean p1) { // TODO
		super(ParentSelector.NULL);
		this.initialize(new CompatReal_BlockBreakable(this, material.getReal(), p1), null);
	}

	// When called from child
	protected Compat_BlockBreakable(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockBreakable(BlockBreakable original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_BlockBreakable thisReal, BlockBreakable original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public BlockBreakable getReal() {
		return original == null ? thisReal.get() : original;
	}
}
