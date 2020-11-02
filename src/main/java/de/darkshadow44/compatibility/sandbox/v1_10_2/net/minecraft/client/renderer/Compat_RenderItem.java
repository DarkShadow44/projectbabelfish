package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.block.model.Compat_IBakedModel;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.block.model.Wrapper2_IBakedModel;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity.Compat_EntityLivingBase;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.item.Compat_ItemStack;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.world.Compat_World;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Compat_RenderItem {
	private CompatI_RenderItem wrapper;

	// When called from Mod
	public Compat_RenderItem() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_RenderItem.class, this));
	}

	// When called from child
	protected Compat_RenderItem(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_RenderItem(RenderItem original) {
		this.initialize(Factory.createWrapper(CompatI_RenderItem.class, original));
	}

	protected void initialize(CompatI_RenderItem wrapper) {
		this.wrapper = wrapper;
	}

	public RenderItem getReal() {
		return wrapper.get();
	}

	public Compat_IBakedModel Compat_func_184393_a(Compat_ItemStack stack, Compat_World world, Compat_EntityLivingBase entity) {
		ItemStack stack2 = stack == null ? null : stack.getReal();
		World world2 = world == null ? null : world.getReal();
		EntityLivingBase entity2 = entity == null ? null : entity.getReal();
		IBakedModel result = wrapper.getItemModelWithOverridesSuper(stack2, world2, entity2);
		return new Wrapper2_IBakedModel(result);
	}
}
