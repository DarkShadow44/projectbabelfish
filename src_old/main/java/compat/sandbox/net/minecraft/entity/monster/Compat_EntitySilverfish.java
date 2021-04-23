package compat.sandbox.net.minecraft.entity.monster;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.world.Compat_World;
import net.minecraft.entity.monster.EntitySilverfish;

public class Compat_EntitySilverfish extends Compat_EntityMob {
	private CompatI_EntitySilverfish wrapper;

	// When called from Mod
	public Compat_EntitySilverfish(Compat_World world) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntitySilverfish.class, this, world.getReal()));
	}

	// When called from child
	protected Compat_EntitySilverfish(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntitySilverfish(EntitySilverfish original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntitySilverfish.class, original));
	}

	protected void initialize(CompatI_EntitySilverfish wrapper) {
		this.wrapper = wrapper;
	}

	public EntitySilverfish getReal() {
		return wrapper.get();
	}
}
