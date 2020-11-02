package compat.sandbox.net.minecraft.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;

public interface CompatI_EntityLivingBase extends CompatI_Entity {
	public EntityLivingBase get();

	public ItemStack getHeldItemMainhandSuper();

	public ItemStack getHeldItemOffhandSuper();

	public Vec3d getLookVecSuper();
}
