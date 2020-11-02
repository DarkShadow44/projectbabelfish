package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.ai;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.ai.EntityAIWatchClosest2;

public class Compat_EntityAIWatchClosest2 extends Compat_EntityAIWatchClosest {
	private CompatI_EntityAIWatchClosest2 wrapper;

	// When called from Mod
	public Compat_EntityAIWatchClosest2() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityAIWatchClosest2.class, this));
	}

	// When called from child
	protected Compat_EntityAIWatchClosest2(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityAIWatchClosest2(EntityAIWatchClosest2 original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityAIWatchClosest2.class, original));
	}

	protected void initialize(CompatI_EntityAIWatchClosest2 wrapper) {
		this.wrapper = wrapper;
	}

	public EntityAIWatchClosest2 getReal() {
		return wrapper.get();
	}
}
