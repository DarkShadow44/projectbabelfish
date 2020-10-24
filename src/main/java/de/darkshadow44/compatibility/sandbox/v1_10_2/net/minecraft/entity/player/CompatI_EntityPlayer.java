package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity.player;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity.CompatI_EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

public interface CompatI_EntityPlayer extends CompatI_EntityLivingBase {
	public EntityPlayer get();

	public boolean canPlayerEditSuper(BlockPos pos, EnumFacing facing, ItemStack stack);
}
