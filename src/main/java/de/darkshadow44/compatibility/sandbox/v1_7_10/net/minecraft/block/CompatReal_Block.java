package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class CompatReal_Block extends Block implements CompatI_Block {
	@SuppressWarnings("unused")
	private Compat_Block thisFake;

	public CompatReal_Block(Compat_Block thisFake, Material material) {
		super(material);
		this.thisFake = thisFake;
	}

	@Override
	public Block get() {
		return this;
	}
}
