package compat.sandbox.net.minecraft.client.particle;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.client.particle.ParticleDigging;

public class Compat_EntityDiggingFX extends Compat_Particle {
	private CompatI_EntityDiggingFX wrapper;

	// When called from Mod
	public Compat_EntityDiggingFX() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityDiggingFX.class, this));
	}

	// When called from child
	protected Compat_EntityDiggingFX(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityDiggingFX(ParticleDigging original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityDiggingFX.class, original));
	}

	protected void initialize(CompatI_EntityDiggingFX wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public ParticleDigging getReal() {
		return wrapper.get();
	}
}
