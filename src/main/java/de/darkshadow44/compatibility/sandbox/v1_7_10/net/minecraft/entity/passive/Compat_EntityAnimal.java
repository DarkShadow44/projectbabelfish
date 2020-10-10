package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.passive;

import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.Compat_EntityAgeable;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.world.Compat_World;
import net.minecraft.entity.passive.EntityAnimal;

public class Compat_EntityAnimal extends Compat_EntityAgeable {
	private EntityAnimal original;
	private CompatI_EntityAnimal thisReal;

	// When called from Mod
	public Compat_EntityAnimal(Compat_World world) {
		super(ParentSelector.NULL);
		super.initialize(new CompatReal_EntityAnimal(this, world.getReal()), null);
	}

	// When called from child
	protected Compat_EntityAnimal(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityAnimal(EntityAnimal original) {
		super(ParentSelector.NULL);
		super.initialize(null, original);
	}

	protected void initialize(CompatI_EntityAnimal thisReal, EntityAnimal original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityAnimal getReal() {
		return original == null ? thisReal.get() : original;
	}
}
