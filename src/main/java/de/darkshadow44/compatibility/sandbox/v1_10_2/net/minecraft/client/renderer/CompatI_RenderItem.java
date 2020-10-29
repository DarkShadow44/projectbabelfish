package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer;

import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface CompatI_RenderItem {
	public RenderItem get();

	public IBakedModel getItemModelWithOverridesSuper(ItemStack stack, World world, EntityLivingBase entity);
}
