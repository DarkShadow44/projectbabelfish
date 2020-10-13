package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.monster;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.monster.EntitySkeleton;

public class Compat_EntitySkeleton extends Compat_AbstractSkeleton {
	private EntitySkeleton original;
	private CompatI_EntitySkeleton thisReal;

	// When called from Mod
	public Compat_EntitySkeleton() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntitySkeleton.class, this), null);
	}

	// When called from child
	protected Compat_EntitySkeleton(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntitySkeleton(EntitySkeleton original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntitySkeleton thisReal, EntitySkeleton original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntitySkeleton getReal() {
		return original == null ? thisReal.get() : original;
	}
}
