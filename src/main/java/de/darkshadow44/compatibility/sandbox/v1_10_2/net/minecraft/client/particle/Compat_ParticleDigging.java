package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.particle;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.particle.ParticleDigging;

public class Compat_ParticleDigging extends Compat_Particle {
	private CompatI_ParticleDigging wrapper;

	// When called from Mod
	public Compat_ParticleDigging() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ParticleDigging.class, this));
	}

	// When called from child
	protected Compat_ParticleDigging(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ParticleDigging(ParticleDigging original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_ParticleDigging.class, original));
	}

	protected void initialize(CompatI_ParticleDigging wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public ParticleDigging getReal() {
		return wrapper.get();
	}
}
