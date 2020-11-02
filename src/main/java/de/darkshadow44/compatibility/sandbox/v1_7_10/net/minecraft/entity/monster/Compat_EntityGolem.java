package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.monster;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.world.Compat_World;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.Compat_EntityCreature;
import net.minecraft.entity.monster.EntityGolem;

public class Compat_EntityGolem extends Compat_EntityCreature {
	private CompatI_EntityGolem wrapper;

	// When called from Mod
	public Compat_EntityGolem(Compat_World world) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityGolem.class, this, world.getReal()));
	}

	// When called from child
	protected Compat_EntityGolem(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityGolem(EntityGolem original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityGolem.class, original));
	}

	protected void initialize(CompatI_EntityGolem wrapper) {
		this.wrapper = wrapper;
	}

	public EntityGolem getReal() {
		return wrapper.get();
	}
}
