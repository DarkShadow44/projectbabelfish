package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity;

import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.world.Compat_World;
import net.minecraft.entity.EntityLivingBase;

public class Compat_EntityLivingBase extends Compat_Entity {
	private EntityLivingBase original;
	private CompatI_EntityLivingBase thisReal;

	// When called from Mod
	public Compat_EntityLivingBase(Compat_World world) {
		super(ParentSelector.NULL);
		super.initialize(new CompatReal_EntityLivingBase(this, world.getReal()), null);
	}

	// When called from child
	protected Compat_EntityLivingBase(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityLivingBase(EntityLivingBase original) {
		super(ParentSelector.NULL);
		super.initialize(null, original);
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
