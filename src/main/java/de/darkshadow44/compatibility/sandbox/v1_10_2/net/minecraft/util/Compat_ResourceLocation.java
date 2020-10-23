package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.CompatibilityMod;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.util.ResourceLocation;

public class Compat_ResourceLocation implements Comparable<Compat_ResourceLocation> {
	private ResourceLocation original;
	private CompatI_ResourceLocation thisReal;

	// When called from Mod
	public Compat_ResourceLocation(String p1, String p2) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ResourceLocation.class, this, p1, p2), null);
	}

	// When called from Mod
	public Compat_ResourceLocation(String p1) {
		this.initialize(Factory.create(CtorPos.POS2, CompatI_ResourceLocation.class, this, CompatibilityMod.LAYER_1_10_2.currentModId, p1), null);
	}

	// When called from child
	protected Compat_ResourceLocation(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_ResourceLocation(ResourceLocation original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_ResourceLocation thisReal, ResourceLocation original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public ResourceLocation getReal() {
		return original == null ? thisReal.get() : original;
	}

	@Override
	public boolean equals(Object other) {
		if (original == null)
			return thisReal.equals(other);
		else
			return original.equals(other);
	}

	@Override
	public int hashCode() {
		if (original == null)
			return thisReal.hashCode();
		else
			return original.hashCode();
	}

	@Override
	public int compareTo(Compat_ResourceLocation other) {
		if (original == null)
			return thisReal.compareToSuper(other.getReal());
		else
			return original.compareTo(other.getReal());
	}

	public String Compat_func_110624_b() {
		if (original == null)
			return thisReal.getResourceDomainSuper();
		else
			return original.getResourceDomain();
	}

	public String Compat_func_110623_a() {
		if (original == null)
			return thisReal.getResourcePathSuper();
		else
			return original.getResourcePath();
	}
}
