package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.common.capabilities;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.nbt.Compat_NBTBase;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.nbt.Compat_NBTTagCompound;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.Compat_EnumFacing;
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
		original.Compat_readNBT(Compat_Capability.getFake(capability), value, Compat_EnumFacing.map_real_to_fake(facing), new Compat_NBTTagCompound((NBTTagCompound) tag));
	}

	@Override
	public NBTBase writeNBT(Capability<T> capability, T value, EnumFacing facing) {
		Compat_NBTBase tag = original.Compat_writeNBT(Compat_Capability.getFake(capability), value, Compat_EnumFacing.map_real_to_fake(facing));
		return ((Compat_NBTTagCompound) tag).getReal();
	}
}
