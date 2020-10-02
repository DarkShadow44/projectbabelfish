package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import net.minecraft.block.BlockFence;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class Compat_BlockFence extends BlockFence {

	public Compat_BlockFence(Material materialIn, MapColor mapColorIn) {
		super(materialIn, mapColorIn);
	}

}
