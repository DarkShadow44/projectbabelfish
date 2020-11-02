package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity.monster;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.monster.EntityBlaze;

public class Compat_EntityBlaze extends Compat_EntityMob {
	private CompatI_EntityBlaze wrapper;

	// When called from Mod
	public Compat_EntityBlaze() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityBlaze.class, this));
	}

	// When called from child
	protected Compat_EntityBlaze(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityBlaze(EntityBlaze original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityBlaze.class, original));
	}

	protected void initialize(CompatI_EntityBlaze wrapper) {
		this.wrapper = wrapper;
	}

	public EntityBlaze getReal() {
		return wrapper.get();
	}
}
