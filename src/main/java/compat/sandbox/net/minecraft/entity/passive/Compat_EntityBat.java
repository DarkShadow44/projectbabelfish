package compat.sandbox.net.minecraft.entity.passive;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.world.Compat_World;
import net.minecraft.entity.passive.EntityBat;

public class Compat_EntityBat extends Compat_EntityAmbientCreature {
	private CompatI_EntityBat wrapper;

	// When called from Mod
	public Compat_EntityBat(Compat_World world) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityBat.class, this, world.getReal()));
	}

	// When called from child
	protected Compat_EntityBat(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityBat(EntityBat original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityBat.class, original));
	}

	protected void initialize(CompatI_EntityBat wrapper) {
		this.wrapper = wrapper;
	}

	public EntityBat getReal() {
		return wrapper.get();
	}
}
