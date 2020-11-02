package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.particle;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.particle.ParticleManager;

public class Compat_ParticleManager {
	private CompatI_ParticleManager wrapper;

	// When called from Mod
	public Compat_ParticleManager() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ParticleManager.class, this));
	}

	// When called from child
	protected Compat_ParticleManager(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_ParticleManager(ParticleManager original) {
		this.initialize(Factory.createWrapper(CompatI_ParticleManager.class, original));
	}

	protected void initialize(CompatI_ParticleManager wrapper) {
		this.wrapper = wrapper;
	}

	public ParticleManager getReal() {
		return wrapper.get();
	}
}
