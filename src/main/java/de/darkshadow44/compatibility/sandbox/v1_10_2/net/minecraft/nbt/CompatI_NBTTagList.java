package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.nbt;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public interface CompatI_NBTTagList {
	public NBTTagList get();

	public NBTTagCompound getCompoundTagAtSuper(int index);

	public void appendTagSuper(NBTBase tag);

	public int tagCountSuper();
}
