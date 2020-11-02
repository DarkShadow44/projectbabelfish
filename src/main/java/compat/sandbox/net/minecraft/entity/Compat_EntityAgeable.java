package compat.sandbox.net.minecraft.entity;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.world.Compat_World;
import net.minecraft.entity.EntityAgeable;

public class Compat_EntityAgeable extends Compat_EntityCreature {
	private CompatI_EntityAgeable wrapper;

	// When called from Mod
	public Compat_EntityAgeable(Compat_World world) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityAgeable.class, this, world.getReal()));
	}

	// When called from child
	protected Compat_EntityAgeable(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityAgeable(EntityAgeable original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityAgeable.class, original));
	}

	protected void initialize(CompatI_EntityAgeable wrapper) {
		this.wrapper = wrapper;
	}

	public EntityAgeable getReal() {
		return wrapper.get();
	}
}
