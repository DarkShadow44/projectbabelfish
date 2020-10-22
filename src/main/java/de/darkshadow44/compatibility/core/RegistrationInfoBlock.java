package de.darkshadow44.compatibility.core;

import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;

public class RegistrationInfoBlock {
	private Block block;
	private String name;
	private ResourceLocation location;

	public RegistrationInfoBlock(Block block, String name, ResourceLocation location) {
		this.block = block;
		this.name = name;
		this.location = location;
	}

	public Block getBlock() {
		return block;
	}

	public String getName() {
		return name;
	}

	public ResourceLocation getLocation() {
		return location;
	}

}
