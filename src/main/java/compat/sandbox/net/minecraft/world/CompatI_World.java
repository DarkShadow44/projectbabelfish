package compat.sandbox.net.minecraft.world;

import java.util.List;
import java.util.Random;

import com.google.common.base.Predicate;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
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

	public void markBlockRangeForRenderUpdateSuper(BlockPos start, BlockPos end);

	public WorldBorder getWorldBorderSuper();

	public long getTotalWorldTimeSuper();

	public boolean setBlockToAirSuper(BlockPos pos);

	public void markChunkDirtySuper(BlockPos pos, TileEntity tile);

	public <T extends Entity> List<T> getEntitiesWithinAABBSuper(Class<? extends T> classEntity, AxisAlignedBB bb, Predicate<? super T> filter);

	public int getRedstonePowerSuper(BlockPos pos, EnumFacing facing);

	public void updateComparatorOutputLevelSuper(BlockPos pos, Block block);

	public void spawnParticleSuper(EnumParticleTypes type, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, int... parameters);

	public void notifyNeighborsOfStateExceptSuper(BlockPos pos, Block block, EnumFacing facing);

	public void removeTileEntitySuper(BlockPos pos);

	public boolean mayPlaceSuper(Block block, BlockPos pos, boolean skipCollisionCheck, EnumFacing facing, Entity entity);

	public void neighborChangedSuper(BlockPos pos, Block block, BlockPos pos2);

	public void scheduleBlockUpdateSuper(BlockPos pos, Block block, int delay, int priority);

	public boolean setBlockStateSuper(BlockPos pos, IBlockState state, int flags);

	public void notifyBlockUpdateSuper(BlockPos pos, IBlockState stateOld, IBlockState stateNew, int flags);

	public boolean spawnEntitySuper(Entity entity);

	public RayTraceResult rayTraceBlocksSuper(Vec3d start, Vec3d end);

	public GameRules getGameRulesSuper();

	public boolean isSideSolidSuper(BlockPos pos, EnumFacing facing);

	public boolean get_restoringBlockSnapshots();

	public Random get_rand();

	public WorldProvider get_provider();

	public void markBlockRangeForRenderUpdateSuper(int x1, int y1, int z1, int x2, int y2, int z2);

	public boolean isAirBlockSuper(BlockPos pos);

	public int getHeightSuper();

	public Biome getBiomeSuper(BlockPos pos);

	public boolean isSideSolidSuper(BlockPos pos, EnumFacing side, boolean p1);

	public void scheduleUpdateSuper(BlockPos pos, Block block, int delay);

	public void playEventSuper(EntityPlayer player, int type, BlockPos pos, int data);

	public void playSoundSuper(double x, double y, double z, SoundEvent event, SoundCategory category, float volume, float pitch, boolean b);

	public int getActualHeightSuper();

	public BiomeProvider getBiomeProviderSuper();
}
