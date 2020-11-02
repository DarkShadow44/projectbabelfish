package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity.monster;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.monster.EntitySpider;

public class Compat_EntitySpider extends Compat_EntityMob {
	private CompatI_EntitySpider wrapper;

	// When called from Mod
	public Compat_EntitySpider() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntitySpider.class, this));
	}

	// When called from child
	protected Compat_EntitySpider(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntitySpider(EntitySpider original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntitySpider.class, original));
	}

	protected void initialize(CompatI_EntitySpider wrapper) {
		this.wrapper = wrapper;
	}

	public EntitySpider getReal() {
		return wrapper.get();
	}
}
