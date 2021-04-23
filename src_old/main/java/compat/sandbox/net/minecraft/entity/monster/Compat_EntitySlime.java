package compat.sandbox.net.minecraft.entity.monster;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.entity.Compat_EntityLiving;
import compat.sandbox.net.minecraft.world.Compat_World;
import net.minecraft.entity.monster.EntitySlime;

public class Compat_EntitySlime extends Compat_EntityLiving {
	private CompatI_EntitySlime wrapper;

	// When called from Mod
	public Compat_EntitySlime(Compat_World world) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntitySlime.class, this, world.getReal()));
	}

	// When called from child
	protected Compat_EntitySlime(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntitySlime(EntitySlime original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntitySlime.class, original));
	}

	protected void initialize(CompatI_EntitySlime wrapper) {
		this.wrapper = wrapper;
	}

	public EntitySlime getReal() {
		return wrapper.get();
	}
}
