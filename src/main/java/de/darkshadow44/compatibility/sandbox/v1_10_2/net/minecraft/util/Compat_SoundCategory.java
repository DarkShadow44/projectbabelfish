package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util;

import net.minecraft.util.SoundCategory;

public enum Compat_SoundCategory {

	BLOCKS(SoundCategory.BLOCKS);

	private SoundCategory original;

	private Compat_SoundCategory(SoundCategory original) {
		this.original = original;
	}

	public SoundCategory getReal() {
		return original;
	}

	public static Compat_SoundCategory Compat_get_BLOCKS() {
		return BLOCKS;
	}
}
