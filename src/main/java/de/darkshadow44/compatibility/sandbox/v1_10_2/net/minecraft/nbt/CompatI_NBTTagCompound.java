package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.nbt;

import java.util.Set;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public interface CompatI_NBTTagCompound {
	public NBTTagCompound get();

	public void setIntegerSuper(String key, int value);

	public int getIntegerSuper(String key);

	public boolean getBooleanSuper(String key);

	public NBTTagList getTagListSuper(String key, int type);

	public boolean hasKeySuper(String key);

	public NBTTagCompound getCompoundTagSuper(String key);

	public Set<String> getKeySetSuper();

	public byte getByteSuper(String key);

	public NBTTagCompound copySuper();

	public String getStringSuper(String key);

	public float getFloatSuper(String key);

	public void setStringSuper(String key, String value);

	public void setFloatSuper(String key, float value);

	public void setTagSuper(String key, NBTBase value);

	public byte getIdSuper();

	public void setByteArraySuper(String key, byte[] value);

	public byte[] getByteArraySuper(String key);
}
