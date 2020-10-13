package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.monster;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.monster.EntityCaveSpider;

public class Compat_EntityCaveSpider extends Compat_EntitySpider {
	private EntityCaveSpider original;
	private CompatI_EntityCaveSpider thisReal;

	// When called from Mod
	public Compat_EntityCaveSpider() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityCaveSpider.class, this), null);
	}

	// When called from child
	protected Compat_EntityCaveSpider(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityCaveSpider(EntityCaveSpider original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityCaveSpider thisReal, EntityCaveSpider original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityCaveSpider getReal() {
		return original == null ? thisReal.get() : original;
	}
}
