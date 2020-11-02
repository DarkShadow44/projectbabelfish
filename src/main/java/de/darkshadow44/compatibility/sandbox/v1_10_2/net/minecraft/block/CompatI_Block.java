package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block;

import java.util.List;

import de.darkshadow44.compatibility.autogen.Interface;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.registry.CompatI_IForgeRegistryEntry_Impl;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
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
}
