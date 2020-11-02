package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity.passive;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.passive.EntitySheep;

public class Compat_EntitySheep extends Compat_EntityAnimal {
	private CompatI_EntitySheep wrapper;

	// When called from Mod
	public Compat_EntitySheep() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntitySheep.class, this));
	}

	// When called from child
	protected Compat_EntitySheep(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntitySheep(EntitySheep original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntitySheep.class, original));
	}

	protected void initialize(CompatI_EntitySheep wrapper) {
		this.wrapper = wrapper;
	}

	public EntitySheep getReal() {
		return wrapper.get();
	}
}
