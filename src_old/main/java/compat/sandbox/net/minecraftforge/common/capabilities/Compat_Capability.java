package compat.sandbox.net.minecraftforge.common.capabilities;

import java.util.concurrent.Callable;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraftforge.common.capabilities.Capability;

public class Compat_Capability<T> {
	private CompatI_Capability<T> wrapper;

	// When called from Mod
	public Compat_Capability(String name, Compat_Capability_IStorage<T> storage, Callable<? extends T> factory) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Capability.class, this, name, new Wrapper_Capability_IStorage<>(storage), factory));
	}

	// When called from child
	protected Compat_Capability(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Capability(Capability<T> original) {
		this.initialize(Factory.createWrapper(CompatI_Capability.class, original));
	}

	protected void initialize(CompatI_Capability<T> wrapper) {
		this.wrapper = wrapper;
	}

	public Capability<?> getReal() {
		return wrapper.get();
	}

	@SuppressWarnings("unchecked")
	public static <T> Compat_Capability<T> getFake(Capability<T> real) {
		if (real instanceof CompatI_Capability) {
			return ((CompatI_Capability<T>) real).getFake();
		}
		return new Compat_Capability<T>(real);

	}
}
