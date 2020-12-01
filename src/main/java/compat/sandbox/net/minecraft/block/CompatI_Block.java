package compat.sandbox.net.minecraft.block;

import java.util.List;
import java.util.Random;

import compat.autogen.Interface;
import compat.sandbox.net.minecraftforge.fml.common.registry.CompatI_IForgeRegistryEntry_Impl;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

@Interface(ITileEntityProvider.class)
public interface CompatI_Block extends CompatI_IForgeRegistryEntry_Impl<Block> {
	public Block get();

	public boolean isChild();

	public IBlockState getDefaultStateSuper();

	public BlockStateContainer createBlockStateSuper();

	public void setDefaultStateSuper(IBlockState baseState);

	public void set_fullBlock(boolean fullBlock);

	public Block setHardnessSuper(float hardness);

	public Block setUnlocalizedNameSuper(String name);

	public Block setCreativeTabSuper(CreativeTabs tab);

	public int getMetaFromStateSuper(IBlockState state);

	public boolean isReplaceableSuper(IBlockAccess world, BlockPos pos);

	public boolean isFullBlockSuper(IBlockState state);

	public boolean isFullCubeSuper(IBlockState state);

	public boolean isOpaqueCubeSuper(IBlockState state);

	public boolean isBlockNormalCubeSuper(IBlockState state);

	public EnumBlockRenderType getRenderTypeSuper(IBlockState real);

	public IBlockState getExtendedStateSuper(IBlockState state, IBlockAccess world, BlockPos pos);

	public RayTraceResult collisionRayTraceSuper(IBlockState state, World world, BlockPos pos, Vec3d start, Vec3d end);

	public AxisAlignedBB getSelectedBoundingBoxSuper(IBlockState state, World world, BlockPos pos);

	public void addCollisionBoxToListSuper(IBlockState state, World world, BlockPos pos, AxisAlignedBB bbEntity, List<AxisAlignedBB> boxes, Entity entity, boolean b);

	public boolean canRenderInLayerSuper(IBlockState state, BlockRenderLayer layer);

	public Block setTickRandomlySuper(boolean shouldTick);

	public Block setSoundTypeSuper(SoundType sound);

	public Block disableStatsSuper();

	public Block setLightOpacitySuper(int opacity);

	public Block setBlockUnbreakableSuper();

	public Block setResistanceSuper(float resistance);

	public Block setLightLevelSuper(float value);

	public void setDefaultSlipperinessSuper(float value);

	public Material getMaterialSuper(IBlockState state);

	public SoundType getSoundTypeSuper();

	public String getUnlocalizedNameSuper();

	public void onBlockClickedSuper(World world, BlockPos pos, EntityPlayer player);

	public boolean onBlockActivatedSuper(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float x, float y, float z);

	public Compat_Block getFake();

	public boolean addDestroyEffectsSuper(World world, BlockPos pos, ParticleManager manager);

	public boolean addHitEffectsSuper(IBlockState state, World world, RayTraceResult target, ParticleManager manager);

	public boolean addLandingEffectsSuper(IBlockState state, WorldServer world, BlockPos pos, IBlockState state2, EntityLivingBase entity, int p1);

	public boolean canConnectRedstoneSuper(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing facing);

	public boolean canPlaceTorchOnTopSuper(IBlockState state, IBlockAccess world, BlockPos pos);

	public boolean canProvidePowerSuper(IBlockState state);

	public void onEntityWalkSuper(World world, BlockPos pos, Entity entity);

	public IBlockState getStateFromMetaSuper(int meta);

	public int getStrongPowerSuper(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing facing);

	public void onEntityCollidedWithBlockSuper(World world, BlockPos pos, IBlockState state, Entity entity);

	public float getPlayerRelativeBlockHardnessSuper(IBlockState state, EntityPlayer entity, World world, BlockPos pos);

	public void randomDisplayTickSuper(IBlockState state, World world, BlockPos pos, Random random);

	public int getWeakPowerSuper(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing facing);

	public void harvestBlockSuper(World world, EntityPlayer player, BlockPos pos, IBlockState state, TileEntity tile, ItemStack stack);

	public List<ItemStack> getDropsSuper(IBlockAccess world, BlockPos pos, IBlockState state, int fortune);

	public void neighborChangedSuper(IBlockState state, World world, BlockPos pos, Block block, BlockPos posNeighbor);

	public int getHarvestLevelSuper(IBlockState state);

	public String getHarvestToolSuper(IBlockState state);

	public int getLightValueSuper(IBlockState state, IBlockAccess world, BlockPos pos);

	public ItemStack getPickBlockSuper(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player);

	public boolean getWeakChangesSuper(IBlockAccess world, BlockPos pos);

	public Boolean isAABBInsideMaterialSuper(World world, BlockPos pos, AxisAlignedBB bb, Material material);

	public Boolean isEntityInsideMaterialSuper(IBlockAccess world, BlockPos pos, IBlockState state, Entity entity, double d, Material material, boolean b);

	public boolean isSideSolidSuper(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing facing);

	public boolean isToolEffectiveSuper(String type, IBlockState state);

	public void onNeighborChangeSuper(IBlockAccess world, BlockPos pos, BlockPos posNeightbor);

	public boolean removedByPlayerSuper(IBlockState state, World world, BlockPos pos, EntityPlayer player, boolean b);

	public IBlockState getStateForPlacementSuper(World world, BlockPos pos, EnumFacing facing, float x, float y, float z, int meta, EntityLivingBase entity);

	public void updateTickSuper(World world, BlockPos pos, IBlockState state, Random random);
}
