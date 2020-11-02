package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.item.crafting;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.item.crafting.Ingredient;

public class Compat_Ingredient {
	private CompatI_Ingredient wrapper;

	// When called from Mod
	public Compat_Ingredient() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Ingredient.class, this));
	}

	// When called from child
	protected Compat_Ingredient(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Ingredient(Ingredient original) {
		this.initialize(Factory.createWrapper(CompatI_Ingredient.class, original));
	}

	protected void initialize(CompatI_Ingredient wrapper) {
		this.wrapper = wrapper;
	}

	public Ingredient getReal() {
		return wrapper.get();
	}
}
