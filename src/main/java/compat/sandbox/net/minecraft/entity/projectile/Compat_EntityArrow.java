package compat.sandbox.net.minecraft.entity.projectile;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.entity.Compat_Entity;
import net.minecraft.entity.projectile.EntityArrow;

public class Compat_EntityArrow extends Compat_Entity {
	private CompatI_EntityArrow wrapper;

	// When called from Mod
	public Compat_EntityArrow() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityArrow.class, this));
	}

	// When called from child
	protected Compat_EntityArrow(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityArrow(EntityArrow original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityArrow.class, original));
	}

	protected void initialize(CompatI_EntityArrow wrapper) {
		this.wrapper = wrapper;
	}

	public EntityArrow getReal() {
		return wrapper.get();
	}
}
