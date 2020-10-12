package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.monster;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.world.Compat_World;
import net.minecraft.entity.monster.EntitySilverfish;

public class Compat_EntitySilverfish extends Compat_EntityMob {
	private EntitySilverfish original;
	private CompatI_EntitySilverfish thisReal;

	// When called from Mod
	public Compat_EntitySilverfish(Compat_World world) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntitySilverfish.class, this, world.getReal()), null);
	}

	// When called from child
	protected Compat_EntitySilverfish(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntitySilverfish(EntitySilverfish original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntitySilverfish thisReal, EntitySilverfish original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntitySilverfish getReal() {
		return original == null ? thisReal.get() : original;
	}
}
