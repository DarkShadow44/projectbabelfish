package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.projectile;

import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.Compat_Entity;
import net.minecraft.entity.projectile.EntityThrowable;

public class Compat_EntityThrowable extends Compat_Entity {
	private EntityThrowable original;
	private CompatI_EntityThrowable thisReal;

	// When called from child
	protected Compat_EntityThrowable(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityThrowable(EntityThrowable original) {
		super(ParentSelector.NULL);
		super.initialize(null, original);
	}

	protected void initialize(CompatI_EntityThrowable thisReal, EntityThrowable original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityThrowable getReal() {
		return original == null ? thisReal.get() : original;
	}
}
