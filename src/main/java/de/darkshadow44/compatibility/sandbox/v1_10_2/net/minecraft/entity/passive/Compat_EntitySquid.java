package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity.passive;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.passive.EntitySquid;

public class Compat_EntitySquid extends Compat_EntityWaterMob {
	private CompatI_EntitySquid wrapper;

	// When called from Mod
	public Compat_EntitySquid() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntitySquid.class, this));
	}

	// When called from child
	protected Compat_EntitySquid(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntitySquid(EntitySquid original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntitySquid.class, original));
	}

	protected void initialize(CompatI_EntitySquid wrapper) {
		this.wrapper = wrapper;
	}

	public EntitySquid getReal() {
		return wrapper.get();
	}
}
