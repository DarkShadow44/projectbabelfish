package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSeeds;

public class CompatReal_ItemSeeds extends ItemSeeds implements CompatI_ItemSeeds {
	@SuppressWarnings("unused")
	private Compat_ItemSeeds thisFake;

	public CompatReal_ItemSeeds(Compat_ItemSeeds thisFake, Block crops, Block soil) {
		super(crops, soil);
		this.thisFake = thisFake;
	}

	@Override
	public ItemSeeds get() {
		return this;
	}
}
