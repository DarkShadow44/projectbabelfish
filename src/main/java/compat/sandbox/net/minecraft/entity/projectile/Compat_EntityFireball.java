package compat.sandbox.net.minecraft.entity.projectile;

import compat.autogen.Factory;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.entity.Compat_Entity;
import net.minecraft.entity.projectile.EntityFireball;

public class Compat_EntityFireball extends Compat_Entity {
	private CompatI_EntityFireball wrapper;

	// When called from child
	protected Compat_EntityFireball(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityFireball(EntityFireball original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityFireball.class, original));
	}

	protected void initialize(CompatI_EntityFireball wrapper) {
		this.wrapper = wrapper;
	}

	public EntityFireball getReal() {
		return wrapper.get();
	}
}
