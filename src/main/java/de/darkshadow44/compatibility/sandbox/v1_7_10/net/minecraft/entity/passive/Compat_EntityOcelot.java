package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.passive;

import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.world.Compat_World;
import net.minecraft.entity.passive.EntityOcelot;

public class Compat_EntityOcelot extends Compat_EntityTameable {
	private EntityOcelot original;
	private CompatI_EntityOcelot thisReal;

	// When called from Mod
	public Compat_EntityOcelot(Compat_World world) {
		super(ParentSelector.NULL);
		this.initialize(new CompatReal_EntityOcelot(this, world.getReal()), null);
	}

	// When called from child
	protected Compat_EntityOcelot(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityOcelot(EntityOcelot original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityOcelot thisReal, EntityOcelot original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityOcelot getReal() {
		return original == null ? thisReal.get() : original;
	}
}
