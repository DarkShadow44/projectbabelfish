package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.util;

import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.Compat_Entity;
import net.minecraft.util.EntityDamageSource;

public class Compat_EntityDamageSource extends Compat_DamageSource {
	private EntityDamageSource original;
	private CompatI_EntityDamageSource thisReal;

	// When called from Mod
	public Compat_EntityDamageSource(String p1, Compat_Entity entity) {
		super(ParentSelector.NULL);
		this.initialize(new CompatReal_EntityDamageSource(this, p1, entity.getReal()), null);
	}

	// When called from child
	protected Compat_EntityDamageSource(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityDamageSource(EntityDamageSource original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityDamageSource thisReal, EntityDamageSource original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityDamageSource getReal() {
		return original == null ? thisReal.get() : original;
	}
}
