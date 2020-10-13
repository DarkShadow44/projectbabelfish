package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.passive;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.passive.EntityMooshroom;

public class Compat_EntityMooshroom extends Compat_EntityCow {
	private EntityMooshroom original;
	private CompatI_EntityMooshroom thisReal;

	// When called from Mod
	public Compat_EntityMooshroom() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityMooshroom.class, this), null);
	}

	// When called from child
	protected Compat_EntityMooshroom(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityMooshroom(EntityMooshroom original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityMooshroom thisReal, EntityMooshroom original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityMooshroom getReal() {
		return original == null ? thisReal.get() : original;
	}
}
