package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.particle;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.particle.Particle;

public class Compat_Particle {
	private Particle original;
	private CompatI_Particle thisReal;

	// When called from Mod
	public Compat_Particle() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Particle.class, this), null);
	}

	// When called from child
	protected Compat_Particle(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Particle(Particle original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_Particle thisReal, Particle original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public Particle getReal() {
		return original == null ? thisReal.get() : original;
	}
}
