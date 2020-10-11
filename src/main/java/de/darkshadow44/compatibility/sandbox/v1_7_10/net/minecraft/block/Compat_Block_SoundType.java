package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import net.minecraft.block.SoundType;

public class Compat_Block_SoundType {
	private SoundType original;

	public Compat_Block_SoundType(SoundType original) {
		this.original = original;
	}

	public SoundType getReal() {
		return original;
	}
}