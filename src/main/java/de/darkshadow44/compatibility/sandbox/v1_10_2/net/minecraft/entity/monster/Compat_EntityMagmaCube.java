package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity.monster;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.world.Compat_World;
import net.minecraft.entity.monster.EntityMagmaCube;

public class Compat_EntityMagmaCube extends Compat_EntitySlime {
	private CompatI_EntityMagmaCube wrapper;

	// When called from Mod
	public Compat_EntityMagmaCube(Compat_World world) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityMagmaCube.class, this, world.getReal()));
	}

	// When called from child
	protected Compat_EntityMagmaCube(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityMagmaCube(EntityMagmaCube original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityMagmaCube.class, original));
	}

	protected void initialize(CompatI_EntityMagmaCube wrapper) {
		this.wrapper = wrapper;
	}

	public EntityMagmaCube getReal() {
		return wrapper.get();
	}
}
