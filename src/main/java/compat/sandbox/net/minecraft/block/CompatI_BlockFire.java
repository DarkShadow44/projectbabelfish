package compat.sandbox.net.minecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFire;

public interface CompatI_BlockFire extends CompatI_Block {
	public BlockFire get();

	public void setFireInfoSuper(Block block, int encouragement, int flammability);
}
