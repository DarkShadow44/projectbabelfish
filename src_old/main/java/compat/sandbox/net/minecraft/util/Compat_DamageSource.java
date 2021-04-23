package compat.sandbox.net.minecraft.util;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.util.DamageSource;

public class Compat_DamageSource {
	private CompatI_DamageSource wrapper;

	// When called from Mod
	public Compat_DamageSource(String p1) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_DamageSource.class, this, p1));
	}

	// When called from child
	protected Compat_DamageSource(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_DamageSource(DamageSource original) {
		this.initialize(Factory.createWrapper(CompatI_DamageSource.class, original));
	}

	protected void initialize(CompatI_DamageSource wrapper) {
		this.wrapper = wrapper;
	}

	public DamageSource getReal() {
		return wrapper.get();
	}
}
