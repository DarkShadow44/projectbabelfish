package compat.sandbox.net.minecraft.client.particle;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.client.particle.ParticleSmokeNormal;

public class Compat_ParticleSmokeNormal extends Compat_Particle {
	private CompatI_ParticleSmokeNormal wrapper;

	// When called from Mod
	public Compat_ParticleSmokeNormal() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ParticleSmokeNormal.class, this));
	}

	// When called from child
	protected Compat_ParticleSmokeNormal(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ParticleSmokeNormal(ParticleSmokeNormal original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_ParticleSmokeNormal.class, original));
	}

	protected void initialize(CompatI_ParticleSmokeNormal wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public ParticleSmokeNormal getReal() {
		return wrapper.get();
	}
}
