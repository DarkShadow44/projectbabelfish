package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.particle;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.particle.ParticleDigging;

public class Compat_ParticleDigging extends Compat_Particle {
	private ParticleDigging original;
	private CompatI_ParticleDigging thisReal;

	// When called from Mod
	public Compat_ParticleDigging() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ParticleDigging.class, this), null);
	}

	// When called from child
	protected Compat_ParticleDigging(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ParticleDigging(ParticleDigging original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_ParticleDigging thisReal, ParticleDigging original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public ParticleDigging getReal() {
		return original == null ? thisReal.get() : original;
	}
}
