package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.world.Compat_World;
import net.minecraft.entity.EntityCreature;

public class Compat_EntityCreature extends Compat_EntityLiving {
	private CompatI_EntityCreature wrapper;

	// When called from Mod
	public Compat_EntityCreature(Compat_World world) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityCreature.class, this, world.getReal()));
	}

	// When called from child
	protected Compat_EntityCreature(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityCreature(EntityCreature original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityCreature.class, original));
	}

	protected void initialize(CompatI_EntityCreature wrapper) {
		this.wrapper = wrapper;
	}

	public EntityCreature getReal() {
		return wrapper.get();
	}
}
