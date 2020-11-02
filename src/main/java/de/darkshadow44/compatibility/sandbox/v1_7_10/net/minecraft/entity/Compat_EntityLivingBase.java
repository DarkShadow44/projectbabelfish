package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.world.Compat_World;
import net.minecraft.entity.EntityLivingBase;

public class Compat_EntityLivingBase extends Compat_Entity {
	private CompatI_EntityLivingBase wrapper;

	// When called from Mod
	public Compat_EntityLivingBase(Compat_World world) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityLivingBase.class, this, world.getReal()));
	}

	// When called from child
	protected Compat_EntityLivingBase(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityLivingBase(EntityLivingBase original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityLivingBase.class, original));
	}

	protected void initialize(CompatI_EntityLivingBase wrapper) {
		this.wrapper = wrapper;
	}

	public EntityLivingBase getReal() {
		return wrapper.get();
	}
}
