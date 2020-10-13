package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.projectile;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.Compat_Entity;
import net.minecraft.entity.projectile.EntityArrow;

public class Compat_EntityArrow extends Compat_Entity {
	private EntityArrow original;
	private CompatI_EntityArrow thisReal;

	// When called from Mod
	public Compat_EntityArrow() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityArrow.class, this), null);
	}

	// When called from child
	protected Compat_EntityArrow(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityArrow(EntityArrow original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityArrow thisReal, EntityArrow original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityArrow getReal() {
		return original == null ? thisReal.get() : original;
	}
}
