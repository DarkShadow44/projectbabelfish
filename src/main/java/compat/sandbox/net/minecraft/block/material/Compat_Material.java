package compat.sandbox.net.minecraft.block.material;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.block.material.Material;

public class Compat_Material {

	private static final Compat_Material PLANTS = new Compat_Material(Material.PLANTS);
	private static final Compat_Material WOOD = new Compat_Material(Material.WOOD);
	private static final Compat_Material LEAVES = new Compat_Material(Material.LEAVES);
	private static final Compat_Material CLOTH = new Compat_Material(Material.CLOTH);
	private static final Compat_Material VINE = new Compat_Material(Material.VINE);
	private static final Compat_Material CACTUS = new Compat_Material(Material.CACTUS);
	private static final Compat_Material GROUND = new Compat_Material(Material.GROUND);
	private static final Compat_Material CIRCUITS = new Compat_Material(Material.CIRCUITS);
	private static final Compat_Material ANVIL = new Compat_Material(Material.ANVIL);
	private static final Compat_Material GLASS = new Compat_Material(Material.GLASS);
	private static final Compat_Material ROCK = new Compat_Material(Material.ROCK);
	private static final Compat_Material ICE = new Compat_Material(Material.ICE);
	private static final Compat_Material SNOW = new Compat_Material(Material.SNOW);
	private static final Compat_Material PORTAL = new Compat_Material(Material.PORTAL);
	private static final Compat_Material IRON = new Compat_Material(Material.IRON);
	private static final Compat_Material AIR = new Compat_Material(Material.AIR);
	private static final Compat_Material WATER = new Compat_Material(Material.WATER);

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

	public boolean Compat_func_76222_j() {
		return wrapper.isReplaceableSuper();
	}

	public static Compat_Material Compat_get_field_151585_k() {
		return PLANTS;
	}

	public static Compat_Material Compat_get_field_151575_d() {
		return WOOD;
	}

	public static Compat_Material Compat_get_field_151584_j() {
		return LEAVES;
	}

	public static Compat_Material Compat_get_field_151580_n() {
		return CLOTH;
	}

	public static Compat_Material Compat_get_field_151582_l() {
		return VINE;
	}

	public Compat_MapColor Compat_func_151565_r() {
		return new Compat_MapColor(wrapper.getMaterialMapColorSuper());
	}

	public Compat_Material Compat_func_76226_g() {

		wrapper.setBurningSuper();
		return this;
	}

	public Compat_Material Compat_func_76219_n() {

		wrapper.setNoPushMobilitySuper();
		return this;
	}

	public Compat_Material Compat_func_76231_i() {

		wrapper.setReplaceableSuper();
		return this;
	}

	public static Compat_Material Compat_get_field_151570_A() {
		return CACTUS;
	}

	public static Compat_Material Compat_get_field_151578_c() {
		return GROUND;
	}

	public static Compat_Material Compat_get_field_151594_q() {
		return CIRCUITS;
	}

	public static Compat_Material Compat_get_field_151574_g() {
		return ANVIL;
	}

	public static Compat_Material Compat_get_field_151592_s() {
		return GLASS;
	}

	public static Compat_Material Compat_get_field_151576_e() {
		return ROCK;
	}

	public static Compat_Material Compat_get_field_151588_w() {
		return ICE;
	}

	public static Compat_Material Compat_get_field_151597_y() {
		return SNOW;
	}

	public static Compat_Material Compat_get_field_151567_E() {
		return PORTAL;
	}

	public static Compat_Material Compat_get_field_151573_f() {
		return IRON;
	}

	public static Compat_Material Compat_get_field_151579_a() {
		return AIR;
	}

	public static Compat_Material Compat_get_field_151586_h() {
		return WATER;
	}

	public boolean Compat_func_76229_l() {
		return wrapper.isToolNotRequiredSuper();
	}

	public static Compat_Material getFake(Material material) {
		return new Compat_Material(material);
	}
}
