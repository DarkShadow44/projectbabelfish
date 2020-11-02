package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.client.model.pipeline;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.texture.Compat_TextureAtlasSprite;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.vertex.Compat_VertexFormat;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.Compat_EnumFacing;

public interface Compat_IVertexConsumer {
	public Compat_VertexFormat Compat_getVertexFormat();

	public void Compat_setQuadTint(int tint);

	public void Compat_setQuadOrientation(Compat_EnumFacing orientation);

	public void Compat_setApplyDiffuseLighting(boolean diffuse);

	public void Compat_setTexture(Compat_TextureAtlasSprite texture);

	public void Compat_put(int element, float... data);

}
