package compat.sandbox.net.minecraft.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface CompatI_ItemBlock extends CompatI_Item {
	public ItemBlock get();

	public boolean placeBlockAtSuper(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing facing, float x, float y, float z, IBlockState state);
}
