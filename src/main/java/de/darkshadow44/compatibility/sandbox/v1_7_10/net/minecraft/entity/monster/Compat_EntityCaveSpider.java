package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.monster;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.monster.EntityCaveSpider;

public class Compat_EntityCaveSpider extends Compat_EntitySpider {
	private CompatI_EntityCaveSpider wrapper;

	// When called from Mod
	public Compat_EntityCaveSpider() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityCaveSpider.class, this));
	}

	// When called from child
	protected Compat_EntityCaveSpider(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityCaveSpider(EntityCaveSpider original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityCaveSpider.class, original));
	}

	protected void initialize(CompatI_EntityCaveSpider wrapper) {
		this.wrapper = wrapper;
	}

	public EntityCaveSpider getReal() {
		return wrapper.get();
	}
}
