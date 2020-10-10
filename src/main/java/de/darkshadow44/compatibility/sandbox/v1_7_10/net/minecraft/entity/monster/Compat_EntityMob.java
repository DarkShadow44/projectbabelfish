package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.monster;

import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.Compat_EntityCreature;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.world.Compat_World;
import net.minecraft.entity.monster.EntityMob;

public class Compat_EntityMob extends Compat_EntityCreature {
	private EntityMob original;
	private CompatI_EntityMob thisReal;

	// When called from Mod
	public Compat_EntityMob(Compat_World world) {
		super(ParentSelector.NULL);
		super.initialize(new CompatReal_EntityMob(this, world.getReal()), null);
	}

	// When called from child
	protected Compat_EntityMob(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityMob(EntityMob original) {
		super(ParentSelector.NULL);
		super.initialize(null, original);
	}

	protected void initialize(CompatI_EntityMob thisReal, EntityMob original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityMob getReal() {
		return original == null ? thisReal.get() : original;
	}
}
