package compat.sandbox.net.minecraft.entity.item;

import compat.sandbox.net.minecraft.entity.CompatI_Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;

public interface CompatI_EntityItem extends CompatI_Entity {
	public EntityItem get();

	public void setDefaultPickupDelaySuper();

	public ItemStack getItemSuper();
}
