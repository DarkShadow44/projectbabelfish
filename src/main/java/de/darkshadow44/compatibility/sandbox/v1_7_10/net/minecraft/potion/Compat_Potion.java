package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.potion;

import net.minecraft.potion.Potion;

public class Compat_Potion extends Potion {

	protected Compat_Potion(boolean isBadEffectIn, int liquidColorIn) {
		super(isBadEffectIn, liquidColorIn);
	}

	public static Compat_Potion[] Compat_get_field_76425_a() {
		return new Compat_Potion[0]; // TODO
	}

}
