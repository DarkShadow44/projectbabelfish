package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.text;

import net.minecraft.util.text.TextFormatting;

public enum Compat_TextFormatting {
	RESET(TextFormatting.RESET);

	private TextFormatting original;

	private Compat_TextFormatting(TextFormatting original) {
		this.original = original;
	}

	public TextFormatting getReal() {
		return original;
	}

	public static Compat_TextFormatting Compat_get_RESET() {
		return RESET;
	}
}
