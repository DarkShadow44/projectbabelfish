package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util;

import net.minecraft.util.ResourceLocation;

public interface CompatI_ResourceLocation {
	public ResourceLocation get();

	public int compareToSuper(ResourceLocation real);

	public String getResourceDomainSuper();

	public String getResourcePathSuper();

	public String toStringSuper();

	public boolean equalsSuper(Object other);

	public int hashCodeSuper();
}
