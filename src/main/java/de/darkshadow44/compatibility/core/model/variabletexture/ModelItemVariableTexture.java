package de.darkshadow44.compatibility.core.model.variabletexture;

import java.util.Collection;
import java.util.function.Function;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import de.darkshadow44.compatibility.core.CompatibilityMod;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ItemLayerModel;
import net.minecraftforge.common.model.IModelState;

public class ModelItemVariableTexture implements IModel {

	public static final ModelResourceLocation LOCATION = new ModelResourceLocation(new ResourceLocation(CompatibilityMod.MODID, "testitem").toString());

	public static final IModel MODEL = new ModelItemVariableTexture(new ResourceLocation(CompatibilityMod.MODID, "items/dummy"));

	private final ResourceLocation texture;

	public ModelItemVariableTexture(ResourceLocation texture) {
		this.texture = texture;
	}

	@Override
	public Collection<ResourceLocation> getTextures() {
		ImmutableSet.Builder<ResourceLocation> builder = ImmutableSet.builder();
		builder.add(texture);
		return builder.build();
	}

	@Override
	public IBakedModel bake(IModelState state, VertexFormat format, Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter) {
		IBakedModel model = (new ItemLayerModel(ImmutableList.of(texture)).bake(state, format, bakedTextureGetter));
		ImmutableList.Builder<BakedQuad> builder = ImmutableList.builder();
		builder.addAll(model.getQuads(null, null, 0));
		TextureAtlasSprite particleSprite = model.getParticleTexture();
		return new BakedModelItemVariableTexture(builder.build(), particleSprite, format, state);
	}
}
