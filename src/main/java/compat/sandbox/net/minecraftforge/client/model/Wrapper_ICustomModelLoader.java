package compat.sandbox.net.minecraftforge.client.model;

import compat.sandbox.net.minecraft.client.resources.Wrapper_IResourceManager;
import compat.sandbox.net.minecraft.util.Compat_ResourceLocation;
import compat.sandbox.net.minecraftforge.Wrapper_IModel;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IModel;

public class Wrapper_ICustomModelLoader implements ICustomModelLoader {

	private final Compat_ICustomModelLoader fake;

	public Wrapper_ICustomModelLoader(Compat_ICustomModelLoader fake) {
		this.fake = fake;
	}

	@Override
	public void onResourceManagerReload(IResourceManager resourceManager) {
		fake.Compat_func_110549_a(new Wrapper_IResourceManager(resourceManager));
	}

	@Override
	public boolean accepts(ResourceLocation modelLocation) {
		return fake.Compat_accepts(new Compat_ResourceLocation(modelLocation));
	}

	@Override
	public IModel loadModel(ResourceLocation modelLocation) throws Exception {
		Compat_IModel model = fake.Compat_loadModel(new Compat_ResourceLocation(modelLocation));
		return new Wrapper_IModel(model);
	}

}
