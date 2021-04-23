package compat.sandbox.net.minecraft.entity.player;

import compat.sandbox.net.minecraft.entity.CompatI_EntityLivingBase;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.stats.StatBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.IInteractionObject;

public interface CompatI_EntityPlayer extends CompatI_EntityLivingBase {
	public EntityPlayer get();

	public boolean canPlayerEditSuper(BlockPos pos, EnumFacing facing, ItemStack stack);

	public boolean isCreativeSuper();

	public float getEyeHeightSuper();

	public PlayerCapabilities get_capabilities();

	public void sendMessageSuper(ITextComponent text);

	public void displayGuiSuper(IInteractionObject obj);

	public MinecraftServer getServerSuper();

	public ItemStack getHeldItemSuper(EnumHand hand);

	public ItemStack getActiveItemStackSuper();

	public void setHeldItemSuper(EnumHand hand, ItemStack stack);

	public double getDistanceSqSuper(double x, double y, double z);

	public void addStatSuper(StatBase stat);

	public float getDigSpeedSuper(IBlockState state, BlockPos pos);

	public void swingArmSuper(EnumHand hand);

	public InventoryPlayer get_inventory();

	public float get_rotationYaw();
}
