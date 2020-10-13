package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraftforge.oredict;

import net.minecraftforge.oredict.RecipeSorter.Category;

@SuppressWarnings("deprecation")
public class Compat_RecipeSorter_Category {

	private static final Compat_RecipeSorter_Category SHAPELESS = new Compat_RecipeSorter_Category(Category.SHAPELESS);

	private Category original;

	public Compat_RecipeSorter_Category(Category original) {
		this.original = original;
	}

	public Category getReal() {
		return original;
	}

	public static Compat_RecipeSorter_Category Compat_get_SHAPELESS() {
		return SHAPELESS;
	}
}
