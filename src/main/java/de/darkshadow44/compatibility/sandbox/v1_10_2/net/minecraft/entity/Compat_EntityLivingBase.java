package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.EntityLivingBase;

public class Compat_EntityLivingBase extends Compat_Entity {
	private EntityLivingBase original;
	private CompatI_EntityLivingBase thisReal;

	// When called from Mod
	public Compat_EntityLivingBase() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityLivingBase.class, this), null);
	}

	// When called from child
	protected Compat_EntityLivingBase(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityLivingBase(EntityLivingBase original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityLivingBase thisReal, EntityLivingBase original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityLivingBase getReal() {
		return original == null ? thisReal.get() : original;
	}
}
