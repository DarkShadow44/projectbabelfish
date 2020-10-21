package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;

public interface CompatI_Block {
	public Block get();

	public IBlockState getDefaultStateSuper();

	public BlockStateContainer createBlockStateSuper();

	public void setDefaultStateSuper(IBlockState baseState);

	public void set_fullBlock(boolean fullBlock);

	public Block setHardnessSuper(float hardness);

	public Block setUnlocalizedNameSuper(String name);
}
