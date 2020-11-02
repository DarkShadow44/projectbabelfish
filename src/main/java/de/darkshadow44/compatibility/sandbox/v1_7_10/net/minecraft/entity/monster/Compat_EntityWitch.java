package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.monster;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.monster.EntityWitch;

public class Compat_EntityWitch extends Compat_EntityMob {
	private CompatI_EntityWitch wrapper;

	// When called from Mod
	public Compat_EntityWitch() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityWitch.class, this));
	}

	// When called from child
	protected Compat_EntityWitch(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityWitch(EntityWitch original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityWitch.class, original));
	}

	protected void initialize(CompatI_EntityWitch wrapper) {
		this.wrapper = wrapper;
	}

	public EntityWitch getReal() {
		return wrapper.get();
	}
}
