package de.darkshadow44.compatibility.core;

import net.minecraft.block.Block;

public class RegistrationInfoBlock {
	private Block block;
	private String name;

	public RegistrationInfoBlock(Block block, String name) {
		this.block = block;
		this.name = name;
	}

	public Block getBlock() {
		return block;
	}

	public String getName() {
		return name;
	}

}
