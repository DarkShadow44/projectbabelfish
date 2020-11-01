package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.EntityHanging;

public class Compat_EntityHanging extends Compat_Entity {
	private EntityHanging original;
	private CompatI_EntityHanging thisReal;

	// When called from Mod
	public Compat_EntityHanging() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityHanging.class, this), null);
	}

	// When called from child
	protected Compat_EntityHanging(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityHanging(EntityHanging original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityHanging thisReal, EntityHanging original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityHanging getReal() {
		return original == null ? thisReal.get() : original;
	}
}
