package compat.sandbox.net.minecraft.block.material;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public interface CompatI_Material {
	public Material get();

	public boolean isReplaceableSuper();
	
	public Material setBurningSuper();

	public Material setNoPushMobilitySuper();

	public Material setReplaceableSuper();

	public MapColor getMaterialMapColorSuper();

	public boolean isToolNotRequiredSuper();
}
