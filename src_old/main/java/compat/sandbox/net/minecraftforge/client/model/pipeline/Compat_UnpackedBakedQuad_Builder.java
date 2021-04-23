package compat.sandbox.net.minecraftforge.client.model.pipeline;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.client.renderer.texture.Compat_TextureAtlasSprite;
import compat.sandbox.net.minecraft.client.renderer.vertex.Compat_VertexFormat;
import compat.sandbox.net.minecraft.util.Compat_EnumFacing;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.client.model.pipeline.UnpackedBakedQuad;
import net.minecraftforge.client.model.pipeline.UnpackedBakedQuad.Builder;

public class Compat_UnpackedBakedQuad_Builder implements Compat_IVertexConsumer {
	private CompatI_UnpackedBakedQuad_Builder wrapper;

	// When called from Mod
	public Compat_UnpackedBakedQuad_Builder(Compat_VertexFormat format) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_UnpackedBakedQuad_Builder.class, this, format.getReal()));
	}

	// When called from child
	protected Compat_UnpackedBakedQuad_Builder(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_UnpackedBakedQuad_Builder(Builder original) {
		this.initialize(Factory.createWrapper(CompatI_UnpackedBakedQuad_Builder.class, original));
	}

	protected void initialize(CompatI_UnpackedBakedQuad_Builder wrapper) {
		this.wrapper = wrapper;
	}

	public Builder getReal() {
		return wrapper.get();
	}

	public void Compat_setQuadTint(int tint) {
		wrapper.setQuadTintSuper(tint);
	}

	public void Compat_setQuadOrientation(Compat_EnumFacing facing) {
		EnumFacing facing2 = facing == null ? null : facing.getReal();
		wrapper.setQuadOrientationSuper(facing2);
	}

	@Override
	public Compat_VertexFormat Compat_getVertexFormat() {
		VertexFormat result = wrapper.getVertexFormatSuper();
		return new Compat_VertexFormat(result);
	}

	@Override
	public void Compat_setApplyDiffuseLighting(boolean diffuse) {
		wrapper.setApplyDiffuseLightingSuper(diffuse);
	}

	@Override
	public void Compat_setTexture(Compat_TextureAtlasSprite texture) {
		wrapper.setTextureSuper(texture.getReal());
	}

	@Override
	public void Compat_put(int element, float... data) {
		wrapper.putSuper(element, data);
	}

	public Compat_UnpackedBakedQuad Compat_build() {
		UnpackedBakedQuad result = wrapper.buildSuper();
		return new Compat_UnpackedBakedQuad(result);
	}
}
