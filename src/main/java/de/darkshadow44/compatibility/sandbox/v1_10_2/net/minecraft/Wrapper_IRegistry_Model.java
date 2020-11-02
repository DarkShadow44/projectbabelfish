package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.block.model.Compat_IBakedModel;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.block.model.Compat_ModelResourceLocation;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.block.model.Wrapper2_IBakedModel;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.registry.Compat_IRegistry;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.registry.IRegistry;

public class Wrapper_IRegistry_Model implements Compat_IRegistry<ModelResourceLocation, IBakedModel> {

	private final IRegistry<ModelResourceLocation, IBakedModel> original;

	public Wrapper_IRegistry_Model(IRegistry<ModelResourceLocation, IBakedModel> original) {
		this.original = original;
	}

	public IRegistry<ModelResourceLocation, IBakedModel> getReal() {
		return original;
	}

	@Override
	public void Compat_func_82595_a(Object key, Object value) {
		Compat_ModelResourceLocation location = (Compat_ModelResourceLocation) key;
		Compat_IBakedModel model = (Compat_IBakedModel) value;
		original.putObject(location.getReal(), Compat_IBakedModel.getReal(model));
	}

	@Override
	public Object Compat_func_82594_a(Object key) {
		Compat_ModelResourceLocation location = (Compat_ModelResourceLocation) key;
		IBakedModel model = (IBakedModel) original.getObject(location.getReal());
		if (model == null) {
			throw new RuntimeException();
		}
		return new Wrapper2_IBakedModel(model);
	}
}
