package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.item;

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
}
