package compat.sandbox.net.minecraft.entity.passive;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.entity.Compat_EntityAgeable;
import compat.sandbox.net.minecraft.world.Compat_World;
import net.minecraft.entity.passive.EntityAnimal;

public class Compat_EntityAnimal extends Compat_EntityAgeable {
	private CompatI_EntityAnimal wrapper;

	// When called from Mod
	public Compat_EntityAnimal(Compat_World world) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityAnimal.class, this, world.getReal()));
	}

	// When called from child
	protected Compat_EntityAnimal(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityAnimal(EntityAnimal original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityAnimal.class, original));
	}

	protected void initialize(CompatI_EntityAnimal wrapper) {
		this.wrapper = wrapper;
	}

	public EntityAnimal getReal() {
		return wrapper.get();
	}
}
