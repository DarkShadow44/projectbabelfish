package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity.passive;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity.Compat_EntityLiving;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.world.Compat_World;
import net.minecraft.entity.passive.EntityAmbientCreature;

public class Compat_EntityAmbientCreature extends Compat_EntityLiving {
	private CompatI_EntityAmbientCreature wrapper;

	// When called from Mod
	public Compat_EntityAmbientCreature(Compat_World world) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityAmbientCreature.class, this, world.getReal()));
	}

	// When called from child
	protected Compat_EntityAmbientCreature(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityAmbientCreature(EntityAmbientCreature original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityAmbientCreature.class, original));
	}

	protected void initialize(CompatI_EntityAmbientCreature wrapper) {
		this.wrapper = wrapper;
	}

	public EntityAmbientCreature getReal() {
		return wrapper.get();
	}
}
