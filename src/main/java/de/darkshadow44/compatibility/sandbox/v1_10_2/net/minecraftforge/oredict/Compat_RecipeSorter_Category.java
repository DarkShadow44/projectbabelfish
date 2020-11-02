package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.oredict;

import net.minecraftforge.oredict.RecipeSorter.Category;

@SuppressWarnings("deprecation")
public enum Compat_RecipeSorter_Category {

	SHAPELESS(Category.SHAPELESS),
	SHAPED(Category.SHAPED);

	private final Category original;

	private Compat_RecipeSorter_Category(Category original) {
		this.original = original;
	}

	public Category getReal() {
		return original;
	}

	public static Compat_RecipeSorter_Category Compat_get_SHAPELESS() {
		return SHAPELESS;
	}
}
