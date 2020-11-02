package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity.monster;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.monster.EntityPigZombie;

public class Compat_EntityPigZombie extends Compat_EntityZombie {
	private CompatI_EntityPigZombie wrapper;

	// When called from Mod
	public Compat_EntityPigZombie() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityPigZombie.class, this));
	}

	// When called from child
	protected Compat_EntityPigZombie(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityPigZombie(EntityPigZombie original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityPigZombie.class, original));
	}

	protected void initialize(CompatI_EntityPigZombie wrapper) {
		this.wrapper = wrapper;
	}

	public EntityPigZombie getReal() {
		return wrapper.get();
	}
}
