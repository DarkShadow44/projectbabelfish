package compat.sandbox.net.minecraft.item;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public interface CompatI_ItemArmor extends CompatI_Item {
	public ItemArmor get();

	public int get_damageReduceAmount();

	public String getArmorTextureSuper(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type);
}
