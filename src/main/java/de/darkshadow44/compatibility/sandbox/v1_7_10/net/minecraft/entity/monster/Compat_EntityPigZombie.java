package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.monster;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.monster.EntityPigZombie;

public class Compat_EntityPigZombie extends Compat_EntityZombie {
	private EntityPigZombie original;
	private CompatI_EntityPigZombie thisReal;

	// When called from Mod
	public Compat_EntityPigZombie() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityPigZombie.class, this), null);
	}

	// When called from child
	protected Compat_EntityPigZombie(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityPigZombie(EntityPigZombie original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityPigZombie thisReal, EntityPigZombie original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityPigZombie getReal() {
		return original == null ? thisReal.get() : original;
	}
}
