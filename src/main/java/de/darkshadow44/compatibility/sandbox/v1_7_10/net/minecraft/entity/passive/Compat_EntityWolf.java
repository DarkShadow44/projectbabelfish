package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.passive;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.passive.EntityWolf;

public class Compat_EntityWolf extends Compat_EntityTameable {
	private EntityWolf original;
	private CompatI_EntityWolf thisReal;

	// When called from Mod
	public Compat_EntityWolf() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityWolf.class, this), null);
	}

	// When called from child
	protected Compat_EntityWolf(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityWolf(EntityWolf original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityWolf thisReal, EntityWolf original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityWolf getReal() {
		return original == null ? thisReal.get() : original;
	}
}
