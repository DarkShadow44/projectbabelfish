package compat.sandbox.net.minecraft.world;

import compat.sandbox.net.minecraft.entity.player.Compat_EntityPlayer;
import compat.sandbox.net.minecraft.entity.player.Compat_InventoryPlayer;
import compat.sandbox.net.minecraft.inventory.Compat_Container;
import compat.sandbox.net.minecraft.util.text.Compat_ITextComponent;
import net.minecraft.world.IInteractionObject;

public interface Compat_IInteractionObject {
	public IInteractionObject getReal();

	public String Compat_func_70005_c_();

	public boolean Compat_func_145818_k_();

	public Compat_ITextComponent Compat_func_145748_c_();

	public Compat_Container Compat_func_174876_a(Compat_InventoryPlayer inventory, Compat_EntityPlayer entity);

	public String Compat_func_174875_k();
}
