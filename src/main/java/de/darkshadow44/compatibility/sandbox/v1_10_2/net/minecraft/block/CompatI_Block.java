package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block;

import de.darkshadow44.compatibility.autogen.Interface;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.registry.CompatI_IForgeRegistryEntry_Impl;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

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
}
