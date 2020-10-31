package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.common.capabilities;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.nbt.Compat_NBTBase;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.Compat_EnumFacing;

public interface Compat_Capability_IStorage<T> {

	public void Compat_readNBT(Compat_Capability<T> capability, T value, Compat_EnumFacing facing, Compat_NBTBase tag);

	public Compat_NBTBase Compat_writeNBT(Compat_Capability<T> capability, T value, Compat_EnumFacing facing);
}
