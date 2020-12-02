package compat.core.model.variabletexture.block;

import java.util.function.Function;

import compat.core.CompatibilityMod;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.common.model.IModelState;

public class ModelBlockVariableTexture implements IModel {

	public static final ModelResourceLocation LOCATION = new ModelResourceLocation(new ResourceLocation(CompatibilityMod.MODID, "blockvariabletexture").toString());

	public static final IModel MODEL = new ModelBlockVariableTexture();

	public ModelBlockVariableTexture() {

	}

	@Override
	public IBakedModel bake(IModelState state, VertexFormat format, Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter) {
		return new BakedModelBlockVariableTexture(null, 0);
	}
}
