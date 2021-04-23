package compat.core;

import compat.sandbox.net.minecraft.util.Compat_IIcon;

public class RegistrationInfoIcon {
	private final Compat_IIcon icon;

	public RegistrationInfoIcon(Compat_IIcon icon) {
		this.icon = icon;
	}

	public Compat_IIcon getIcon() {
		return icon;
	}
}
