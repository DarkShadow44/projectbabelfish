package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.nbt;

import net.minecraft.nbt.NBTTagCompound;

public class CompatReal_NBTTagCompound extends NBTTagCompound implements CompatI_NBTTagCompound {
	@SuppressWarnings("unused")
	private Compat_NBTTagCompound thisFake;

	public CompatReal_NBTTagCompound(Compat_NBTTagCompound thisFake) {
		super();
		this.thisFake = thisFake;
	}

	@Override
	public NBTTagCompound get() {
		return this;
	}
}
