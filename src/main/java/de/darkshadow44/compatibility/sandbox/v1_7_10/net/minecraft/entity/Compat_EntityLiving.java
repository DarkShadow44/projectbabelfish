package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.world.Compat_World;
import net.minecraft.entity.EntityLiving;

public class Compat_EntityLiving extends Compat_EntityLivingBase {
	private EntityLiving original;
	private CompatI_EntityLiving thisReal;

	// When called from Mod
	public Compat_EntityLiving(Compat_World world) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, this, world.getReal()), null);
	}

	// When called from child
	protected Compat_EntityLiving(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityLiving(EntityLiving original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityLiving thisReal, EntityLiving original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityLiving getReal() {
		return original == null ? thisReal.get() : original;
	}
}
