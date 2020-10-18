package de.darkshadow44.compatibility.core.model.variabletexture;

import javax.annotation.Nonnull;

import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IModel;

public class ModelLoaderItemVariableTexture implements ICustomModelLoader {
	public final static ModelLoaderItemVariableTexture INSTANCE = new ModelLoaderItemVariableTexture();

	@Override
	public boolean accepts(ResourceLocation modelLocation) {
		return modelLocation.equals(ModelItemVariableTexture.LOCATION);
	}

	@Nonnull
	@Override
	public IModel loadModel(@Nonnull ResourceLocation modelLocation) {
		return ModelItemVariableTexture.MODEL;
	}

	@Override
	public void onResourceManagerReload(@Nonnull IResourceManager resourceManager) {
		// Emtpy
	}
}
