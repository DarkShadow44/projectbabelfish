package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.util;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.Compat_Entity;
import net.minecraft.util.EntityDamageSourceIndirect;

public class Compat_EntityDamageSourceIndirect extends Compat_EntityDamageSource {
	private EntityDamageSourceIndirect original;
	private CompatI_EntityDamageSourceIndirect thisReal;

	// When called from Mod
	public Compat_EntityDamageSourceIndirect(String p1, Compat_Entity entity1, Compat_Entity entity2) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, this, p1, entity1.getReal(), entity2.getReal()), null);
	}

	// When called from child
	protected Compat_EntityDamageSourceIndirect(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityDamageSourceIndirect(EntityDamageSourceIndirect original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityDamageSourceIndirect thisReal, EntityDamageSourceIndirect original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityDamageSourceIndirect getReal() {
		return original == null ? thisReal.get() : original;
	}
}
