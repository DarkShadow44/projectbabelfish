package compat.core.model.variabletexture;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nonnull;

import compat.core.model.variabletexture.block.ModelBlockVariableTexture;
import compat.core.model.variabletexture.item.ModelItemVariableTexture;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IModel;

public class ModelLoaderVariableTexture implements ICustomModelLoader {
	public final static ModelLoaderVariableTexture INSTANCE = new ModelLoaderVariableTexture();

	private static final Map<ResourceLocation, IModel> map = new HashMap<>();

	static {
		map.put(ModelItemVariableTexture.LOCATION, ModelItemVariableTexture.MODEL);
		map.put(ModelBlockVariableTexture.LOCATION, ModelBlockVariableTexture.MODEL);
	}

	@Override
	public boolean accepts(ResourceLocation modelLocation) {
		return map.containsKey(modelLocation);
	}

	@Nonnull
	@Override
	public IModel loadModel(@Nonnull ResourceLocation modelLocation) {
		return map.get(modelLocation);
	}

	@Override
	public void onResourceManagerReload(@Nonnull IResourceManager resourceManager) {
		// Emtpy
	}
}
