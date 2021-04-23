package compat.sandbox.net.minecraft.util;

import compat.sandbox.net.minecraft.item.Compat_Item;
import net.minecraft.util.CooldownTracker;

public class Compat_CooldownTracker {

	private final CooldownTracker original;

	public Compat_CooldownTracker(CooldownTracker original) {
		this.original = original;
	}

	public void Compat_func_185142_b(Compat_Item item) {
		original.removeCooldown(item.getReal());
	}

}
