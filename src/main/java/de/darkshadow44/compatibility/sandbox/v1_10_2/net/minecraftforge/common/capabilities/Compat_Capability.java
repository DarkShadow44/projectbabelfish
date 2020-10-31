package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.common.capabilities;

import java.util.concurrent.Callable;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraftforge.common.capabilities.Capability;

public class Compat_Capability<T> {
	private Capability<T> original;
	private CompatI_Capability<T> thisReal;

	// When called from Mod
	public Compat_Capability(String name, Compat_Capability_IStorage<T> storage, Callable<? extends T> factory) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Capability.class, this, name, new Wrapper_Capability_IStorage<>(storage), factory), null);
	}

	// When called from child
	protected Compat_Capability(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Capability(Capability<T> original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_Capability<T> thisReal, Capability<T> original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public Capability<?> getReal() {
		return original == null ? thisReal.get() : original;
	}

	@SuppressWarnings("unchecked")
	public static <T> Compat_Capability<T> getFake(Capability<T> real) {
		if (real instanceof CompatI_Capability) {
			return ((CompatI_Capability<T>) real).getFake();
		}
		return new Compat_Capability<T>(real);

	}
}
