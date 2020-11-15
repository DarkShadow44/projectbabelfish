package compat.sandbox.net.minecraft.item;

import java.util.Set;

import compat.sandbox.net.minecraftforge.fml.common.registry.CompatI_IForgeRegistryEntry_Impl;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface CompatI_Item extends CompatI_IForgeRegistryEntry_Impl<Item> {
	public Item get();

	public Item setUnlocalizedNameSuper(String name);

	public Item setMaxStackSizeSuper(int size);

	public Item setMaxDamageSuper(int damage);

	public Item setCreativeTabSuper(CreativeTabs tab);

	public String getUnlocalizedNameSuper(ItemStack stack);

	public void getSubItemsSuper(CreativeTabs real, NonNullList<ItemStack> list);

	public void onUpdateSuper(ItemStack itme, World world, Entity entity, int itemSlot, boolean isSelected);

	public boolean canItemEditBlocksSuper();

	public EnumActionResult onItemUseSuper(EntityPlayer player, World world, BlockPos block, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ);

	public Compat_Item getFake();

	public Item setHasSubtypesSuper(boolean hasSubtypes);

	public Item setNoRepairSuper();

	public Item setFull3DSuper();

	public Item setContainerItemSuper(Item containerItem);

	public String getItemStackDisplayNameSuper(ItemStack stack);

	public String getUnlocalizedNameSuper();

	public int getMetadataSuper(int damage);

	public ActionResult<ItemStack> onItemRightClickSuper(World world, EntityPlayer player, EnumHand hand);

	public int getHarvestLevelSuper(ItemStack stack, String toolClass, EntityPlayer player, IBlockState state);

	public NBTTagCompound getNBTShareTagSuper(ItemStack stack);

	public Set<String> getToolClassesSuper(ItemStack stack);
}
