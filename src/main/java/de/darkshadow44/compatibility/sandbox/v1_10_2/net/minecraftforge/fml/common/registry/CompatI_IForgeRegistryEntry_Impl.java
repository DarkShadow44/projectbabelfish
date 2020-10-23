package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.registry;

import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.IForgeRegistryEntry.Impl;

public interface CompatI_IForgeRegistryEntry_Impl<T extends IForgeRegistryEntry<T>> {
	public Impl<T> get();

	public IForgeRegistryEntry<?> setRegistryNameSuper(String name);

	public IForgeRegistryEntry<?>  setRegistryNameSuper(String currentModId, String name);
}
