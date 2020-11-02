package compat.sandbox.net.minecraft.client.renderer;

import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface CompatI_RenderItem {
	public RenderItem get();

	public IBakedModel getItemModelWithOverridesSuper(ItemStack stack, World world, EntityLivingBase entity);
}
