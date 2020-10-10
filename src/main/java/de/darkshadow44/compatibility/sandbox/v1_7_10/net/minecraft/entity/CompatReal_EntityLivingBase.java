package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHandSide;
import net.minecraft.world.World;

public class CompatReal_EntityLivingBase extends EntityLivingBase implements CompatI_EntityLivingBase {
	@SuppressWarnings("unused")
	private Compat_EntityLivingBase thisFake;

	public CompatReal_EntityLivingBase(Compat_EntityLivingBase thisFake, World world) {
		super(world);
		this.thisFake = thisFake;
	}

	@Override
	public EntityLivingBase get() {
		return this;
	}

	@Override
	public Iterable<ItemStack> getArmorInventoryList() {
		// TODO
		return null;
	}

	@Override
	public ItemStack getItemStackFromSlot(EntityEquipmentSlot slotIn) {
		// TODO
		return null;
	}

	@Override
	public void setItemStackToSlot(EntityEquipmentSlot slotIn, ItemStack stack) {
		// TODO
	}

	@Override
	public EnumHandSide getPrimaryHand() {
		// TODO
		return null;
	}
}
