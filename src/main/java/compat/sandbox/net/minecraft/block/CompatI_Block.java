package compat.sandbox.net.minecraft.block;

import java.util.List;

import compat.autogen.Interface;
import compat.sandbox.net.minecraftforge.fml.common.registry.CompatI_IForgeRegistryEntry_Impl;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
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

@Interface(ITileEntityProvider.class)
public interface CompatI_Block extends CompatI_IForgeRegistryEntry_Impl<Block> {
	public Block get();

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
}
