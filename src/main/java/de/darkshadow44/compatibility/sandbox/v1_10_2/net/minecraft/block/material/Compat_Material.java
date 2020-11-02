package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.material;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.material.Material;

public class Compat_Material {
	private CompatI_Material wrapper;

	// When called from Mod
	public Compat_Material() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Material.class, this));
	}

	// When called from child
	protected Compat_Material(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Material(Material original) {
		this.initialize(Factory.createWrapper(CompatI_Material.class, original));
	}

	protected void initialize(CompatI_Material wrapper) {
		this.wrapper = wrapper;
	}

	public Material getReal() {
		return wrapper.get();
	}

	public static Compat_Material Compat_get_field_151578_c() {
		return new Compat_Material(Material.GROUND);
	}

	public static Compat_Material Compat_get_field_151576_e() {
		return new Compat_Material(Material.ROCK);
	}

	public boolean Compat_func_76222_j() {
		return wrapper.isReplaceableSuper();
	}

	public static Compat_Material Compat_get_field_151579_a() {
		return new Compat_Material(Material.AIR);
	}
}
