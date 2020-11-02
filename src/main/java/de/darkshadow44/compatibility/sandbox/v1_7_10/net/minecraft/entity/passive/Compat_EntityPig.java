package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.passive;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.passive.EntityPig;

public class Compat_EntityPig extends Compat_EntityAnimal {
	private CompatI_EntityPig wrapper;

	// When called from Mod
	public Compat_EntityPig() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityPig.class, this));
	}

	// When called from child
	protected Compat_EntityPig(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityPig(EntityPig original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityPig.class, original));
	}

	protected void initialize(CompatI_EntityPig wrapper) {
		this.wrapper = wrapper;
	}

	public EntityPig getReal() {
		return wrapper.get();
	}
}
