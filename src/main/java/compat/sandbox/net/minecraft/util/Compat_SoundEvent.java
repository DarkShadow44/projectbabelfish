package compat.sandbox.net.minecraft.util;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.util.SoundEvent;

public class Compat_SoundEvent {
	private CompatI_SoundEvent wrapper;

	// When called from Mod
	public Compat_SoundEvent(Compat_ResourceLocation location) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_SoundEvent.class, this, location.getReal()));
	}

	// When called from child
	protected Compat_SoundEvent(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_SoundEvent(SoundEvent original) {
		this.initialize(Factory.createWrapper(CompatI_SoundEvent.class, original));
	}

	protected void initialize(CompatI_SoundEvent wrapper) {
		this.wrapper = wrapper;
	}

	public SoundEvent getReal() {
		return wrapper.get();
	}

	public static SoundEvent getByName(String name) {
		switch (name) {
		default:
			throw new RuntimeException("Unknown sound: " + name);
		}
	}
}
