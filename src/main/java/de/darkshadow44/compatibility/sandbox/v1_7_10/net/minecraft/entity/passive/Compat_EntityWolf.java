package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.passive;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.passive.EntityWolf;

public class Compat_EntityWolf extends Compat_EntityTameable {
	private CompatI_EntityWolf wrapper;

	// When called from Mod
	public Compat_EntityWolf() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityWolf.class, this));
	}

	// When called from child
	protected Compat_EntityWolf(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityWolf(EntityWolf original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityWolf.class, original));
	}

	protected void initialize(CompatI_EntityWolf wrapper) {
		this.wrapper = wrapper;
	}

	public EntityWolf getReal() {
		return wrapper.get();
	}
}
