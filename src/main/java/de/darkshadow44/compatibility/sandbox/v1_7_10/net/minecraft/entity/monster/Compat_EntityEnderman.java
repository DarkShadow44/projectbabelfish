package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.monster;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.monster.EntityEnderman;

public class Compat_EntityEnderman extends Compat_EntityMob {
	private EntityEnderman original;
	private CompatI_EntityEnderman thisReal;

	// When called from Mod
	public Compat_EntityEnderman() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityEnderman.class, this), null);
	}

	// When called from child
	protected Compat_EntityEnderman(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityEnderman(EntityEnderman original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityEnderman thisReal, EntityEnderman original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityEnderman getReal() {
		return original == null ? thisReal.get() : original;
	}
}
