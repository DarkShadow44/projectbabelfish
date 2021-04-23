package compat.sandbox.net.minecraft.nbt;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public abstract class Compat_NBTBase {
	public abstract NBTBase getReal();

	public abstract Compat_NBTBase Compat_func_74737_b();

	public static Compat_NBTBase getFake(NBTBase tag) {
		if (tag instanceof NBTTagCompound) {
			return new Compat_NBTTagCompound((NBTTagCompound) tag);
		}
		if (tag instanceof NBTTagList) {
			return new Compat_NBTTagList((NBTTagList) tag);
		}
		throw new RuntimeException("Unhandled " + tag.getClass().getName());
	}
}
