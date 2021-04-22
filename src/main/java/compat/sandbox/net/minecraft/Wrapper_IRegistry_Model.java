package compat.sandbox.net.minecraft;

import compat.sandbox.net.minecraft.client.renderer.block.model.Compat_IBakedModel;
import compat.sandbox.net.minecraft.client.renderer.block.model.Compat_ModelResourceLocation;
import compat.sandbox.net.minecraft.client.renderer.block.model.Wrapper2_IBakedModel;
import compat.sandbox.net.minecraft.util.registry.Compat_IRegistry;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.util.registry.IRegistry;

public class Wrapper_IRegistry_Model implements Compat_IRegistry<ModelResourceLocation, IBakedModel> {

	private final IRegistry<IBakedModel> original;

	public Wrapper_IRegistry_Model(IRegistry<IBakedModel> original) {
		this.original = original;
	}

	public IRegistry<IBakedModel> getReal() {
		return original;
	}

	@Override
	public void Compat_func_82595_a(Object key, Object value) {
		Compat_ModelResourceLocation location = (Compat_ModelResourceLocation) key;
		Compat_IBakedModel model = (Compat_IBakedModel) value;
		original.put(location.getReal(), Compat_IBakedModel.getReal(model));
	}

	@Override
	public Object Compat_func_82594_a(Object key) {
		Compat_ModelResourceLocation location = (Compat_ModelResourceLocation) key;
		IBakedModel model = (IBakedModel) original.get(location.getReal());
		if (model == null) {
			throw new RuntimeException();
		}
		return new Wrapper2_IBakedModel(model);
	}
}
