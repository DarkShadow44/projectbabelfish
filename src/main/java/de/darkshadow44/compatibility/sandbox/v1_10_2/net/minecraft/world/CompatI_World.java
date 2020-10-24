package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.world;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface CompatI_World {
	public World get();

	public boolean get_isRemote();

	public IBlockState getBlockStateSuper(BlockPos pos);

	public TileEntity getTileEntitySuper(BlockPos pos);

	public boolean checkNoEntityCollisionSuper(AxisAlignedBB axis);

	public void playSoundSuper(EntityPlayer player, BlockPos pos, SoundEvent sound, SoundCategory category, float volume, float pitch);

	public boolean setBlockStateSuper(BlockPos pos, IBlockState state);

	public void setTileEntitySuper(BlockPos pos, TileEntity tile);
}
