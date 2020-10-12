package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.passive;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.Compat_EntityLiving;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.world.Compat_World;
import net.minecraft.entity.passive.EntityAmbientCreature;

public class Compat_EntityAmbientCreature extends Compat_EntityLiving {
	private EntityAmbientCreature original;
	private CompatI_EntityAmbientCreature thisReal;

	// When called from Mod
	public Compat_EntityAmbientCreature(Compat_World world) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityAmbientCreature.class, this, world.getReal()), null);
	}

	// When called from child
	protected Compat_EntityAmbientCreature(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityAmbientCreature(EntityAmbientCreature original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityAmbientCreature thisReal, EntityAmbientCreature original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityAmbientCreature getReal() {
		return original == null ? thisReal.get() : original;
	}
}
