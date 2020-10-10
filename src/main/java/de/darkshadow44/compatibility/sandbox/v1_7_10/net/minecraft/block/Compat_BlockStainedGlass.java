package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block.material.Compat_Material;
import net.minecraft.block.BlockStainedGlass;

public class Compat_BlockStainedGlass extends Compat_Block {
	private BlockStainedGlass original;
	private CompatI_BlockStainedGlass thisReal;

	// When called from Mod
	public Compat_BlockStainedGlass(Compat_Material material) {
		super(ParentSelector.NULL);
		super.initialize(new CompatReal_BlockStainedGlass(this, material.getReal()), null);
	}

	// When called from child
	protected Compat_BlockStainedGlass(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockStainedGlass(BlockStainedGlass original) {
		super(ParentSelector.NULL);
		super.initialize(null, original);
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
