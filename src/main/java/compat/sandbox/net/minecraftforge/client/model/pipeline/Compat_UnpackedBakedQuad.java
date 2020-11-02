package compat.sandbox.net.minecraftforge.client.model.pipeline;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.client.renderer.block.model.Compat_BakedQuad;
import compat.sandbox.net.minecraft.client.renderer.texture.Compat_TextureAtlasSprite;
import compat.sandbox.net.minecraft.client.renderer.vertex.Compat_VertexFormat;
import compat.sandbox.net.minecraft.util.Compat_EnumFacing;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.client.model.pipeline.UnpackedBakedQuad;

public class Compat_UnpackedBakedQuad extends Compat_BakedQuad {
	private CompatI_UnpackedBakedQuad wrapper;

	// When called from Mod
	public Compat_UnpackedBakedQuad(float[][][] data, int tint, Compat_EnumFacing facing, Compat_TextureAtlasSprite sprite, boolean diffuseLighting, Compat_VertexFormat format) {
		super(ParentSelector.NULL);
		EnumFacing facing2 = facing == null ? null : facing.getReal();
		this.initialize(Factory.create(CtorPos.POS1, CompatI_UnpackedBakedQuad.class, this, data, tint, facing2, sprite.getReal(), diffuseLighting, format.getReal()));
	}

	// When called from child
	protected Compat_UnpackedBakedQuad(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_UnpackedBakedQuad(UnpackedBakedQuad original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_UnpackedBakedQuad.class, original));
	}

	protected void initialize(CompatI_UnpackedBakedQuad wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public UnpackedBakedQuad getReal() {
		return wrapper.get();
	}
}
