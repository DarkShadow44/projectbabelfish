package compat.sandbox.net.minecraft.world;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.border.WorldBorder;

public interface CompatI_World {
	public World get();

	public boolean get_isRemote();

	public IBlockState getBlockStateSuper(BlockPos pos);

	public TileEntity getTileEntitySuper(BlockPos pos);

	public boolean checkNoEntityCollisionSuper(AxisAlignedBB axis);

	public void playSoundSuper(EntityPlayer player, BlockPos pos, SoundEvent sound, SoundCategory category, float volume, float pitch);

	public boolean setBlockStateSuper(BlockPos pos, IBlockState state);

	public void setTileEntitySuper(BlockPos pos, TileEntity tile);

	public void notifyNeighborsOfStateChangeSuper(BlockPos pos, Block block, boolean updateObservers);

	public boolean checkLightSuper(BlockPos pos);

	public List<EntityPlayer> get_playerEntities();

	public void notifyLightSetSuper(BlockPos pos);

	public void markBlockRangeForRenderUpdateSuper(BlockPos real, BlockPos real2);

	public WorldBorder getWorldBorderSuper();

	public long getTotalWorldTimeSuper();

	public boolean setBlockToAirSuper(BlockPos pos);
}
