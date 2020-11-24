package compat.sandbox.net.minecraft.village;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.village.MerchantRecipe;

public class Compat_MerchantRecipe {
	private CompatI_MerchantRecipe wrapper;

	// When called from Mod
	public Compat_MerchantRecipe() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_MerchantRecipe.class, this));
	}

	// When called from child
	protected Compat_MerchantRecipe(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_MerchantRecipe(MerchantRecipe original) {
		this.initialize(Factory.createWrapper(CompatI_MerchantRecipe.class, original));
	}

	protected void initialize(CompatI_MerchantRecipe wrapper) {
		this.wrapper = wrapper;
	}

	public MerchantRecipe getReal() {
		return wrapper.get();
	}
}
