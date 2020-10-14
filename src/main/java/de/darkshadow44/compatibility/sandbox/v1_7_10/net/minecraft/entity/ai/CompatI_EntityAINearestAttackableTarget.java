package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;

public interface CompatI_EntityAINearestAttackableTarget<T extends EntityLivingBase> extends CompatI_EntityAITarget {
	public EntityAINearestAttackableTarget<T> get();
}
