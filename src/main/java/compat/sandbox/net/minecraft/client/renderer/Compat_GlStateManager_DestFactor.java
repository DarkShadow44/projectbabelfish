package compat.sandbox.net.minecraft.client.renderer;

import net.minecraft.client.renderer.GlStateManager.DestFactor;

public enum Compat_GlStateManager_DestFactor {

	ONE_MINUS_SRC_ALPHA(DestFactor.ONE_MINUS_SRC_ALPHA),
	ZERO(DestFactor.ZERO);

	private DestFactor original;

	private Compat_GlStateManager_DestFactor(DestFactor original) {
		this.original = original;
	}

	public DestFactor getReal() {
		return original;
	}

	public static Compat_GlStateManager_DestFactor Compat_get_ONE_MINUS_SRC_ALPHA() {
		return ONE_MINUS_SRC_ALPHA;
	}

	public static Compat_GlStateManager_DestFactor Compat_get_ZERO() {
		return ZERO;
	}
}
