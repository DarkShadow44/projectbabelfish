package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge;

import java.util.function.Function;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.block.model.Compat_IBakedModel;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.block.model.Wrapper_IBakedModel;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.vertex.Compat_VertexFormat;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.Compat_ResourceLocation;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.client.model.Compat_IModel;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.common.model.Compat_IModelState;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.common.model.Wrapper_IModelState;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.texture.Compat_TextureAtlasSprite;
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
	public IBakedModel bake(IModelState state, VertexFormat format, final Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter) {
		Function<Compat_ResourceLocation, Compat_TextureAtlasSprite> bakedTextureGetter2 = location -> new Compat_TextureAtlasSprite(bakedTextureGetter.apply(location.getReal()));

		Compat_IModelState state2 = new Wrapper_IModelState(state);
		Compat_VertexFormat format2 = new Compat_VertexFormat(format);
		Compat_IBakedModel model = fake.bake(state2, format2, bakedTextureGetter2);
		return new Wrapper_IBakedModel(model);
	}

}
