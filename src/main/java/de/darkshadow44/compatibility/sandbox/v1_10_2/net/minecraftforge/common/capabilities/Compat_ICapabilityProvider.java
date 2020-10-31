package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.common.capabilities;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.Compat_EnumFacing;

public interface Compat_ICapabilityProvider {
	public boolean Compat_hasCapability(Compat_Capability<?> capability, Compat_EnumFacing facing);

	public Object Compat_getCapability(Compat_Capability<?> capability, Compat_EnumFacing facing);
}
