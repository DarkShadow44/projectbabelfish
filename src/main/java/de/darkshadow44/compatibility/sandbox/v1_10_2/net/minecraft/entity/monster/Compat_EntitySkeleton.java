package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity.monster;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.monster.EntitySkeleton;

public class Compat_EntitySkeleton extends Compat_AbstractSkeleton {
	private CompatI_EntitySkeleton wrapper;

	// When called from Mod
	public Compat_EntitySkeleton() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntitySkeleton.class, this));
	}

	// When called from child
	protected Compat_EntitySkeleton(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntitySkeleton(EntitySkeleton original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntitySkeleton.class, original));
	}

	protected void initialize(CompatI_EntitySkeleton wrapper) {
		this.wrapper = wrapper;
	}

	public EntitySkeleton getReal() {
		return wrapper.get();
	}
}
