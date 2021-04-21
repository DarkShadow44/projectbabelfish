package compat.sandbox.net.minecraft.client.renderer.block.model;

import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ModelManager;

public class Compat_ModelManager {

	private final ModelManager original;

	public Compat_ModelManager(ModelManager original) {
		this.original = original;
	}

	public ModelManager getReal() {
		return original;
	}

	public Compat_IBakedModel Compat_func_174953_a(Compat_ModelResourceLocation location) {
		IBakedModel ret = original.getModel(location.getReal());
		return new Wrapper2_IBakedModel(ret);
	}
}
