package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity;

import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.world.Compat_World;
import net.minecraft.entity.EntityAgeable;

public class Compat_EntityAgeable extends Compat_EntityCreature {
	private EntityAgeable original;
	private CompatI_EntityAgeable thisReal;

	// When called from Mod
	public Compat_EntityAgeable(Compat_World world) {
		super(ParentSelector.NULL);
		super.initialize(new CompatReal_EntityAgeable(this, world.getReal()), null);
	}

	// When called from child
	protected Compat_EntityAgeable(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityAgeable(EntityAgeable original) {
		super(ParentSelector.NULL);
		super.initialize(null, original);
	}

	protected void initialize(CompatI_EntityAgeable thisReal, EntityAgeable original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityAgeable getReal() {
		return original == null ? thisReal.get() : original;
	}
}
