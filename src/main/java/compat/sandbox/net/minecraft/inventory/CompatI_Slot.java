package compat.sandbox.net.minecraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public interface CompatI_Slot {
	public Slot get();

	public ItemStack decrStackSizeSuper(int amount);

	public void onCraftingSuper(ItemStack stack, int amount);

	public ItemStack getStackSuper();

	public boolean isItemValidSuper(ItemStack stack);

	public void putStackSuper(ItemStack stack);

	public boolean getHasStackSuper();

	public void onSlotChangedSuper();

	public void onSlotChangeSuper(ItemStack stack1, ItemStack stack2);

	public ItemStack onTakeSuper(EntityPlayer player, ItemStack stack);

	public int get_yPos();

	public int get_slotNumber();

	public int get_xPos();

	public IInventory get_inventory();
}
