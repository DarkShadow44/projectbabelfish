package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.passive;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.world.Compat_World;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.Compat_EntityAgeable;
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
