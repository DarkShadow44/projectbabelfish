package compat.sandbox.net.minecraft.inventory;

import compat.sandbox.net.minecraft.entity.player.Compat_EntityPlayer;
import compat.sandbox.net.minecraft.item.Compat_ItemStack;
import compat.sandbox.net.minecraft.util.text.Compat_ITextComponent;
import net.minecraft.inventory.IInventory;

public interface Compat_IInventory {
	public static Compat_IInventory getFake(IInventory real) {
		if (real instanceof Wrapper2_IInventory) {
			return ((Wrapper2_IInventory) real).getFake();
		}
		return new Wrapper_IInventory(real);
	}

	public static IInventory getReal(Compat_IInventory fake) {
		if (fake instanceof Wrapper_IInventory) {
			return ((Wrapper_IInventory) fake).getReal();
		}
		return new Wrapper2_IInventory(fake);
	}

	public Compat_ITextComponent getDisplayName();

	public String Compat_func_145825_b();

	public boolean Compat_func_145818_k_();

	public void clear();

	public void Compat_func_70305_f(Compat_EntityPlayer player);

	public Compat_ItemStack Compat_func_70298_a(int p1, int p2);

	public int getField(int p1);

	public int getFieldCount();

	public int Compat_func_70297_j_();

	public int Compat_func_70302_i_();

	public Compat_ItemStack Compat_func_70301_a(int p1);

	public boolean isEmpty();

	public boolean Compat_func_94041_b(int p1, Compat_ItemStack stack);

	public boolean Compat_func_70300_a(Compat_EntityPlayer player);

	public void Compat_func_70296_d();

	public void Compat_func_70295_k_(Compat_EntityPlayer player);

	public Compat_ItemStack Compat_func_70304_b(int p1);

	public void setField(int p1, int p2);

	public void Compat_func_70299_a(int p1, Compat_ItemStack stack);
}
