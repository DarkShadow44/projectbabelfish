package compat.sandbox.net.minecraftforge.common.capabilities;

import net.minecraftforge.common.capabilities.Capability;

public interface CompatI_Capability<T> {
	public Capability<T> get();

	public Compat_Capability<T> getFake();
}
