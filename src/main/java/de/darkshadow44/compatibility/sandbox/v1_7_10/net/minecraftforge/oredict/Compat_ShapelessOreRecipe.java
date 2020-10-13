package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraftforge.oredict;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item.Compat_ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class Compat_ShapelessOreRecipe {
	private ShapelessOreRecipe original;
	private CompatI_ShapelessOreRecipe thisReal;

	// When called from Mod
	public Compat_ShapelessOreRecipe(Compat_ItemStack stack, Object[] objects) {
		ResourceLocation group = new ResourceLocation("dummy"); // TODO
		// TODO transform "objects"
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ShapelessOreRecipe.class, this, group, stack.getReal(), new Object[0]), null);
	}

	// When called from child
	protected Compat_ShapelessOreRecipe(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_ShapelessOreRecipe(ShapelessOreRecipe original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_ShapelessOreRecipe thisReal, ShapelessOreRecipe original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public ShapelessOreRecipe getReal() {
		return original == null ? thisReal.get() : original;
	}
}
