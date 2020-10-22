package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.init;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.item.Compat_Item;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.item.Compat_ItemEmptyMap;
import net.minecraft.init.Items;

public class Compat_Items {

	private static final Compat_Item ENDER_EYE = new Compat_Item(Items.ENDER_EYE);
	private static final Compat_Item REDSTONE = new Compat_Item(Items.REDSTONE);
	private static final Compat_Item GLOWSTONE_DUST = new Compat_Item(Items.GLOWSTONE_DUST);
	private static final Compat_Item IRON_INGOT = new Compat_Item(Items.IRON_INGOT);
	private static final Compat_Item DYE = new Compat_Item(Items.DYE);
	private static final Compat_ItemEmptyMap MAP = new Compat_ItemEmptyMap(Items.MAP);

	public static Compat_Item Compat_get_field_151061_bv() {
		return ENDER_EYE;
	}

	public static Compat_Item Compat_get_field_151137_ax() {
		return REDSTONE;
	}

	public static Compat_Item Compat_get_field_151114_aO() {
		return GLOWSTONE_DUST;
	}

	public static Compat_Item Compat_get_field_151042_j() {
		return IRON_INGOT;
	}

	public static Compat_Item Compat_get_field_151100_aR() {
		return DYE;
	}

	public static Compat_ItemEmptyMap Compat_get_field_151148_bJ() {
		return MAP;
	}
}
