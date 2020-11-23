package compat.sandbox.net.minecraft.client.particle;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.client.particle.ParticleSmokeNormal;

public class Compat_EntitySmokeFX extends Compat_Particle {
	private CompatI_EntitySmokeFX wrapper;

	// When called from Mod
	public Compat_EntitySmokeFX() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntitySmokeFX.class, this));
	}

	// When called from child
	protected Compat_EntitySmokeFX(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntitySmokeFX(ParticleSmokeNormal original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntitySmokeFX.class, original));
	}

	protected void initialize(CompatI_EntitySmokeFX wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public ParticleSmokeNormal getReal() {
		return wrapper.get();
	}
}
