
package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import net.minecraft.item.EnumAction;

public class Compat_EnumAction {

	private final static Compat_EnumAction EAT = new Compat_EnumAction(EnumAction.EAT);
	private final static Compat_EnumAction DRINK = new Compat_EnumAction(EnumAction.DRINK);

	private final EnumAction original;

	public Compat_EnumAction(EnumAction original) {
		this.original = original;
	}

	public EnumAction getReal() {
		return original;
	}

	public static Compat_EnumAction Compat_get_eat() {
		return EAT;
	}

	public static Compat_EnumAction Compat_get_drink() {
		return DRINK;
	}
}
