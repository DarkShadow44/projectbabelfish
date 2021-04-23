package compat.sandbox.net.minecraft.entity.monster;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.entity.Compat_EntityCreature;
import compat.sandbox.net.minecraft.world.Compat_World;
import net.minecraft.entity.monster.EntityGolem;

public class Compat_EntityGolem extends Compat_EntityCreature {
	private CompatI_EntityGolem wrapper;

	// When called from Mod
	public Compat_EntityGolem(Compat_World world) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityGolem.class, this, world.getReal()));
	}

	// When called from child
	protected Compat_EntityGolem(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityGolem(EntityGolem original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityGolem.class, original));
	}

	protected void initialize(CompatI_EntityGolem wrapper) {
		this.wrapper = wrapper;
	}

	public EntityGolem getReal() {
		return wrapper.get();
	}
}
