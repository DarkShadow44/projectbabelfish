package compat.core;

import net.minecraft.util.ResourceLocation;

public class RegistrationInfoIcon {
	private final ResourceLocation location;

	public RegistrationInfoIcon(ResourceLocation location) {
		this.location = location;
	}

	public ResourceLocation getLocation() {
		return location;
	}
}
