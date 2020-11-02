package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.monster;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.monster.EntityCreeper;

public class Compat_EntityCreeper extends Compat_EntityMob {
	private CompatI_EntityCreeper wrapper;

	// When called from Mod
	public Compat_EntityCreeper() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityCreeper.class, this));
	}

	// When called from child
	protected Compat_EntityCreeper(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityCreeper(EntityCreeper original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityCreeper.class, original));
	}

	protected void initialize(CompatI_EntityCreeper wrapper) {
		this.wrapper = wrapper;
	}

	public EntityCreeper getReal() {
		return wrapper.get();
	}
}
