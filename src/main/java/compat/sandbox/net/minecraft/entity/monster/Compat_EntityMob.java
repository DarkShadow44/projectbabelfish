package compat.sandbox.net.minecraft.entity.monster;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.entity.Compat_EntityCreature;
import compat.sandbox.net.minecraft.world.Compat_World;
import net.minecraft.entity.monster.EntityMob;

public class Compat_EntityMob extends Compat_EntityCreature {
	private CompatI_EntityMob wrapper;

	// When called from Mod
	public Compat_EntityMob(Compat_World world) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityMob.class, this, world.getReal()));
	}

	// When called from child
	protected Compat_EntityMob(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityMob(EntityMob original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityMob.class, original));
	}

	protected void initialize(CompatI_EntityMob wrapper) {
		this.wrapper = wrapper;
	}

	public EntityMob getReal() {
		return wrapper.get();
	}
}
