package compat.sandbox.net.minecraft.entity.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIAvoidEntity;

public interface CompatI_EntityAIAvoidEntity<T extends Entity> extends CompatI_EntityAIBase {
	public EntityAIAvoidEntity<T> get();
}
