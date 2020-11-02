package compat.sandbox.net.minecraft.entity.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;

public interface CompatI_EntityAINearestAttackableTarget<T extends EntityLivingBase> extends CompatI_EntityAITarget {
	public EntityAINearestAttackableTarget<T> get();
}
