package compat.sandbox.net.minecraft.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

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
}
