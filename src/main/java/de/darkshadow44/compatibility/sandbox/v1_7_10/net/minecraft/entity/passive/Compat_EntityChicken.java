package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.passive;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.passive.EntityChicken;

public class Compat_EntityChicken extends Compat_EntityAnimal {
	private CompatI_EntityChicken wrapper;

	// When called from Mod
	public Compat_EntityChicken() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityChicken.class, this));
	}

	// When called from child
	protected Compat_EntityChicken(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityChicken(EntityChicken original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityChicken.class, original));
	}

	protected void initialize(CompatI_EntityChicken wrapper) {
		this.wrapper = wrapper;
	}

	public EntityChicken getReal() {
		return wrapper.get();
	}
}
