package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.oredict;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.registry.CompatI_IForgeRegistryEntry_Impl;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.ShapedOreRecipe;

public interface CompatI_ShapedOreRecipe extends CompatI_IForgeRegistryEntry_Impl<IRecipe> {
	public ShapedOreRecipe get();
}
