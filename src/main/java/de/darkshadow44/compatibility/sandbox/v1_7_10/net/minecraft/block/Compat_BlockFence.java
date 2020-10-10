package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block.material.Compat_Material;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.MapColor;

public class Compat_BlockFence extends Compat_Block {
	private BlockFence original;
	private CompatI_BlockFence thisReal;

	// When called from Mod
	public Compat_BlockFence(Compat_Material material) {
		super(ParentSelector.NULL);
		super.initialize(new CompatReal_BlockFence(this, material.getReal(), MapColor.AIR), null); // TODO
	}

	// When called from child
	protected Compat_BlockFence(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockFence(BlockFence original) {
		super(ParentSelector.NULL);
		super.initialize(null, original);
	}

	protected void initialize(CompatI_BlockFence thisReal, BlockFence original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public BlockFence getReal() {
		return original == null ? thisReal.get() : original;
	}
}
