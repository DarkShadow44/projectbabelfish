package compat.sandbox.net.minecraftforge.oredict;

import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.item.Compat_ItemStack;
import net.minecraft.util.ResourceLocation;

public class Compat_ShapedOreRecipe {

	// When called from Mod
	public Compat_ShapedOreRecipe(Compat_ItemStack stack, Object[] objects) {
		ResourceLocation group = new ResourceLocation("dummy");
		Object[] objectsConverted = RecipeHelper.convertIngredientObjects(objects);
	}

	// When called from child
	protected Compat_ShapedOreRecipe(ParentSelector s) {

	}

	// When called from Minecraft
	public Compat_ShapedOreRecipe() {

	}


}
