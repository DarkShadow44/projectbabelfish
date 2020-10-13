package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.passive;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.Compat_EntityLiving;
import net.minecraft.entity.passive.EntityWaterMob;

public class Compat_EntityWaterMob extends Compat_EntityLiving {
	private EntityWaterMob original;
	private CompatI_EntityWaterMob thisReal;

	// When called from Mod
	public Compat_EntityWaterMob() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityWaterMob.class, this), null);
	}

	// When called from child
	protected Compat_EntityWaterMob(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityWaterMob(EntityWaterMob original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityWaterMob thisReal, EntityWaterMob original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityWaterMob getReal() {
		return original == null ? thisReal.get() : original;
	}
}
