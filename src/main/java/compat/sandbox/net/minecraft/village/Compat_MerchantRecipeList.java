package compat.sandbox.net.minecraft.village;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.village.MerchantRecipeList;

public class Compat_MerchantRecipeList {
	private CompatI_MerchantRecipeList wrapper;

	// When called from Mod
	public Compat_MerchantRecipeList() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_MerchantRecipeList.class, this));
	}

	// When called from child
	protected Compat_MerchantRecipeList(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_MerchantRecipeList(MerchantRecipeList original) {
		this.initialize(Factory.createWrapper(CompatI_MerchantRecipeList.class, original));
	}

	protected void initialize(CompatI_MerchantRecipeList wrapper) {
		this.wrapper = wrapper;
	}

	public MerchantRecipeList getReal() {
		return wrapper.get();
	}
}
