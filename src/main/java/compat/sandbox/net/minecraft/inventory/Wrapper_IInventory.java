package compat.sandbox.net.minecraft.inventory;

import compat.sandbox.net.minecraft.entity.player.Compat_EntityPlayer;
import compat.sandbox.net.minecraft.item.Compat_ItemStack;
import compat.sandbox.net.minecraft.util.text.Compat_ITextComponent;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class Wrapper_IInventory implements Compat_IInventory {
	private final IInventory original;

	public Wrapper_IInventory(IInventory original) {
		this.original = original;
	}

	public IInventory getReal() {
		return original;
	}

	@Override
	public Compat_ITextComponent getDisplayName() {
		return Compat_ITextComponent.getFake(original.getDisplayName());
	}

	@Override
	public String Compat_func_145825_b() {
		return original.getName();
	}

	@Override
	public boolean Compat_func_145818_k_() {
		return original.hasCustomName();
	}

	@Override
	public void clear() {
		original.clear();
	}

	@Override
	public void Compat_func_70305_f(Compat_EntityPlayer player) {
		original.closeInventory(player.getReal());
	}

	@Override
	public Compat_ItemStack Compat_func_70298_a(int p1, int p2) {
		ItemStack result = original.decrStackSize(p1, p2);
		return Compat_ItemStack.getFake(result);
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
	public int Compat_func_70297_j_() {
		return original.getInventoryStackLimit();
	}

	@Override
	public int Compat_func_70302_i_() {
		return original.getSizeInventory();
	}

	@Override
	public Compat_ItemStack Compat_func_70301_a(int p1) {
		ItemStack result = original.getStackInSlot(p1);
		return Compat_ItemStack.getFake(result);
	}

	@Override
	public boolean isEmpty() {
		return original.isEmpty();
	}

	@Override
	public boolean Compat_func_94041_b(int p1, Compat_ItemStack stack) {
		return original.isItemValidForSlot(p1, Compat_ItemStack.getReal(stack));
	}

	@Override
	public boolean Compat_func_70300_a(Compat_EntityPlayer player) {
		return original.isUsableByPlayer(player.getReal());
	}

	@Override
	public void Compat_func_70296_d() {
		original.markDirty();
	}

	@Override
	public void Compat_func_70295_k_(Compat_EntityPlayer player) {
		original.openInventory(player.getReal());
	}

	@Override
	public Compat_ItemStack Compat_func_70304_b(int p1) {
		ItemStack result = original.removeStackFromSlot(p1);
		return Compat_ItemStack.getFake(result);
	}

	@Override
	public void setField(int p1, int p2) {
		original.setField(p1, p2);
	}

	@Override
	public void Compat_func_70299_a(int p1, Compat_ItemStack stack) {
		original.setInventorySlotContents(p1, Compat_ItemStack.getReal(stack));
	}
}
