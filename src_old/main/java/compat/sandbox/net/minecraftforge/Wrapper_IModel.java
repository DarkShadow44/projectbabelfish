package compat.sandbox.net.minecraftforge;

import com.google.common.base.Function;

import compat.sandbox.net.minecraft.client.renderer.block.model.Compat_IBakedModel;
import compat.sandbox.net.minecraft.client.renderer.block.model.Wrapper_IBakedModel;
import compat.sandbox.net.minecraft.client.renderer.texture.Compat_TextureAtlasSprite;
import compat.sandbox.net.minecraft.client.renderer.vertex.Compat_VertexFormat;
import compat.sandbox.net.minecraft.util.Compat_ResourceLocation;
import compat.sandbox.net.minecraftforge.client.model.Compat_IModel;
import compat.sandbox.net.minecraftforge.common.model.Compat_IModelState;
import compat.sandbox.net.minecraftforge.common.model.Wrapper_IModelState;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.common.model.IModelState;

public class Wrapper_IModel implements IModel {

	private final Compat_IModel fake;

	public Wrapper_IModel(Compat_IModel fake) {
		this.fake = fake;
	}

	@Override
	public IBakedModel bake(IModelState state, VertexFormat format, final java.util.function.Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter) {
		Function<Compat_ResourceLocation, Compat_TextureAtlasSprite> bakedTextureGetter2 = location -> new Compat_TextureAtlasSprite(bakedTextureGetter.apply(location.getReal()));

		Compat_IModelState state2 = new Wrapper_IModelState(state);
		Compat_VertexFormat format2 = new Compat_VertexFormat(format);
		Compat_IBakedModel model = fake.Compat_bake(state2, format2, bakedTextureGetter2);
		return new Wrapper_IBakedModel(model);
	}

}
