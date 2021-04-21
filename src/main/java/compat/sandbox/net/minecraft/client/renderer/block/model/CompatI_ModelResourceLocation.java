package compat.sandbox.net.minecraft.client.renderer.block.model;

import compat.sandbox.net.minecraft.util.CompatI_ResourceLocation;
import net.minecraft.client.renderer.model.ModelResourceLocation;

public interface CompatI_ModelResourceLocation extends CompatI_ResourceLocation {
	public ModelResourceLocation get();

	public String getVariantSuper();
}
