package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.monster;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.monster.AbstractSkeleton;

public class Compat_AbstractSkeleton extends Compat_EntityMob {
	private AbstractSkeleton original;
	private CompatI_AbstractSkeleton thisReal;

	// When called from Mod
	public Compat_AbstractSkeleton() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_AbstractSkeleton.class, this), null);
	}

	// When called from child
	protected Compat_AbstractSkeleton(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_AbstractSkeleton(AbstractSkeleton original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_AbstractSkeleton thisReal, AbstractSkeleton original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public AbstractSkeleton getReal() {
		return original == null ? thisReal.get() : original;
	}
}
