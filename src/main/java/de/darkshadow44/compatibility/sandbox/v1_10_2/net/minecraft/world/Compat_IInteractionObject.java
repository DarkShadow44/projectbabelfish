package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.world;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity.player.Compat_EntityPlayer;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity.player.Compat_InventoryPlayer;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.inventory.Compat_Container;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.text.Compat_ITextComponent;

public interface Compat_IInteractionObject {
	public String Compat_func_70005_c_();

	public boolean Compat_func_145818_k_();

	public Compat_ITextComponent func_145748_c_();

	public Compat_Container Compat_func_174876_a(Compat_InventoryPlayer inventory, Compat_EntityPlayer entity);

	public String Compat_func_174875_k();
}
