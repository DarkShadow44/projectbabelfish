package compat.sandbox.net.minecraftforge.common.capabilities;

import compat.sandbox.net.minecraft.nbt.Compat_NBTBase;
import compat.sandbox.net.minecraft.nbt.Compat_NBTTagCompound;
import compat.sandbox.net.minecraft.util.Compat_EnumFacing;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class Wrapper_Capability_IStorage<T> implements IStorage<T> {

	private final Compat_Capability_IStorage<T> original;

	public Wrapper_Capability_IStorage(Compat_Capability_IStorage<T> original) {
		this.original = original;
	}

	@Override
	public void readNBT(Capability<T> capability, T value, EnumFacing facing, NBTBase tag) {
		original.Compat_readNBT(Compat_Capability.getFake(capability), value, Compat_EnumFacing.getFake(facing), new Compat_NBTTagCompound((NBTTagCompound) tag));
	}

	@Override
	public NBTBase writeNBT(Capability<T> capability, T value, EnumFacing facing) {
		Compat_NBTBase tag = original.Compat_writeNBT(Compat_Capability.getFake(capability), value, Compat_EnumFacing.getFake(facing));
		return ((Compat_NBTTagCompound) tag).getReal();
	}
}
