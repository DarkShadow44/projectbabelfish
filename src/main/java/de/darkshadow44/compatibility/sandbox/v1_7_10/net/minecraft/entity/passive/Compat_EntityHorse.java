package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.passive;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.world.Compat_World;
import net.minecraft.entity.passive.EntityHorse;

public class Compat_EntityHorse extends Compat_AbstractHorse {
	private EntityHorse original;
	private CompatI_EntityHorse thisReal;

	// When called from Mod
	public Compat_EntityHorse(Compat_World world) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityHorse.class, this, world.getReal()), null);
	}

	// When called from child
	protected Compat_EntityHorse(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityHorse(EntityHorse original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityHorse thisReal, EntityHorse original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityHorse getReal() {
		return original == null ? thisReal.get() : original;
	}
}
