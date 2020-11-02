package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity.monster;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.monster.EntityZombie;

public class Compat_EntityZombie extends Compat_EntityMob {
	private CompatI_EntityZombie wrapper;

	// When called from Mod
	public Compat_EntityZombie() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityZombie.class, this));
	}

	// When called from child
	protected Compat_EntityZombie(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityZombie(EntityZombie original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityZombie.class, original));
	}

	protected void initialize(CompatI_EntityZombie wrapper) {
		this.wrapper = wrapper;
	}

	public EntityZombie getReal() {
		return wrapper.get();
	}
}
