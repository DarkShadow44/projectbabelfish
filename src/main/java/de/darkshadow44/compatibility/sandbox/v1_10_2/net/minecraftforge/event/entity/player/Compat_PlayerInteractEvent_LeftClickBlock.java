package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.event.entity.player;

import net.minecraftforge.event.entity.player.PlayerInteractEvent.LeftClickBlock;

public class Compat_PlayerInteractEvent_LeftClickBlock {
	private final LeftClickBlock original;

	public Compat_PlayerInteractEvent_LeftClickBlock(LeftClickBlock original) {
		this.original = original;
	}

	public LeftClickBlock getReal() {
		return original;
	}
}
