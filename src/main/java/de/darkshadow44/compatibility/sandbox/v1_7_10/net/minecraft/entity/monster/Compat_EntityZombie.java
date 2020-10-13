package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.monster;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.monster.EntityZombie;

public class Compat_EntityZombie extends Compat_EntityMob {
	private EntityZombie original;
	private CompatI_EntityZombie thisReal;

	// When called from Mod
	public Compat_EntityZombie() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityZombie.class, this), null);
	}

	// When called from child
	protected Compat_EntityZombie(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityZombie(EntityZombie original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityZombie thisReal, EntityZombie original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityZombie getReal() {
		return original == null ? thisReal.get() : original;
	}
}
