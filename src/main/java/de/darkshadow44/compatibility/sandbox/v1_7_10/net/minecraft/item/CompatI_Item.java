package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.registries.IForgeRegistryEntry;

public interface CompatI_Item {
	public Item get();

	public Compat_Item getFake();

	public Item setMaxDamageSuper(int maxDamage);

	public Item setMaxStackSizeSuper(int maxStackSize);

	public Item setHasSubtypesSuper(boolean hasSubtypes);

	public Item setCreativeTabSuper(CreativeTabs real);

	public Item setUnlocalizedNameSuper(String unlocalizedName);

	public Item setNoRepairSuper();

	public Item setFull3DSuper();

	public Item setContainerItemSuper(Item containerItem);

	public IForgeRegistryEntry<Item> setRegistryNameSuper(String unlocalizedName);

	public void getSubItemsSuper(CreativeTabs tab, NonNullList<ItemStack> items);

	public String getItemStackDisplayNameSuper(ItemStack stack);

	public String getUnlocalizedNameSuper(ItemStack stack);

	public String getUnlocalizedNameSuper();
}
