package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block.material;

import net.minecraft.block.material.Material;

public class Compat_Material {
	private Material original;
	private CompatI_Material thisReal;

	// When called from Mod
	public Compat_Material() {
		this.thisReal = new CompatReal_Material(this, null); // TODO
	}

	// When called from child
	public Compat_Material(CompatI_Material thisReal) {
	}

	// When called from Minecraft
	public Compat_Material(Material original) {
		this.original = original;
	}

	public void setThisReal(CompatI_Material thisReal) {
		this.thisReal = thisReal;
	}

	public Material getReal() {
		return original == null ? thisReal.get() : original;
	}

	public static Compat_Material Compat_get_field_151585_k() {
		return new Compat_Material(Material.PLANTS);
	}
}
