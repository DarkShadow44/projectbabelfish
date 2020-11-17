package compat.sandbox.net.minecraft.client.renderer.block.model;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.client.renderer.texture.Compat_TextureAtlasSprite;
import compat.sandbox.net.minecraft.client.renderer.vertex.Compat_VertexFormat;
import compat.sandbox.net.minecraft.util.Compat_EnumFacing;
import compat.sandbox.net.minecraftforge.client.model.pipeline.Compat_IVertexConsumer;
import compat.sandbox.net.minecraftforge.client.model.pipeline.Wrapper_IVertexConsumer;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.EnumFacing;

public class Compat_BakedQuad {
	private CompatI_BakedQuad wrapper;

	// When called from Mod
	public Compat_BakedQuad() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BakedQuad.class, this));
	}

	// When called from Mod
	public Compat_BakedQuad(int[] p1, int p2, Compat_EnumFacing facing, Compat_TextureAtlasSprite texture, boolean p3, Compat_VertexFormat format) {
		this.initialize(Factory.create(CtorPos.POS2, CompatI_BakedQuad.class, this, p1, p2, facing.getReal(), texture.getReal(), p3, format.getReal()));
	}

	// When called from child
	protected Compat_BakedQuad(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_BakedQuad(BakedQuad original) {
		this.initialize(Factory.createWrapper(CompatI_BakedQuad.class, original));
	}

	protected void initialize(CompatI_BakedQuad wrapper) {
		this.wrapper = wrapper;
	}

	public BakedQuad getReal() {
		return wrapper.get();
	}

	public Compat_VertexFormat Compat_getFormat() {
		VertexFormat result = wrapper.getFormatSuper();
		return new Compat_VertexFormat(result);
	}

	public boolean Compat_func_178212_b() {
		return wrapper.hasTintIndexSuper();
	}

	public int Compat_func_178211_c() {
		return wrapper.getTintIndexSuper();
	}

	public Compat_EnumFacing Compat_func_178210_d() {
		EnumFacing result = wrapper.getFaceSuper();
		return Compat_EnumFacing.getFake(result);
	}

	public int[] Compat_func_178209_a() {
		return wrapper.getVertexDataSuper();
	}

	public Compat_TextureAtlasSprite Compat_func_187508_a() {
		return new Compat_TextureAtlasSprite(wrapper.getSpriteSuper());
	}

	public void Compat_pipe(Compat_IVertexConsumer consumer) {
		wrapper.pipeSuper(new Wrapper_IVertexConsumer(consumer));
	}

	public boolean Compat_shouldApplyDiffuseLighting() {
		return wrapper.shouldApplyDiffuseLightingSuper();
	}

	public static Compat_BakedQuad getFake(BakedQuad quad) {
		if (quad instanceof CompatI_BakedQuad) {
			return ((CompatI_BakedQuad) quad).getFake();
		}
		return new Compat_BakedQuad(quad);
	}
}
