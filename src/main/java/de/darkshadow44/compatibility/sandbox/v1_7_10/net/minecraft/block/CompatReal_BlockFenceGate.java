package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockPlanks;

public class CompatReal_BlockFenceGate extends BlockFenceGate implements CompatI_BlockFenceGate {
	@SuppressWarnings("unused")
	private Compat_BlockFenceGate thisFake;

	public CompatReal_BlockFenceGate(Compat_BlockFenceGate thisFake, BlockPlanks.EnumType type) {
		super(type);
		this.thisFake = thisFake;
	}

	@Override
	public BlockFenceGate get() {
		return this;
	}
}
