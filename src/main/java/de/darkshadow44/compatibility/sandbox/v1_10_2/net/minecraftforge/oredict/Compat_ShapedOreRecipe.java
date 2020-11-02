package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.oredict;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.item.Compat_ItemStack;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.registry.Compat_IForgeRegistryEntry_Impl;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class Compat_ShapedOreRecipe extends Compat_IForgeRegistryEntry_Impl<IRecipe> {
	private CompatI_ShapedOreRecipe wrapper;

	// When called from Mod
	public Compat_ShapedOreRecipe(Compat_ItemStack stack, Object[] objects) {
		super(ParentSelector.NULL);
		ResourceLocation group = new ResourceLocation("dummy");
		Object[] objectsConverted = RecipeHelper.convertIngredientObjects(objects);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ShapedOreRecipe.class, this, group, stack.getReal(), objectsConverted));
	}

	// When called from child
	protected Compat_ShapedOreRecipe(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ShapedOreRecipe(ShapedOreRecipe original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_ShapedOreRecipe.class, original));
	}

	protected void initialize(CompatI_ShapedOreRecipe wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public ShapedOreRecipe getReal() {
		return wrapper.get();
	}
}
