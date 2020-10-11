package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.projectile;

import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.Compat_Entity;
import net.minecraft.entity.projectile.EntityFireball;

public class Compat_EntityFireball extends Compat_Entity {
	private EntityFireball original;
	private CompatI_EntityFireball thisReal;

	// When called from child
	protected Compat_EntityFireball(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityFireball(EntityFireball original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityFireball thisReal, EntityFireball original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityFireball getReal() {
		return original == null ? thisReal.get() : original;
	}
}
