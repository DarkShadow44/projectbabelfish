package compat.sandbox.net.minecraft.entity.passive;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.entity.Compat_EntityAgeable;
import compat.sandbox.net.minecraft.world.Compat_World;
import net.minecraft.entity.passive.EntityVillager;

public class Compat_EntityVillager extends Compat_EntityAgeable {
	private CompatI_EntityVillager wrapper;

	// When called from Mod
	public Compat_EntityVillager(Compat_World world) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityVillager.class, this, world.getReal()));
	}

	// When called from child
	protected Compat_EntityVillager(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityVillager(EntityVillager original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityVillager.class, original));
	}

	protected void initialize(CompatI_EntityVillager wrapper) {
		this.wrapper = wrapper;
	}

	public EntityVillager getReal() {
		return wrapper.get();
	}
}
