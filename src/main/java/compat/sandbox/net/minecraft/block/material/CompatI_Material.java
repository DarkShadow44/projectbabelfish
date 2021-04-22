package compat.sandbox.net.minecraft.block.material;

import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public interface CompatI_Material {
	public Material get();

	public boolean isReplaceableSuper();

	public Material setBurningSuper();

	public Material setNoPushMobilitySuper();

	public Material setReplaceableSuper();

	public MaterialColor getMaterialMapColorSuper();

	public boolean isToolNotRequiredSuper();

	public boolean isOpaqueSuper();

	public boolean blocksMovementSuper();
}
