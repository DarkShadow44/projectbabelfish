package compat.sandbox.net.minecraftforge.client.model.pipeline;

import compat.sandbox.net.minecraft.client.renderer.texture.Compat_TextureAtlasSprite;
import compat.sandbox.net.minecraft.client.renderer.vertex.Compat_VertexFormat;
import compat.sandbox.net.minecraft.util.Compat_EnumFacing;

public interface Compat_IVertexConsumer {
	public Compat_VertexFormat Compat_getVertexFormat();

	public void Compat_setQuadTint(int tint);

	public void Compat_setQuadOrientation(Compat_EnumFacing orientation);

	public void Compat_setApplyDiffuseLighting(boolean diffuse);

	public void Compat_setTexture(Compat_TextureAtlasSprite texture);

	public void Compat_put(int element, float... data);

}
