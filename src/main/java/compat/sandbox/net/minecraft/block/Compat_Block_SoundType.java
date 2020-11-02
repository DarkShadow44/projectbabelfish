package compat.sandbox.net.minecraft.block;

import net.minecraft.block.SoundType;

public class Compat_Block_SoundType {
	private final SoundType original;

	public Compat_Block_SoundType(SoundType original) {
		this.original = original;
	}

	public SoundType getReal() {
		return original;
	}
}
