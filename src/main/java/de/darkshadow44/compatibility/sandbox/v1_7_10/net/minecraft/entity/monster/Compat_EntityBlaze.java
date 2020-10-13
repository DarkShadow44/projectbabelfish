package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.monster;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.monster.EntityBlaze;

public class Compat_EntityBlaze extends Compat_EntityMob {
	private EntityBlaze original;
	private CompatI_EntityBlaze thisReal;

	// When called from Mod
	public Compat_EntityBlaze() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityBlaze.class, this), null);
	}

	// When called from child
	protected Compat_EntityBlaze(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityBlaze(EntityBlaze original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityBlaze thisReal, EntityBlaze original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityBlaze getReal() {
		return original == null ? thisReal.get() : original;
	}
}
