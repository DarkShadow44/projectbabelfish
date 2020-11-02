package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block.material;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public interface CompatI_Material {
	public Material get();

	public Material setBurningSuper();

	public Material setNoPushMobilitySuper();

	public Material setReplaceableSuper();

	public MapColor getMaterialMapColorSuper();
}
