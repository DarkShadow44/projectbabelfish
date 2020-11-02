package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.world.Compat_World;
import net.minecraft.entity.EntityLiving;

public class Compat_EntityLiving extends Compat_EntityLivingBase {
	private CompatI_EntityLiving wrapper;

	// When called from Mod
	public Compat_EntityLiving(Compat_World world) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityLiving.class, this, world.getReal()));
	}

	// When called from child
	protected Compat_EntityLiving(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityLiving(EntityLiving original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityLiving.class, original));
	}

	protected void initialize(CompatI_EntityLiving wrapper) {
		this.wrapper = wrapper;
	}

	public EntityLiving getReal() {
		return wrapper.get();
	}
}
