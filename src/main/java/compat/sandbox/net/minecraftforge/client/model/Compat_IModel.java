package compat.sandbox.net.minecraftforge.client.model;

import com.google.common.base.Function;

import compat.sandbox.net.minecraft.client.renderer.block.model.Compat_IBakedModel;
import compat.sandbox.net.minecraft.client.renderer.texture.Compat_TextureAtlasSprite;
import compat.sandbox.net.minecraft.client.renderer.vertex.Compat_VertexFormat;
import compat.sandbox.net.minecraft.util.Compat_ResourceLocation;
import compat.sandbox.net.minecraftforge.common.model.Compat_IModelState;

public interface Compat_IModel {
	Compat_IBakedModel Compat_bake(Compat_IModelState state2, Compat_VertexFormat format2, Function<Compat_ResourceLocation, Compat_TextureAtlasSprite> bakedTextureGetter2);
}
