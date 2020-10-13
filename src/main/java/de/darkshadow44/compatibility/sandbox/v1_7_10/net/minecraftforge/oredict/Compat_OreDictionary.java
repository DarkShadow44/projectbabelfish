package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraftforge.oredict;

import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item.Compat_ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class Compat_OreDictionary {
	public static void Compat_registerOre(String name, Compat_ItemStack ore) {
		OreDictionary.registerOre(name, ore.getReal());
	}
}
