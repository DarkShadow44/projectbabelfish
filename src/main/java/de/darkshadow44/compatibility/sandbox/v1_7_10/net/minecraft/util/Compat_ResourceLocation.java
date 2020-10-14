package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.util;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.util.ResourceLocation;

public class Compat_ResourceLocation {
	private ResourceLocation original;
	private CompatI_ResourceLocation thisReal;

	// When called from Mod
	public Compat_ResourceLocation(String name) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ResourceLocation.class, this, name), null);
	}

	// When called from Mod
	public Compat_ResourceLocation(String p1, String p2) {
		this.initialize(Factory.create(CtorPos.POS2, CompatI_ResourceLocation.class, this, p1, p2), null);
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
}
