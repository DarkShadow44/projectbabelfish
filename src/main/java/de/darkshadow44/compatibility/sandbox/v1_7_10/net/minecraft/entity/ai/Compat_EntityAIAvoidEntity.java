package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.ai;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIAvoidEntity;

public class Compat_EntityAIAvoidEntity<T extends Entity> extends Compat_EntityAIBase {
	private CompatI_EntityAIAvoidEntity<T> wrapper;

	// When called from Mod
	public Compat_EntityAIAvoidEntity() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityAIAvoidEntity.class, this));
	}

	// When called from child
	protected Compat_EntityAIAvoidEntity(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityAIAvoidEntity(EntityAIAvoidEntity<T> original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityAIAvoidEntity.class, original));
	}

	protected void initialize(CompatI_EntityAIAvoidEntity<T> wrapper) {
		this.wrapper = wrapper;
	}

	public EntityAIAvoidEntity<T> getReal() {
		return wrapper.get();
	}
}
