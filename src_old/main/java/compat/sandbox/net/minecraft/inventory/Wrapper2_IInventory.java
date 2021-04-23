package compat.sandbox.net.minecraft.inventory;

import compat.sandbox.net.minecraft.entity.player.Compat_EntityPlayer;
import compat.sandbox.net.minecraft.item.Compat_ItemStack;
import compat.sandbox.net.minecraft.util.text.Compat_ITextComponent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;

public class Wrapper2_IInventory implements IInventory {

	private final Compat_IInventory original;

	public Wrapper2_IInventory(Compat_IInventory original) {
		this.original = original;
	}

	public Compat_IInventory getFake() {
		return original;
	}

	@Override
	public ITextComponent getDisplayName() {
		return Compat_ITextComponent.getReal(original.getDisplayName());
	}

	@Override
	public String getName() {
		return original.Compat_func_145825_b();
	}

	@Override
	public boolean hasCustomName() {
		return original.Compat_func_145818_k_();
	}

	@Override
	public void clear() {
		original.clear();
	}

	@Override
	public void closeInventory(EntityPlayer player) {
		Compat_EntityPlayer playerFake = Compat_EntityPlayer.getFake(player);
		original.Compat_func_70305_f(playerFake);
	}

	@Override
	public ItemStack decrStackSize(int p1, int p2) {
		Compat_ItemStack result = original.Compat_func_70298_a(p1, p2);
		return Compat_ItemStack.getReal(result);
	}

	@Override
	public int getField(int p1) {
		return original.getField(p1);
	}

	@Override
	public int getFieldCount() {
		return original.getFieldCount();
	}

	@Override
	public int getInventoryStackLimit() {
		return original.Compat_func_70297_j_();
	}

	@Override
	public int getSizeInventory() {
		return original.Compat_func_70302_i_();
	}

	@Override
	public ItemStack getStackInSlot(int p1) {
		Compat_ItemStack result = original.Compat_func_70301_a(p1);
		return Compat_ItemStack.getReal(result);
	}

	@Override
	public boolean isEmpty() {
		return original.isEmpty();
	}

	@Override
	public boolean isItemValidForSlot(int p1, ItemStack stack) {
		return original.Compat_func_94041_b(p1, Compat_ItemStack.getFake(stack));
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer player) {
		return original.Compat_func_70300_a(Compat_EntityPlayer.getFake(player));
	}

	@Override
	public void markDirty() {
		original.Compat_func_70296_d();
	}

	@Override
	public void openInventory(EntityPlayer player) {
		original.Compat_func_70295_k_(Compat_EntityPlayer.getFake(player));
	}

	@Override
	public ItemStack removeStackFromSlot(int p1) {
		Compat_ItemStack result = original.Compat_func_70304_b(p1);
		return Compat_ItemStack.getReal(result);
	}

	@Override
	public void setField(int p1, int p2) {
		original.setField(p1, p2);
	}

	@Override
	public void setInventorySlotContents(int p1, ItemStack stack) {
		original.Compat_func_70299_a(p1, Compat_ItemStack.getFake(stack));
	}

}
