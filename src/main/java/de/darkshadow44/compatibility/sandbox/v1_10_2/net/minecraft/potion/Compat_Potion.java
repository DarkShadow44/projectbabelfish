package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.potion;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.potion.Potion;

public class Compat_Potion {
	private CompatI_Potion wrapper;

	// When called from Mod
	public Compat_Potion(boolean isBadEffect, int color) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Potion.class, this, isBadEffect, color));
	}

	// When called from child
	protected Compat_Potion(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Potion(Potion original) {
		this.initialize(Factory.createWrapper(CompatI_Potion.class, original));
	}

	protected void initialize(CompatI_Potion wrapper) {
		this.wrapper = wrapper;
	}

	public Potion getReal() {
		return wrapper.get();
	}

	public static Compat_Potion[] Compat_get_field_76425_a() {
		return new Compat_Potion[0]; // TODO
	}

	public static Compat_Potion Compat_get_field_76428_l() {
		return new Compat_Potion(Potion.REGISTRY.getObjectById(10)); // Regeneration
	}

	public static Compat_Potion Compat_get_field_76437_t() {
		return new Compat_Potion(Potion.REGISTRY.getObjectById(18)); // Weakness
	}

	public int Compat_get_field_76415_H() {
		return Potion.getIdFromPotion(wrapper.get());
	}

	public static Compat_Potion Compat_get_field_76424_c() {
		return new Compat_Potion(Potion.REGISTRY.getObjectById(1)); // Speed
	}

	public static Compat_Potion Compat_get_field_76421_d() {
		return new Compat_Potion(Potion.REGISTRY.getObjectById(2)); // Slowness
	}

	public static Compat_Potion Compat_get_field_76422_e() {
		return new Compat_Potion(Potion.REGISTRY.getObjectById(3)); // Haste
	}

	public static Compat_Potion Compat_get_field_76419_f() {
		return new Compat_Potion(Potion.REGISTRY.getObjectById(4)); // Mining fatigue
	}

	public static Compat_Potion Compat_get_field_76443_y() {
		return new Compat_Potion(Potion.REGISTRY.getObjectById(23)); // Saturation
	}

	public static Compat_Potion Compat_get_field_76438_s() {
		return new Compat_Potion(Potion.REGISTRY.getObjectById(17)); // Hunger
	}

	public static Compat_Potion Compat_get_field_76440_q() {
		return new Compat_Potion(Potion.REGISTRY.getObjectById(15)); // Blindness
	}

	public static Compat_Potion Compat_get_field_76434_w() {
		return new Compat_Potion(Potion.REGISTRY.getObjectById(21)); // Health boost
	}

	public static Compat_Potion Compat_get_field_76420_g() {
		return new Compat_Potion(Potion.REGISTRY.getObjectById(5)); // Strength
	}

	public static Compat_Potion Compat_get_field_76426_n() {
		return new Compat_Potion(Potion.REGISTRY.getObjectById(12)); // Fire resistance
	}

	public static Compat_Potion Compat_get_field_76431_k() {
		return new Compat_Potion(Potion.REGISTRY.getObjectById(9)); // Nausea
	}

	public static Compat_Potion Compat_get_field_76436_u() {
		return new Compat_Potion(Potion.REGISTRY.getObjectById(19)); // Poison
	}

	public static Compat_Potion Compat_get_field_82731_v() {
		return new Compat_Potion(Potion.REGISTRY.getObjectById(20)); // Wither
	}

	public static Compat_Potion Compat_get_field_76439_r() {
		return new Compat_Potion(Potion.REGISTRY.getObjectById(16)); // Night vision
	}
}
