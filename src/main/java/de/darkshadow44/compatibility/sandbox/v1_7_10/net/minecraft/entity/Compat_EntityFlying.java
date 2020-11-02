package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.EntityFlying;

public class Compat_EntityFlying extends Compat_EntityLiving {
	private CompatI_EntityFlying wrapper;

	// When called from Mod
	public Compat_EntityFlying() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityFlying.class, this));
	}

	// When called from child
	protected Compat_EntityFlying(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityFlying(EntityFlying original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityFlying.class, original));
	}

	protected void initialize(CompatI_EntityFlying wrapper) {
		this.wrapper = wrapper;
	}

	public EntityFlying getReal() {
		return wrapper.get();
	}
}
