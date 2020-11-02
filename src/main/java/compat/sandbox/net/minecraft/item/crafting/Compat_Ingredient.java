package compat.sandbox.net.minecraft.item.crafting;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
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
