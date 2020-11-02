package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.passive;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.passive.EntityMooshroom;

public class Compat_EntityMooshroom extends Compat_EntityCow {
	private CompatI_EntityMooshroom wrapper;

	// When called from Mod
	public Compat_EntityMooshroom() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityMooshroom.class, this));
	}

	// When called from child
	protected Compat_EntityMooshroom(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityMooshroom(EntityMooshroom original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityMooshroom.class, original));
	}

	protected void initialize(CompatI_EntityMooshroom wrapper) {
		this.wrapper = wrapper;
	}

	public EntityMooshroom getReal() {
		return wrapper.get();
	}
}
