package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.passive;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.world.Compat_World;
import net.minecraft.entity.passive.EntityBat;

public class Compat_EntityBat extends Compat_EntityAmbientCreature {
	private EntityBat original;
	private CompatI_EntityBat thisReal;

	// When called from Mod
	public Compat_EntityBat(Compat_World world) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityBat.class, this, world.getReal()), null);
	}

	// When called from child
	protected Compat_EntityBat(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityBat(EntityBat original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityBat thisReal, EntityBat original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityBat getReal() {
		return original == null ? thisReal.get() : original;
	}
}
