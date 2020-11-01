package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer;

import net.minecraft.client.renderer.GlStateManager.SourceFactor;

public enum Compat_GlStateManager_SourceFactor {

	SRC_ALPHA(SourceFactor.SRC_ALPHA),
	ONE(SourceFactor.ONE);

	private SourceFactor original;

	private Compat_GlStateManager_SourceFactor(SourceFactor original) {
		this.original = original;
	}

	public SourceFactor getReal() {
		return original;
	}

	public static Compat_GlStateManager_SourceFactor Compat_get_SRC_ALPHA() {
		return SRC_ALPHA;
	}

	public static Compat_GlStateManager_SourceFactor Compat_get_ONE() {
		return ONE;
	}
}
