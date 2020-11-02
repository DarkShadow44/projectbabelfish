package compat.sandbox.net.minecraft.entity.passive;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.world.Compat_World;
import net.minecraft.entity.passive.EntityHorse;

public class Compat_EntityHorse extends Compat_AbstractHorse {
	private CompatI_EntityHorse wrapper;

	// When called from Mod
	public Compat_EntityHorse(Compat_World world) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityHorse.class, this, world.getReal()));
	}

	// When called from child
	protected Compat_EntityHorse(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityHorse(EntityHorse original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityHorse.class, original));
	}

	protected void initialize(CompatI_EntityHorse wrapper) {
		this.wrapper = wrapper;
	}

	public EntityHorse getReal() {
		return wrapper.get();
	}
}
