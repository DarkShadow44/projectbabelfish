package compat.sandbox.net.minecraftforge.oredict;

@SuppressWarnings("deprecation")
public enum Compat_RecipeSorter_Category {

	SHAPELESS(),
	SHAPED();


	private Compat_RecipeSorter_Category() {

	}

	public static Compat_RecipeSorter_Category Compat_get_SHAPELESS() {
		return SHAPELESS;
	}
}
