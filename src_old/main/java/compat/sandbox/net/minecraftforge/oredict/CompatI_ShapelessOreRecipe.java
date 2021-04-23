package compat.sandbox.net.minecraftforge.oredict;

import compat.sandbox.net.minecraftforge.fml.common.registry.CompatI_IForgeRegistryEntry_Impl;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public interface CompatI_ShapelessOreRecipe extends CompatI_IForgeRegistryEntry_Impl<IRecipe> {
	public ShapelessOreRecipe get();
}
