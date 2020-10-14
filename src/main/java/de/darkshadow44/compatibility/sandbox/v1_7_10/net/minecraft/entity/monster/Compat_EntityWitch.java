package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.monster;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.monster.EntityWitch;

public class Compat_EntityWitch extends Compat_EntityMob {
	private EntityWitch original;
	private CompatI_EntityWitch thisReal;

	// When called from Mod
	public Compat_EntityWitch() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityWitch.class, this), null);
	}

	// When called from child
	protected Compat_EntityWitch(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityWitch(EntityWitch original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityWitch thisReal, EntityWitch original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityWitch getReal() {
		return original == null ? thisReal.get() : original;
	}
}
