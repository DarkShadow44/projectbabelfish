package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.passive;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.passive.EntityChicken;

public class Compat_EntityChicken extends Compat_EntityAnimal {
	private EntityChicken original;
	private CompatI_EntityChicken thisReal;

	// When called from Mod
	public Compat_EntityChicken() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityChicken.class, this), null);
	}

	// When called from child
	protected Compat_EntityChicken(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityChicken(EntityChicken original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityChicken thisReal, EntityChicken original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityChicken getReal() {
		return original == null ? thisReal.get() : original;
	}
}
