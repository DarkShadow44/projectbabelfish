package compat.sandbox.net.minecraft.client.particle;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.client.particle.Particle;

public class Compat_Particle {
	private CompatI_Particle wrapper;

	// When called from Mod
	public Compat_Particle() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Particle.class, this));
	}

	// When called from child
	protected Compat_Particle(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Particle(Particle original) {
		this.initialize(Factory.createWrapper(CompatI_Particle.class, original));
	}

	protected void initialize(CompatI_Particle wrapper) {
		this.wrapper = wrapper;
	}

	public Particle getReal() {
		return wrapper.get();
	}

	public static Compat_Particle getFake(Particle real) {
		return new Compat_Particle(real);
	}
}
