package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.ai;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIAvoidEntity;

public class Compat_EntityAIAvoidEntity<T extends Entity> extends Compat_EntityAIBase {
	private EntityAIAvoidEntity<T> original;
	private CompatI_EntityAIAvoidEntity<T> thisReal;

	// When called from Mod
	public Compat_EntityAIAvoidEntity() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityAIAvoidEntity.class, this), null);
	}

	// When called from child
	protected Compat_EntityAIAvoidEntity(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityAIAvoidEntity(EntityAIAvoidEntity<T> original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityAIAvoidEntity<T> thisReal, EntityAIAvoidEntity<T> original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityAIAvoidEntity<T> getReal() {
		return original == null ? thisReal.get() : original;
	}
}
