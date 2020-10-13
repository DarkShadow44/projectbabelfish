package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.passive;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.passive.EntitySquid;

public class Compat_EntitySquid extends Compat_EntityWaterMob {
	private EntitySquid original;
	private CompatI_EntitySquid thisReal;

	// When called from Mod
	public Compat_EntitySquid() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntitySquid.class, this), null);
	}

	// When called from child
	protected Compat_EntitySquid(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntitySquid(EntitySquid original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntitySquid thisReal, EntitySquid original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntitySquid getReal() {
		return original == null ? thisReal.get() : original;
	}
}
