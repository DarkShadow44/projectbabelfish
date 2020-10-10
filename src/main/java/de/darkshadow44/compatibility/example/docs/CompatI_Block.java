package de.darkshadow44.compatibility.example.docs;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public interface CompatI_Block {
	public boolean isNormalCubeSuper(IBlockState state, IBlockAccess world, BlockPos pos);
}
