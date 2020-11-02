package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity.passive;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.world.Compat_World;
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
