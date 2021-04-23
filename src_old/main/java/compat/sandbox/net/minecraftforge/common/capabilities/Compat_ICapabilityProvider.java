package compat.sandbox.net.minecraftforge.common.capabilities;

import compat.sandbox.net.minecraft.util.Compat_EnumFacing;

public interface Compat_ICapabilityProvider {
	public boolean Compat_hasCapability(Compat_Capability<?> capability, Compat_EnumFacing facing);

	public Object Compat_getCapability(Compat_Capability<?> capability, Compat_EnumFacing facing);
}
