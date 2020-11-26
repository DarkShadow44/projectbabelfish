package compat.core.model.variabletexture;

import java.util.function.Function;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.google.common.collect.ImmutableList;

import compat.sandbox.net.minecraft.item.CompatI_Item;
import compat.sandbox.net.minecraft.item.Compat_Item;
import compat.sandbox.net.minecraft.util.Compat_IIcon;
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

		CompatI_Item itemI = (CompatI_Item) stack.getItem();
		Compat_Item item = itemI.getFake();
		Compat_IIcon icon = item.Compat_func_77617_a(stack.getItemDamage());

		if (icon == null) {
			return originalModel;
		}

		ResourceLocation loc = icon.getLocation();

		BakedModelItemVariableTexture original = (BakedModelItemVariableTexture) originalModel;

		IModel parent = new ModelItemVariableTexture(loc);
		Function<ResourceLocation, TextureAtlasSprite> textureGetter;
		textureGetter = location -> Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(location.toString());

		return parent.bake(original.state, original.format, textureGetter);
	}

}
