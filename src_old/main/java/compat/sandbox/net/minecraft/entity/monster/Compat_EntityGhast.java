package compat.sandbox.net.minecraft.entity.monster;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.entity.Compat_EntityFlying;
import net.minecraft.entity.monster.EntityGhast;

public class Compat_EntityGhast extends Compat_EntityFlying {
	private CompatI_EntityGhast wrapper;

	// When called from Mod
	public Compat_EntityGhast() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityGhast.class, this));
	}

	// When called from child
	protected Compat_EntityGhast(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityGhast(EntityGhast original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityGhast.class, original));
	}

	protected void initialize(CompatI_EntityGhast wrapper) {
		this.wrapper = wrapper;
	}

	public EntityGhast getReal() {
		return wrapper.get();
	}
}
