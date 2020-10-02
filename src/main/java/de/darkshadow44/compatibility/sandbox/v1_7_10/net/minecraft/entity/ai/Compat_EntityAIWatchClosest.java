package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIWatchClosest;

public class Compat_EntityAIWatchClosest extends EntityAIWatchClosest {

	public Compat_EntityAIWatchClosest(EntityLiving p_i1631_1_, Class<? extends Entity> p_i1631_2_, float p_i1631_3_) {
		super(p_i1631_1_, p_i1631_2_, p_i1631_3_);
	}

}
