package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;

public abstract class CompatReal_BlockSlab extends BlockSlab implements CompatI_BlockSlab {
	@SuppressWarnings("unused")
	private Compat_BlockSlab thisFake;

	public CompatReal_BlockSlab(Compat_BlockSlab thisFake, Material material) {
		super(material);
		this.thisFake = thisFake;
	}

	@Override
	public BlockSlab get() {
		return this;
	}
}
