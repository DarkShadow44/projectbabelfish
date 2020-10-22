package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.block.model;

import java.util.List;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.state.Compat_IBlockState;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.Compat_EnumFacing;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.texture.Compat_TextureAtlasSprite;

public interface Compat_IBakedModel {

	boolean isAmbientOcclusion();

	boolean isGui3d();

	boolean isBuiltInRenderer();

	Compat_ItemOverrideList getOverrides();

	Compat_TextureAtlasSprite getParticleTexture();

	List<Compat_BakedQuad> getQuads(Compat_IBlockState state, Compat_EnumFacing side, long rand);
}
