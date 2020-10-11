package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block.material.Compat_Material;
import net.minecraft.block.Block;

public class Compat_BlockLeavesBase extends Compat_Block {
	private Block original;
	private CompatI_BlockLeavesBase thisReal;

	// When called from Mod
	public Compat_BlockLeavesBase(Compat_Material material, boolean p1) { // TODO
		super(ParentSelector.NULL);
		this.initialize(new CompatReal_BlockLeavesBase(this, material.getReal()), null);
	}

	// When called from child
	protected Compat_BlockLeavesBase(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockLeavesBase(Block original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_BlockLeavesBase thisReal, Block original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public Block getReal() {
		return original == null ? thisReal.get() : original;
	}
}
