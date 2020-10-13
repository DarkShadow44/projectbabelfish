package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.monster;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.Compat_EntityFlying;
import net.minecraft.entity.monster.EntityGhast;

public class Compat_EntityGhast extends Compat_EntityFlying {
	private EntityGhast original;
	private CompatI_EntityGhast thisReal;

	// When called from Mod
	public Compat_EntityGhast() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityGhast.class, this), null);
	}

	// When called from child
	protected Compat_EntityGhast(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityGhast(EntityGhast original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityGhast thisReal, EntityGhast original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityGhast getReal() {
		return original == null ? thisReal.get() : original;
	}
}
