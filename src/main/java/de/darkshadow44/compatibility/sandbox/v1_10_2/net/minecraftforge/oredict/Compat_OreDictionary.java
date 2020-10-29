package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.oredict;

import java.util.ArrayList;
import java.util.List;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.item.Compat_ItemStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.oredict.OreDictionary;

public class Compat_OreDictionary {
	public static int[] Compat_getOreIDs(Compat_ItemStack stack) {
		return OreDictionary.getOreIDs(stack.getReal());
	}

	public static String Compat_getOreName(int id) {
		return OreDictionary.getOreName(id);
	}

	public static List<Compat_ItemStack> Compat_getOres(String key) {
		NonNullList<ItemStack> result = OreDictionary.getOres(key);
		List<Compat_ItemStack> ret = new ArrayList<>();
		for (ItemStack stack : result) {
			ret.add(new Compat_ItemStack(stack));
		}
		return ret;
	}
}
