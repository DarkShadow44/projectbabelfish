package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.common.capabilities;

import net.minecraftforge.common.capabilities.Capability;

public interface CompatI_Capability<T> {
	public Capability<T> get();

	public Compat_Capability<T> getFake();
}
