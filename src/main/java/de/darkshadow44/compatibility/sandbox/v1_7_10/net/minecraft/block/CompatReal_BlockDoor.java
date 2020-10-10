package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;

public class CompatReal_BlockDoor extends BlockDoor implements CompatI_BlockDoor {
	@SuppressWarnings("unused")
	private Compat_BlockDoor thisFake;

	public CompatReal_BlockDoor(Compat_BlockDoor thisFake, Material material) {
		super(material);
		this.thisFake = thisFake;
	}

	@Override
	public BlockDoor get() {
		return this;
	}
}
