package compat.sandbox.net.minecraft.client.settings;

import net.minecraft.client.settings.KeyBinding;

public interface CompatI_KeyBinding {
	public KeyBinding get();

	public boolean isKeyDownSuper();

	public boolean isPressedSuper();
}
