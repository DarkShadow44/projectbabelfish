package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFire;

public interface CompatI_BlockFire extends CompatI_Block {
	public BlockFire get();

	public void setFireInfoSuper(Block block, int encouragement, int flammability);
}
