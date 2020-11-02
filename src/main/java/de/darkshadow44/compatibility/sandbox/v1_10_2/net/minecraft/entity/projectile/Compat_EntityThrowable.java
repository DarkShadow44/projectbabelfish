package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity.projectile;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity.Compat_Entity;
import net.minecraft.entity.projectile.EntityThrowable;

public class Compat_EntityThrowable extends Compat_Entity {
	private CompatI_EntityThrowable wrapper;

	// When called from child
	protected Compat_EntityThrowable(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityThrowable(EntityThrowable original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityThrowable.class, original));
	}

	protected void initialize(CompatI_EntityThrowable wrapper) {
		this.wrapper = wrapper;
	}

	public EntityThrowable getReal() {
		return wrapper.get();
	}
}
