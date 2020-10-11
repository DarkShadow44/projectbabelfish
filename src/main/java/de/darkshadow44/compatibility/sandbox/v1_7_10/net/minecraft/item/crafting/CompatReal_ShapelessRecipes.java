package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item.crafting;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.NonNullList;

public class CompatReal_ShapelessRecipes extends ShapelessRecipes implements CompatI_ShapelessRecipes {
	@SuppressWarnings("unused")
	private Compat_ShapelessRecipes thisFake;

	public CompatReal_ShapelessRecipes(Compat_ShapelessRecipes thisFake, String group, ItemStack output, NonNullList<Ingredient> ingredients) {
		super(group, output, ingredients);
		this.thisFake = thisFake;
	}

	@Override
	public ShapelessRecipes get() {
		return this;
	}
}
