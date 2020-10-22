package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.item.crafting;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.item.crafting.Ingredient;

public class Compat_Ingredient {
	private Ingredient original;
	private CompatI_Ingredient thisReal;

	// When called from Mod
	public Compat_Ingredient() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Ingredient.class, this), null);
	}

	// When called from child
	protected Compat_Ingredient(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Ingredient(Ingredient original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_Ingredient thisReal, Ingredient original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public Ingredient getReal() {
		return original == null ? thisReal.get() : original;
	}
}
