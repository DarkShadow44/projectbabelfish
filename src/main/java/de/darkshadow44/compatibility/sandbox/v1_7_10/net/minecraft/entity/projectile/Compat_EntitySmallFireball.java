package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.projectile;

import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.world.Compat_World;
import net.minecraft.entity.projectile.EntitySmallFireball;

public class Compat_EntitySmallFireball extends Compat_EntityFireball {
	private EntitySmallFireball original;
	private CompatI_EntitySmallFireball thisReal;

	// When called from Mod
	public Compat_EntitySmallFireball(Compat_World world) {
		super(ParentSelector.NULL);
		super.initialize(new CompatReal_EntitySmallFireball(this, world.getReal()), null);
	}

	// When called from child
	protected Compat_EntitySmallFireball(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntitySmallFireball(EntitySmallFireball original) {
		super(ParentSelector.NULL);
		super.initialize(null, original);
	}

	protected void initialize(CompatI_EntitySmallFireball thisReal, EntitySmallFireball original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntitySmallFireball getReal() {
		return original == null ? thisReal.get() : original;
	}
}
