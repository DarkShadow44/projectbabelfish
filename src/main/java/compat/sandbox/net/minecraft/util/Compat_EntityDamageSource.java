package compat.sandbox.net.minecraft.util;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.entity.Compat_Entity;
import net.minecraft.util.EntityDamageSource;

public class Compat_EntityDamageSource extends Compat_DamageSource {
	private CompatI_EntityDamageSource wrapper;

	// When called from Mod
	public Compat_EntityDamageSource(String p1, Compat_Entity entity) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityDamageSource.class, this, p1, entity.getReal()));
	}

	// When called from child
	protected Compat_EntityDamageSource(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityDamageSource(EntityDamageSource original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityDamageSource.class, original));
	}

	protected void initialize(CompatI_EntityDamageSource wrapper) {
		this.wrapper = wrapper;
	}

	public EntityDamageSource getReal() {
		return wrapper.get();
	}
}
