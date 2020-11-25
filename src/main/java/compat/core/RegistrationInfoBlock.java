package compat.core;

import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;

public class RegistrationInfoBlock {
	private final Block block;
	private final ResourceLocation location;

	public RegistrationInfoBlock(Block block, ResourceLocation location) {
		this.block = block;
		this.location = location;
	}

	public Block getBlock() {
		return block;
	}

	public ResourceLocation getLocation() {
		return location;
	}

}
