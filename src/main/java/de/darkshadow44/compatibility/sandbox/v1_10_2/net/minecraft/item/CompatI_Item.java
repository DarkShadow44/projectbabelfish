package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistryEntry;

public interface CompatI_Item {
	public Item get();

	public Item setUnlocalizedNameSuper(String name);

	public Item setMaxStackSizeSuper(int size);

	public Item setMaxDamageSuper(int damage);

	public Item setCreativeTabSuper(CreativeTabs tab);

	public IForgeRegistryEntry<?> setRegistryNameSuper(String name);
}
