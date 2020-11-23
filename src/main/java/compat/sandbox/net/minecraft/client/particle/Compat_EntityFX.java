package compat.sandbox.net.minecraft.client.particle;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.client.particle.Particle;

public class Compat_EntityFX {
	private CompatI_EntityFX wrapper;

	// When called from Mod
	public Compat_EntityFX() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityFX.class, this));
	}

	// When called from child
	protected Compat_EntityFX(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_EntityFX(Particle original) {
		this.initialize(Factory.createWrapper(CompatI_EntityFX.class, original));
	}

	protected void initialize(CompatI_EntityFX wrapper) {
		this.wrapper = wrapper;
	}

	public Particle getReal() {
		return wrapper.get();
	}
}
