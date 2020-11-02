package compat.sandbox.net.minecraftforge.client.model;

import compat.sandbox.net.minecraft.client.resources.Compat_IResourceManager;
import compat.sandbox.net.minecraft.util.Compat_ResourceLocation;

public interface Compat_ICustomModelLoader {

	public void Compat_func_110549_a(Compat_IResourceManager resourceManager);

	public boolean Compat_accepts(Compat_ResourceLocation location);

	public Compat_IModel Compat_loadModel(Compat_ResourceLocation location);
}
