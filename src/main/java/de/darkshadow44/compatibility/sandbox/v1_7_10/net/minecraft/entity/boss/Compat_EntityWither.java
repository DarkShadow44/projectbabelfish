package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.boss;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.monster.Compat_EntityMob;
import net.minecraft.entity.boss.EntityWither;

public class Compat_EntityWither extends Compat_EntityMob {
	private EntityWither original;
	private CompatI_EntityWither thisReal;

	// When called from Mod
	public Compat_EntityWither() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityWither.class, this), null);
	}

	// When called from child
	protected Compat_EntityWither(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityWither(EntityWither original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityWither thisReal, EntityWither original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityWither getReal() {
		return original == null ? thisReal.get() : original;
	}
}
