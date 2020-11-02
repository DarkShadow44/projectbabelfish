package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.creativetab;

import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item.Compat_Item;
import net.minecraft.creativetab.CreativeTabs;

public interface CompatI_CreativeTabs {
	public CreativeTabs get();

	public Compat_Item getIconItemStackSuper();
}
