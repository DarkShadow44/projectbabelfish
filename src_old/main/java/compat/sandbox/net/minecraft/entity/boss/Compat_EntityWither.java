package compat.sandbox.net.minecraft.entity.boss;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.entity.monster.Compat_EntityMob;
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
