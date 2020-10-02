package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item.crafting;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.NonNullList;

public class Compat_ShapelessRecipes extends ShapelessRecipes {

	public Compat_ShapelessRecipes(String group, ItemStack output, NonNullList<Ingredient> ingredients) {
		super(group, output, ingredients);
	}

}
