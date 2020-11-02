package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity.boss;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity.monster.Compat_EntityMob;
import net.minecraft.entity.boss.EntityWither;

public class Compat_EntityWither extends Compat_EntityMob {
	private CompatI_EntityWither wrapper;

	// When called from Mod
	public Compat_EntityWither() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityWither.class, this));
	}

	// When called from child
	protected Compat_EntityWither(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityWither(EntityWither original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityWither.class, original));
	}

	protected void initialize(CompatI_EntityWither wrapper) {
		this.wrapper = wrapper;
	}

	public EntityWither getReal() {
		return wrapper.get();
	}
}
