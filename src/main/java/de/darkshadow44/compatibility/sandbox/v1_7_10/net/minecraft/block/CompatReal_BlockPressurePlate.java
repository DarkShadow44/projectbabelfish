package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.material.Material;

public class CompatReal_BlockPressurePlate extends BlockPressurePlate implements CompatI_BlockPressurePlate {
	@SuppressWarnings("unused")
	private Compat_BlockPressurePlate thisFake;

	public CompatReal_BlockPressurePlate(Compat_BlockPressurePlate thisFake, Material material, Sensitivity sensitivity) {
		super(material, sensitivity);
		this.thisFake = thisFake;
	}

	@Override
	public BlockPressurePlate get() {
		return this;
	}
}
