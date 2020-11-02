package compat.sandbox.net.minecraft.entity.passive;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.world.Compat_World;
import net.minecraft.entity.passive.AbstractHorse;

public class Compat_AbstractHorse extends Compat_EntityAnimal {
	private CompatI_AbstractHorse wrapper;

	// When called from Mod
	public Compat_AbstractHorse(Compat_World world) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_AbstractHorse.class, this, world.getReal()));
	}

	// When called from child
	protected Compat_AbstractHorse(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_AbstractHorse(AbstractHorse original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_AbstractHorse.class, original));
	}

	protected void initialize(CompatI_AbstractHorse wrapper) {
		this.wrapper = wrapper;
	}

	public AbstractHorse getReal() {
		return wrapper.get();
	}
}
