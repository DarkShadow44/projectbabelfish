package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.oredict;

import net.minecraftforge.oredict.RecipeSorter;

@SuppressWarnings("deprecation")
public class Compat_RecipeSorter {

	public static void Compat_register(String name, Class<?> recipe, Compat_RecipeSorter_Category category, String dependencies) {
		RecipeSorter.register(name, recipe, category.getReal(), dependencies); // TODO?
	}
}
