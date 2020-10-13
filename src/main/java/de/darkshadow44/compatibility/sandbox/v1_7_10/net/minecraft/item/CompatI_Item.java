package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public interface CompatI_Item {
	public Item get();

	public Item setMaxDamageSuper(int maxDamage);

	public Item setMaxStackSizeSuper(int maxStackSize);

	public Item setHasSubtypesSuper(boolean hasSubtypes);

	public Item setCreativeTabSuper(CreativeTabs real);

	public Item setUnlocalizedNameSuper(String unlocalizedName);

	public Item setNoRepairSuper();

	public Item setFull3DSuper();
}
