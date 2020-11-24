package compat.sandbox.net.minecraft.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;

public interface CompatI_ItemStack {
	public ItemStack get();

	public void setTagCompoundSuper(NBTTagCompound nbt);

	public NBTTagCompound getTagCompoundSuper();

	public String getDisplayNameSuper();

	public ItemStack setStackDisplayNameSuper(String name);

	public int getItemDamageSuper();

	public boolean hasTagCompoundSuper();

	public int getCountSuper();

	public void setCountSuper(int value);

	public Item getItemSuper();

	public ItemStack copySuper();

	public int getMetadataSuper();

	public NBTTagCompound writeToNBTSuper(NBTTagCompound real);

	public Compat_ItemStack getFake();

	public boolean hasCapabilitySuper(Capability<?> capability, EnumFacing facing);

	public Object getCapabilitySuper(Capability<?> capability, EnumFacing facing);

	public void damageItemSuper(int amount, EntityLivingBase entity);

	public void setItemDamageSuper(int damage);

	public boolean isItemEqualSuper(ItemStack stack);

	public int getMaxDamageSuper();

	public int getMaxStackSizeSuper();

	public ItemStack splitStackSuper(int amount);

	public void onCraftingSuper(World world, EntityPlayer player, int amount);

	public boolean isItemStackDamageableSuper();

	public boolean hasDisplayNameSuper();
}
