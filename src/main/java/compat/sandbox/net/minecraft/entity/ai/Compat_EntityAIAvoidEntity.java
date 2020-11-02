package compat.sandbox.net.minecraft.entity.ai;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
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
