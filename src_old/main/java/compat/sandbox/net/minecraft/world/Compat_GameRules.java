package compat.sandbox.net.minecraft.world;

import net.minecraft.world.GameRules;

public class Compat_GameRules {
	private final GameRules original;

	public Compat_GameRules(GameRules original) {
		this.original = original;
	}

	public boolean Compat_func_82766_b(String name) {
		return original.getBoolean(name);
	}
}
