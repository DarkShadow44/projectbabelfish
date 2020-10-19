package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;

public interface CompatI_Block {
	public Block get();

	public IBlockState getDefaultStateSuper();
}
