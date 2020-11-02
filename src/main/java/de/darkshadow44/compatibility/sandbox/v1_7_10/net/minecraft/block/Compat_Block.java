package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block.material.Compat_Material;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.creativetab.Compat_CreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.creativetab.CreativeTabs;

public class Compat_Block {
	private CompatI_Block wrapper;

	// When called from Mod
	public Compat_Block(Compat_Material material) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Block.class, this, material.getReal()));
	}

	// When called from child
	protected Compat_Block(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Block(Block original) {
		this.initialize(Factory.createWrapper(CompatI_Block.class, original));
	}

	protected void initialize(CompatI_Block wrapper) {
		this.wrapper = wrapper;
	}

	public Block getReal() {
		return wrapper.get();
	}

	public Compat_Block Compat_func_149675_a(boolean shouldTick) {

		wrapper.setTickRandomlySuper(shouldTick);
		return this;
	}

	public void Compat_func_149676_a(float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
		// TODO: setBlockBounds
	}

	public Compat_Block Compat_func_149711_c(float hardness) {

		wrapper.setHardnessSuper(hardness);
		return this;
	}

	public static Compat_Block_SoundType Compat_get_field_149779_h() {
		return new Compat_Block_SoundType(SoundType.PLANT);
	}

	public Compat_Block Compat_func_149672_a(Compat_Block_SoundType sound) {

		wrapper.setSoundTypeSuper(sound.getReal());
		return this;
	}

	public Compat_Block Compat_func_149649_H() {

		wrapper.disableStatsSuper();
		return this;
	}

	public Compat_Block Compat_func_149647_a(Compat_CreativeTabs creativeTabs) {
		CreativeTabs real = creativeTabs == null ? null : creativeTabs.getReal();

		wrapper.setCreativeTabSuper(real);
		return this;
	}

	public Compat_Block Compat_func_149663_c(String name) {
		{
			wrapper.setUnlocalizedNameSuper(name);
			wrapper.setRegistryNameSuper(name);
		}
		return this;
	}

	public Compat_Block Compat_func_149658_d(String name) {
		// TODO
		return this;
	}

	public static Compat_Block_SoundType Compat_get_field_149766_f() {
		return new Compat_Block_SoundType(SoundType.WOOD);
	}

	public Compat_Block Compat_func_149713_g(int opacity) {

		wrapper.setLightOpacitySuper(opacity);
		return this;
	}

	public Compat_Block Compat_func_149722_s() {

		wrapper.setBlockUnbreakableSuper();
		return this;
	}

	public Compat_Block Compat_func_149752_b(float resistance) {

		wrapper.setResistanceSuper(resistance);
		return this;
	}

	public Compat_Block Compat_func_149715_a(float value) {

		wrapper.setLightLevelSuper(value);
		return this;
	}

	public static Compat_Block_SoundType Compat_get_field_149775_l() {
		return new Compat_Block_SoundType(SoundType.CLOTH);
	}

	public static Compat_Block_SoundType Compat_get_field_149767_g() {
		return new Compat_Block_SoundType(SoundType.GROUND);
	}

	public static Compat_Block_SoundType Compat_get_field_149777_j() {
		return new Compat_Block_SoundType(SoundType.METAL);
	}

	public static Compat_Block_SoundType Compat_get_field_149769_e() {
		return new Compat_Block_SoundType(SoundType.STONE);
	}

	public static Compat_Block_SoundType Compat_get_field_149773_n() {
		return new Compat_Block_SoundType(SoundType.SNOW);
	}

	public static Compat_Block_SoundType Compat_get_field_149780_i() {
		return new Compat_Block_SoundType(SoundType.WOOD); // TODO
	}

	public static Compat_Block_SoundType Compat_get_field_149778_k() {
		return new Compat_Block_SoundType(SoundType.GLASS);
	}

	public void Compat_set_field_149765_K(float value) {

		wrapper.setDefaultSlipperinessSuper(value);
	}

	public void Compat_set_field_149787_q(boolean opaque) {
		// TODO opaque
	}

}
