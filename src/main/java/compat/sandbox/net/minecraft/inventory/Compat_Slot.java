package compat.sandbox.net.minecraft.inventory;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.entity.player.Compat_EntityPlayer;
import compat.sandbox.net.minecraft.item.Compat_ItemStack;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class Compat_Slot {
	private CompatI_Slot wrapper;

	// When called from Mod
	public Compat_Slot(Compat_IInventory inventory, int index, int xPosition, int yPosition) {
		IInventory inventoryReal = new Wrapper2_IInventory(inventory);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Slot.class, this, inventoryReal, index, xPosition, yPosition));
	}

	// When called from child
	protected Compat_Slot(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Slot(Slot original) {
		this.initialize(Factory.createWrapper(CompatI_Slot.class, original));
	}

	protected void initialize(CompatI_Slot wrapper) {
		this.wrapper = wrapper;
	}

	public Slot getReal() {
		return wrapper.get();
	}

	public Compat_ItemStack Compat_func_75209_a(int amount) {
		ItemStack result = wrapper.decrStackSizeSuper(amount);
		return Compat_ItemStack.getFake(result);
	}

	public void Compat_func_75210_a(Compat_ItemStack stack, int amount) {
		wrapper.onCraftingSuper(stack.getReal(), amount);
	}

	public Compat_ItemStack Compat_func_75211_c() {
		ItemStack result = wrapper.getStackSuper();
		return Compat_ItemStack.getFake(result);
	}

	public boolean Compat_func_75214_a(Compat_ItemStack stack) {
		return wrapper.isItemValidSuper(stack.getReal());
	}

	public void Compat_func_75215_d(Compat_ItemStack stack) {
		wrapper.putStackSuper(stack.getReal());
	}

	public boolean Compat_func_75216_d() {
		return wrapper.getHasStackSuper();
	}

	public void Compat_func_75218_e() {
		wrapper.onSlotChangedSuper();
	}

	public void Compat_func_75220_a(Compat_ItemStack stack1, Compat_ItemStack stack2) {
		wrapper.onSlotChangeSuper(stack1.getReal(), stack2.getReal());
	}

	public void Compat_func_82870_a(Compat_EntityPlayer player, Compat_ItemStack stack) {
		wrapper.onTakeSuper(player.getReal(), stack.getReal());
	}

	public int Compat_get_field_75221_f() {
		return wrapper.get_yPos();
	}

	public int Compat_get_field_75222_d() {
		return wrapper.get_slotNumber();
	}

	public int Compat_get_field_75223_e() {
		return wrapper.get_xPos();
	}

	public Compat_IInventory Compat_get_field_75224_c() {
		IInventory inventory = wrapper.get_inventory();
		return Compat_IInventory.getFake(inventory);
	}
}
