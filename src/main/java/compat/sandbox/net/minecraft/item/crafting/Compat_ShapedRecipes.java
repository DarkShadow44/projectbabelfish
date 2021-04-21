package compat.sandbox.net.minecraft.item.crafting;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.item.Compat_ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.util.NonNullList;

public class Compat_ShapedRecipes {
	private CompatI_ShapedRecipes wrapper;

	// When called from Mod
	public Compat_ShapedRecipes(int width, int height, Compat_ItemStack[] ingredients, Compat_ItemStack output) {

		String group = "compat"; // TODO
		NonNullList<Ingredient> ingredientsConverted = NonNullList.create();
		for (Compat_ItemStack stack : ingredients) {
			Ingredient ing = Ingredient.fromStacks(stack.getReal()); // TODO ?
			ingredientsConverted.add(ing);
		}

		this.initialize(Factory.create(CtorPos.POS1, CompatI_ShapedRecipes.class, this, group, width, height, ingredientsConverted, output.getReal()));
	}

	// When called from child
	protected Compat_ShapedRecipes(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_ShapedRecipes(ShapedRecipe original) {
		this.initialize(Factory.createWrapper(CompatI_ShapedRecipes.class, original));
	}

	protected void initialize(CompatI_ShapedRecipes wrapper) {
		this.wrapper = wrapper;
	}

	public ShapedRecipe getReal() {
		return wrapper.get();
	}

	public Compat_ShapedRecipes() {
		// DUMMY, TODO: Remove
	}

	public Compat_ShapedRecipes Compat_func_92100_c() {
		// TODO
		return this;
	}
}
