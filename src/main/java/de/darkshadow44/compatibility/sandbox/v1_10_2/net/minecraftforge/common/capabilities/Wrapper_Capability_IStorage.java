package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.common.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class Wrapper_Capability_IStorage<T> implements IStorage<T> {

	@SuppressWarnings("unused")
	private final Compat_Capability_IStorage original;

	public Wrapper_Capability_IStorage(Compat_Capability_IStorage original) {
		this.original = original;
	}

	@Override
	public void readNBT(Capability<T> arg0, T arg1, EnumFacing arg2, NBTBase arg3) {
		throw new RuntimeException();
	}

	@Override
	public NBTBase writeNBT(Capability<T> arg0, T arg1, EnumFacing arg2) {
		throw new RuntimeException();
	}
}
