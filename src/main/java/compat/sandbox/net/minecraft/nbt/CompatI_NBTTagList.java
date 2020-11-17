package compat.sandbox.net.minecraft.nbt;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public interface CompatI_NBTTagList {
	public NBTTagList get();

	public NBTTagCompound getCompoundTagAtSuper(int index);

	public void appendTagSuper(NBTBase tag);

	public int tagCountSuper();

	public Compat_NBTTagList getFake();

	public NBTTagList copySuper();
}
