package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block.material;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import net.minecraft.block.material.Material;

public class Compat_Material {
	private Material original;
	private CompatI_Material thisReal;

	// When called from Mod
	public Compat_Material(Compat_MapColor color) {
		this.thisReal = Factory.create(CtorPos.POS1, this, color.getReal());
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

	public static Compat_Material Compat_get_field_151575_d() {
		return new Compat_Material(Material.WOOD);
	}

	public static Compat_Material Compat_get_field_151584_j() {
		return new Compat_Material(Material.LEAVES);
	}

	public static Compat_Material Compat_get_field_151580_n() {
		return new Compat_Material(Material.CLOTH);
	}

	public static Compat_Material Compat_get_field_151582_l() {
		return new Compat_Material(Material.VINE);
	}

	public Compat_MapColor Compat_func_151565_r() {
		return new Compat_MapColor(original.getMaterialMapColor());
	}

	public Compat_Material Compat_func_76226_g() {
		if (this.original == null)
			thisReal.setBurningSuper();
		else
			original.setBurning();
		return this;
	}

	public Compat_Material Compat_func_76219_n() {
		if (this.original == null)
			thisReal.setNoPushMobilitySuper();
		else
			original.setNoPushMobility();
		return this;
	}

	public Compat_Material Compat_func_76231_i() {
		if (this.original == null)
			thisReal.setReplaceableSuper();
		else
			original.setReplaceable();
		return this;
	}

	public static Compat_Material Compat_get_field_151570_A() {
		return new Compat_Material(Material.CACTUS);
	}

	public static Compat_Material Compat_get_field_151578_c() {
		return new Compat_Material(Material.GROUND);
	}

	public static Compat_Material Compat_get_field_151594_q() {
		return new Compat_Material(Material.CIRCUITS);
	}

	public static Compat_Material Compat_get_field_151574_g() {
		return new Compat_Material(Material.ANVIL);
	}

	public static Compat_Material Compat_get_field_151592_s() {
		return new Compat_Material(Material.GLASS);
	}

	public static Compat_Material Compat_get_field_151576_e() {
		return new Compat_Material(Material.ROCK);
	}

	public static Compat_Material Compat_get_field_151588_w() {
		return new Compat_Material(Material.ICE);
	}

	public static Compat_Material Compat_get_field_151597_y() {
		return new Compat_Material(Material.SNOW);
	}

	public static Compat_Material Compat_get_field_151567_E() {
		return new Compat_Material(Material.PORTAL);
	}

	public static Compat_Material Compat_get_field_151573_f() {
		return new Compat_Material(Material.IRON);
	}

	public static Compat_Material Compat_get_field_151579_a() {
		return new Compat_Material(Material.AIR);
	}

	public static Compat_Material Compat_get_field_151586_h() {
		return new Compat_Material(Material.WATER);
	}
}
