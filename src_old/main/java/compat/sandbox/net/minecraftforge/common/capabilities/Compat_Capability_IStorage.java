package compat.sandbox.net.minecraftforge.common.capabilities;

import compat.sandbox.net.minecraft.nbt.Compat_NBTBase;
import compat.sandbox.net.minecraft.util.Compat_EnumFacing;

public interface Compat_Capability_IStorage<T> {

	public void Compat_readNBT(Compat_Capability<T> capability, T value, Compat_EnumFacing facing, Compat_NBTBase tag);

	public Compat_NBTBase Compat_writeNBT(Compat_Capability<T> capability, T value, Compat_EnumFacing facing);
}
