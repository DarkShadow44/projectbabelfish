package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.event.entity.player;

import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;

public class Compat_PlayerInteractEvent_RightClickBlock {
	private final RightClickBlock original;

	public Compat_PlayerInteractEvent_RightClickBlock(RightClickBlock original) {
		this.original = original;
	}

	public RightClickBlock getReal() {
		return original;
	}
}
