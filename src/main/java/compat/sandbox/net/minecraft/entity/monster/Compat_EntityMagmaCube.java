package compat.sandbox.net.minecraft.entity.monster;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.world.Compat_World;
import net.minecraft.entity.monster.EntityMagmaCube;

public class Compat_EntityMagmaCube extends Compat_EntitySlime {
	private CompatI_EntityMagmaCube wrapper;

	// When called from Mod
	public Compat_EntityMagmaCube(Compat_World world) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityMagmaCube.class, this, world.getReal()));
	}

	// When called from child
	protected Compat_EntityMagmaCube(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityMagmaCube(EntityMagmaCube original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityMagmaCube.class, original));
	}

	protected void initialize(CompatI_EntityMagmaCube wrapper) {
		this.wrapper = wrapper;
	}

	public EntityMagmaCube getReal() {
		return wrapper.get();
	}
}
