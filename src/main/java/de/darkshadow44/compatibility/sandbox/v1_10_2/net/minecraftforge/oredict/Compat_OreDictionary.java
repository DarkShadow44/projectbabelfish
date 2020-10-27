package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.oredict;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.item.Compat_ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class Compat_OreDictionary {
	public static int[] Compat_getOreIDs(Compat_ItemStack stack) {
		return OreDictionary.getOreIDs(stack.getReal());
	}

	public static String Compat_getOreName(int id) {
		return OreDictionary.getOreName(id);
	}
}
