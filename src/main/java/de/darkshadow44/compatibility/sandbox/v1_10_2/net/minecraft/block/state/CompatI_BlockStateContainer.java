package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.state;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;

public interface CompatI_BlockStateContainer {
	public BlockStateContainer get();

	public ImmutableList<IBlockState> getValidStatesSuper();
}
