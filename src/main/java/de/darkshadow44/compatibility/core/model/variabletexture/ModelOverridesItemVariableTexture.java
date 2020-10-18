package de.darkshadow44.compatibility.core.model.variabletexture;

import java.util.function.Function;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.google.common.collect.ImmutableList;

import de.darkshadow44.compatibility.core.CompatibilityMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.IModel;

public class ModelOverridesItemVariableTexture extends ItemOverrideList {

	public static final ModelOverridesItemVariableTexture INSTANCE = new ModelOverridesItemVariableTexture();

	public ModelOverridesItemVariableTexture() {
		super(ImmutableList.of());
	}

	@Override
	public IBakedModel handleItemState(@Nonnull IBakedModel originalModel, ItemStack stack, @Nullable World world, @Nullable EntityLivingBase entity) {
		int damage = stack.getItemDamage();
		ResourceLocation loc = new ResourceLocation(CompatibilityMod.MODID, "items/damage" + damage);

		BakedModelItemVariableTexture original = (BakedModelItemVariableTexture) originalModel;

		IModel parent = new ModelItemVariableTexture(loc);
		Function<ResourceLocation, TextureAtlasSprite> textureGetter;
		textureGetter = location -> Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(location.toString());

		return parent.bake(original.state, original.format, textureGetter);
	}

}
