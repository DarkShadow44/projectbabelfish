package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.block.model;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.CompatI_ResourceLocation;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public interface CompatI_ModelResourceLocation extends CompatI_ResourceLocation {
	public ModelResourceLocation get();

	public String getVariantSuper();
}
