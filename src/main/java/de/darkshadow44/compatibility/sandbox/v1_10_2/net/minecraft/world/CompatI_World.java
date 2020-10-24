package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.world;

import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface CompatI_World {
	public World get();

	public boolean get_isRemote();

	public IBlockState getBlockStateSuper(BlockPos pos);

	public TileEntity getTileEntitySuper(BlockPos pos);
}
