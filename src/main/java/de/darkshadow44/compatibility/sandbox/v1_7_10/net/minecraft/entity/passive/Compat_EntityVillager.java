package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.passive;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.Compat_EntityAgeable;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.world.Compat_World;
import net.minecraft.entity.passive.EntityVillager;

public class Compat_EntityVillager extends Compat_EntityAgeable {
	private EntityVillager original;
	private CompatI_EntityVillager thisReal;

	// When called from Mod
	public Compat_EntityVillager(Compat_World world) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, this, world.getReal()), null);
	}

	// When called from child
	protected Compat_EntityVillager(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityVillager(EntityVillager original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityVillager thisReal, EntityVillager original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityVillager getReal() {
		return original == null ? thisReal.get() : original;
	}
}
