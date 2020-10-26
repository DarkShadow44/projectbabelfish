package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public interface CompatI_EntityLivingBase extends CompatI_Entity {
	public EntityLivingBase get();

	public ItemStack getHeldItemMainhandSuper();

	public ItemStack getHeldItemOffhandSuper();
}
