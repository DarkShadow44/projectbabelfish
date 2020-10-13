package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.monster;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.monster.EntitySpider;

public class Compat_EntitySpider extends Compat_EntityMob {
	private EntitySpider original;
	private CompatI_EntitySpider thisReal;

	// When called from Mod
	public Compat_EntitySpider() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntitySpider.class, this), null);
	}

	// When called from child
	protected Compat_EntitySpider(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntitySpider(EntitySpider original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntitySpider thisReal, EntitySpider original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntitySpider getReal() {
		return original == null ? thisReal.get() : original;
	}
}
