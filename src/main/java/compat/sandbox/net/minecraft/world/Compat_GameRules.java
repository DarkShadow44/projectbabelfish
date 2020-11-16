package compat.sandbox.net.minecraft.world;

import net.minecraft.world.GameRules;

public class Compat_GameRules {
	@SuppressWarnings("unused")
	private final GameRules original;

	public Compat_GameRules(GameRules original) {
		this.original = original;
	}
}
