package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.world.Compat_World;
import net.minecraft.entity.Entity;

public class Compat_Entity {
	private CompatI_Entity wrapper;

	// When called from Mod
	public Compat_Entity(Compat_World world) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Entity.class, this, world.getReal()));
	}

	// When called from child
	protected Compat_Entity(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Entity(Entity original) {
		this.initialize(Factory.createWrapper(CompatI_Entity.class, original));
	}

	protected void initialize(CompatI_Entity wrapper) {
		this.wrapper = wrapper;
	}

	public Entity getReal() {
		return wrapper.get();
	}
}
