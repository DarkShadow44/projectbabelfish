package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.potion;

import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.potion.Potion;

public class Compat_Potion {
	private Potion original;
	private CompatI_Potion thisReal;

	// When called from Mod
	public Compat_Potion(boolean isBadEffect, int color) {
		initialize(new CompatReal_Potion(this, isBadEffect, color), null);
	}

	// When called from child
	protected Compat_Potion(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Potion(Potion original) {
		initialize(null, original);
	}

	protected void initialize(CompatI_Potion thisReal, Potion original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public Potion getReal() {
		return original == null ? thisReal.get() : original;
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
		return Potion.getIdFromPotion(original);
	}
}
