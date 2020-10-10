package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;

public abstract class CompatReal_BlockContainer extends BlockContainer implements CompatI_BlockContainer {
	@SuppressWarnings("unused")
	private Compat_BlockContainer thisFake;

	public CompatReal_BlockContainer(Compat_BlockContainer thisFake, Material material) {
		super(material);
		this.thisFake = thisFake;
	}

	@Override
	public BlockContainer get() {
		return this;
	}
}
