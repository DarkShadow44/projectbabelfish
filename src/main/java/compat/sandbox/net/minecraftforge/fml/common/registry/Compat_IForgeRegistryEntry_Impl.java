package compat.sandbox.net.minecraftforge.fml.common.registry;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.CompatibilityMod;
import compat.core.ParentSelector;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.IForgeRegistryEntry.Impl;

public class Compat_IForgeRegistryEntry_Impl<T extends IForgeRegistryEntry<T>> implements Compat_IForgeRegistryEntry<T> {
	private CompatI_IForgeRegistryEntry_Impl<T> wrapper;

	// When called from Mod
	public Compat_IForgeRegistryEntry_Impl() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_IForgeRegistryEntry_Impl.class, this));
	}

	// When called from child
	protected Compat_IForgeRegistryEntry_Impl(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_IForgeRegistryEntry_Impl(Impl<T> original) {
		this.initialize(Factory.createWrapper(CompatI_IForgeRegistryEntry_Impl.class, original));
	}

	protected void initialize(CompatI_IForgeRegistryEntry_Impl<T> wrapper) {
		this.wrapper = wrapper;
	}

	public Impl<T> getReal() {
		return wrapper.get();
	}

	public Compat_IForgeRegistryEntry<T> Compat_setRegistryName(String name) {
		wrapper.setRegistryNameSuper(CompatibilityMod.CURRENT_LAYER.getCurrentModId(), name);
		return this;
	}
}
