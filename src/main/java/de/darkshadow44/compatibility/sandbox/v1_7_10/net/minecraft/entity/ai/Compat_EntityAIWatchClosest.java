package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.ai;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.ai.EntityAIWatchClosest;

public class Compat_EntityAIWatchClosest extends Compat_EntityAIBase {
	private EntityAIWatchClosest original;
	private CompatI_EntityAIWatchClosest thisReal;

	// When called from Mod
	public Compat_EntityAIWatchClosest() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityAIWatchClosest.class, this), null);
	}

	// When called from child
	protected Compat_EntityAIWatchClosest(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityAIWatchClosest(EntityAIWatchClosest original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityAIWatchClosest thisReal, EntityAIWatchClosest original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityAIWatchClosest getReal() {
		return original == null ? thisReal.get() : original;
	}
}
