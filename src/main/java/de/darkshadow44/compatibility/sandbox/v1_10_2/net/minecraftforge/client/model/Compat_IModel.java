package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.client.model;


import com.google.common.base.Function;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.block.model.Compat_IBakedModel;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.vertex.Compat_VertexFormat;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.Compat_ResourceLocation;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.common.model.Compat_IModelState;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.texture.Compat_TextureAtlasSprite;

public interface Compat_IModel {
	Compat_IBakedModel Compat_bake(Compat_IModelState state2, Compat_VertexFormat format2, Function<Compat_ResourceLocation, Compat_TextureAtlasSprite> bakedTextureGetter2);
}
