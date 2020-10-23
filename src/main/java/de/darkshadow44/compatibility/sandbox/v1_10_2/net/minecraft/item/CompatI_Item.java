package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.item;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.registry.CompatI_IForgeRegistryEntry_Impl;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public interface CompatI_Item extends CompatI_IForgeRegistryEntry_Impl<Item> {
	public Item get();

	public Item setUnlocalizedNameSuper(String name);

	public Item setMaxStackSizeSuper(int size);

	public Item setMaxDamageSuper(int damage);

	public Item setCreativeTabSuper(CreativeTabs tab);

	public String getUnlocalizedNameSuper(ItemStack stack);

	public void getSubItemsSuper(CreativeTabs real, NonNullList<ItemStack> list);
}
