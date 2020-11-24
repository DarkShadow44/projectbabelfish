package compat.sandbox.net.minecraft.client.particle;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.client.particle.ParticleManager;

public class Compat_EffectRenderer {
	private CompatI_EffectRenderer wrapper;

	// When called from Mod
	public Compat_EffectRenderer() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EffectRenderer.class, this));
	}

	// When called from child
	protected Compat_EffectRenderer(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_EffectRenderer(ParticleManager original) {
		this.initialize(Factory.createWrapper(CompatI_EffectRenderer.class, original));
	}

	protected void initialize(CompatI_EffectRenderer wrapper) {
		this.wrapper = wrapper;
	}

	public ParticleManager getReal() {
		return wrapper.get();
	}
}
