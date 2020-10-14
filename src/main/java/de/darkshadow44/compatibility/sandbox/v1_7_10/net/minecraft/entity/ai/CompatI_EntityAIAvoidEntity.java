package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIAvoidEntity;

public interface CompatI_EntityAIAvoidEntity<T extends Entity> extends CompatI_EntityAIBase {
	public EntityAIAvoidEntity<T> get();
}
