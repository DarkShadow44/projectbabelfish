package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity.projectile;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.world.Compat_World;
import net.minecraft.entity.projectile.EntitySmallFireball;

public class Compat_EntitySmallFireball extends Compat_EntityFireball {
	private CompatI_EntitySmallFireball wrapper;

	// When called from Mod
	public Compat_EntitySmallFireball(Compat_World world) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntitySmallFireball.class, this, world.getReal()));
	}

	// When called from child
	protected Compat_EntitySmallFireball(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntitySmallFireball(EntitySmallFireball original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntitySmallFireball.class, original));
	}

	protected void initialize(CompatI_EntitySmallFireball wrapper) {
		this.wrapper = wrapper;
	}

	public EntitySmallFireball getReal() {
		return wrapper.get();
	}
}
