package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.Entity;

public class Compat_Entity {
	private Entity original;
	private CompatI_Entity thisReal;

	// When called from Mod
	public Compat_Entity() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Entity.class, this), null);
	}

	// When called from child
	protected Compat_Entity(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Entity(Entity original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_Entity thisReal, Entity original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public Entity getReal() {
		return original == null ? thisReal.get() : original;
	}
}