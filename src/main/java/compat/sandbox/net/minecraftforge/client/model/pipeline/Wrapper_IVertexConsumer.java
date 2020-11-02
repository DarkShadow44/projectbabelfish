package compat.sandbox.net.minecraftforge.client.model.pipeline;

import compat.sandbox.net.minecraft.client.renderer.texture.Compat_TextureAtlasSprite;
import compat.sandbox.net.minecraft.util.Compat_EnumFacing;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.client.model.pipeline.IVertexConsumer;

public class Wrapper_IVertexConsumer implements IVertexConsumer {

	private final Compat_IVertexConsumer fake;

	public Wrapper_IVertexConsumer(Compat_IVertexConsumer fake) {
		this.fake = fake;
	}

	@Override
	public VertexFormat getVertexFormat() {
		return fake.Compat_getVertexFormat().getReal();
	}

	@Override
	public void setQuadTint(int tint) {
		fake.Compat_setQuadTint(tint);
	}

	@Override
	public void setQuadOrientation(EnumFacing orientation) {
		fake.Compat_setQuadOrientation(Compat_EnumFacing.map_real_to_fake(orientation));
	}

	@Override
	public void setApplyDiffuseLighting(boolean diffuse) {
		fake.Compat_setApplyDiffuseLighting(diffuse);
	}

	@Override
	public void setTexture(TextureAtlasSprite texture) {
		fake.Compat_setTexture(new Compat_TextureAtlasSprite(texture));
	}

	@Override
	public void put(int element, float... data) {
		fake.Compat_put(element, data);
	}

}
