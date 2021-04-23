package compat.sandbox.net.minecraftforge.client.model.pipeline;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.client.model.pipeline.UnpackedBakedQuad;
import net.minecraftforge.client.model.pipeline.UnpackedBakedQuad.Builder;

public interface CompatI_UnpackedBakedQuad_Builder {
	public Builder get();

	public void setQuadTintSuper(int tint);

	public void setQuadOrientationSuper(EnumFacing facing);

	public VertexFormat getVertexFormatSuper();

	public void setApplyDiffuseLightingSuper(boolean diffuse);

	public void putSuper(int element, float[] data);

	public void setTextureSuper(TextureAtlasSprite texture);

	public UnpackedBakedQuad buildSuper();
}
