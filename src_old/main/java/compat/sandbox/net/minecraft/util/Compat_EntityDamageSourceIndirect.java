package compat.sandbox.net.minecraft.util;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.entity.Compat_Entity;
import net.minecraft.util.EntityDamageSourceIndirect;

public class Compat_EntityDamageSourceIndirect extends Compat_EntityDamageSource {
	private CompatI_EntityDamageSourceIndirect wrapper;

	// When called from Mod
	public Compat_EntityDamageSourceIndirect(String p1, Compat_Entity entity1, Compat_Entity entity2) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityDamageSourceIndirect.class, this, p1, entity1.getReal(), entity2.getReal()));
	}

	// When called from child
	protected Compat_EntityDamageSourceIndirect(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityDamageSourceIndirect(EntityDamageSourceIndirect original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityDamageSourceIndirect.class, original));
	}

	protected void initialize(CompatI_EntityDamageSourceIndirect wrapper) {
		this.wrapper = wrapper;
	}

	public EntityDamageSourceIndirect getReal() {
		return wrapper.get();
	}
}
