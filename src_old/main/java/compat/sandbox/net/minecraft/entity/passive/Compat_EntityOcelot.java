package compat.sandbox.net.minecraft.entity.passive;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.world.Compat_World;
import net.minecraft.entity.passive.EntityOcelot;

public class Compat_EntityOcelot extends Compat_EntityTameable {
	private CompatI_EntityOcelot wrapper;

	// When called from Mod
	public Compat_EntityOcelot(Compat_World world) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityOcelot.class, this, world.getReal()));
	}

	// When called from child
	protected Compat_EntityOcelot(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityOcelot(EntityOcelot original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityOcelot.class, original));
	}

	protected void initialize(CompatI_EntityOcelot wrapper) {
		this.wrapper = wrapper;
	}

	public EntityOcelot getReal() {
		return wrapper.get();
	}
}
