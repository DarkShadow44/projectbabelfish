package compat.sandbox.net.minecraft.client.renderer.block.model;

import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.client.model.pipeline.IVertexConsumer;

public interface CompatI_BakedQuad {
	public BakedQuad get();

	public VertexFormat getFormatSuper();

	public boolean hasTintIndexSuper();

	public int getTintIndexSuper();

	public EnumFacing getFaceSuper();

	public int[] getVertexDataSuper();

	public TextureAtlasSprite getSpriteSuper();

	public void pipeSuper(IVertexConsumer consumer);

	public boolean shouldApplyDiffuseLightingSuper();

	public Compat_BakedQuad getFake();
}
