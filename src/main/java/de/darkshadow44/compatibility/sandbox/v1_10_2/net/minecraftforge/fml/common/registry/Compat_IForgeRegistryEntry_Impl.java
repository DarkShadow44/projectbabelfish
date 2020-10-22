package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.registry;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.IForgeRegistryEntry.Impl;

public class Compat_IForgeRegistryEntry_Impl<T extends IForgeRegistryEntry<T>> implements Compat_IForgeRegistryEntry<T> {
	private Impl<T> original;
	private CompatI_IForgeRegistryEntry_Impl<T> thisReal;

	// When called from Mod
	public Compat_IForgeRegistryEntry_Impl() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_IForgeRegistryEntry_Impl.class, this), null);
	}

	// When called from child
	protected Compat_IForgeRegistryEntry_Impl(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_IForgeRegistryEntry_Impl(Impl<T> original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_IForgeRegistryEntry_Impl<T> thisReal, Impl<T> original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public Impl<T> getReal() {
		return original == null ? thisReal.get() : original;
	}

	public Compat_IForgeRegistryEntry<T> Compat_setRegistryName(String name) {
		if (this.original == null)
			thisReal.setRegistryNameSuper(name);
		else
			this.original.setRegistryName(name);
		return this;
	}
}
