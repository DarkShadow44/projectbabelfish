package compat.sandbox.net.minecraft.entity.projectile;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.entity.projectile.EntityLargeFireball;

public class Compat_EntityLargeFireball extends Compat_EntityFireball {
	private CompatI_EntityLargeFireball wrapper;

	// When called from Mod
	public Compat_EntityLargeFireball() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityLargeFireball.class, this));
	}

	// When called from child
	protected Compat_EntityLargeFireball(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityLargeFireball(EntityLargeFireball original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityLargeFireball.class, original));
	}

	protected void initialize(CompatI_EntityLargeFireball wrapper) {
		this.wrapper = wrapper;
	}

	public EntityLargeFireball getReal() {
		return wrapper.get();
	}
}
