package compat.sandbox.net.minecraft.entity.passive;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.entity.Compat_EntityLiving;
import net.minecraft.entity.passive.EntityWaterMob;

public class Compat_EntityWaterMob extends Compat_EntityLiving {
	private CompatI_EntityWaterMob wrapper;

	// When called from Mod
	public Compat_EntityWaterMob() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityWaterMob.class, this));
	}

	// When called from child
	protected Compat_EntityWaterMob(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityWaterMob(EntityWaterMob original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityWaterMob.class, original));
	}

	protected void initialize(CompatI_EntityWaterMob wrapper) {
		this.wrapper = wrapper;
	}

	public EntityWaterMob getReal() {
		return wrapper.get();
	}
}
