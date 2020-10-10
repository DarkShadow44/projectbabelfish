package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import net.minecraft.block.BlockFence;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class CompatReal_BlockFence extends BlockFence implements CompatI_BlockFence {
	@SuppressWarnings("unused")
	private Compat_BlockFence thisFake;

	public CompatReal_BlockFence(Compat_BlockFence thisFake, Material material, MapColor color) {
		super(material, color);
		this.thisFake = thisFake;
	}

	@Override
	public BlockFence get() {
		return this;
	}
}
