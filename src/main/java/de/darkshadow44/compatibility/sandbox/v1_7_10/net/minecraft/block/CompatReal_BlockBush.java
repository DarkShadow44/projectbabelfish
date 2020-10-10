package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;

public class CompatReal_BlockBush extends BlockBush implements CompatI_BlockBush {
	@SuppressWarnings("unused")
	private Compat_BlockBush thisFake;

	public CompatReal_BlockBush(Compat_BlockBush thisFake) {
		super();
		this.thisFake = thisFake;
	}
	
	public CompatReal_BlockBush(Compat_BlockBush thisFake, Material material) {
		super(material);
		this.thisFake = thisFake;
	}

	@Override
	public BlockBush get() {
		return this;
	}
}
