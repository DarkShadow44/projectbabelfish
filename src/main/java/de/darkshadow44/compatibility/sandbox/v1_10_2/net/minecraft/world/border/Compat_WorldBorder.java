package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.world.border;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.math.Compat_BlockPos;
import net.minecraft.world.border.WorldBorder;

public class Compat_WorldBorder {

	private final WorldBorder original;

	public Compat_WorldBorder(WorldBorder original) {
		this.original = original;
	}

	public WorldBorder getReal() {
		return original;
	}

	public boolean Compat_func_177746_a(Compat_BlockPos pos) {
		return original.contains(pos.getReal());
	}
}
