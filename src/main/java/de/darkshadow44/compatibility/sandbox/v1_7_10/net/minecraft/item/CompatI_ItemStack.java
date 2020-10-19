package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public interface CompatI_ItemStack {
	public ItemStack get();

	public ItemStack copySuper();

	public boolean hasTagCompoundSuper();

	public int getItemDamageSuper();

	public NBTTagCompound getTagCompoundSuper();
}
