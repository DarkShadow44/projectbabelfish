package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.nbt;

import net.minecraft.nbt.NBTTagCompound;

public interface CompatI_NBTTagCompound {
	public NBTTagCompound get();

	public void setIntegerSuper(String key, int value);
}
