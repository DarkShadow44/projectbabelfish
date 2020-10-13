package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item.crafting;

import java.util.List;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item.Compat_ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.NonNullList;

public class Compat_ShapelessRecipes {
	private ShapelessRecipes original;
	private CompatI_ShapelessRecipes thisReal;

	// When called from Mod
	public Compat_ShapelessRecipes(Compat_ItemStack output, List<Compat_ItemStack> inputs) {
		String group = "compat"; // TODO
		NonNullList<Ingredient> ingredientsConverted = NonNullList.create();
		for (Compat_ItemStack stack : inputs) {
			Ingredient ing = Ingredient.fromStacks(stack.getReal()); // TODO ?
			ingredientsConverted.add(ing);
		}

		this.initialize(Factory.create(CtorPos.POS1, CompatI_ShapelessRecipes.class, this, group, output.getReal(), ingredientsConverted), null);
	}

	// When called from child
	protected Compat_ShapelessRecipes(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_ShapelessRecipes(ShapelessRecipes original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_ShapelessRecipes thisReal, ShapelessRecipes original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public ShapelessRecipes getReal() {
		return original == null ? thisReal.get() : original;
	}
}
