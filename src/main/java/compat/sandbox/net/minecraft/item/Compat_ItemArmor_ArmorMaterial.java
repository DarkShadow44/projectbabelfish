package compat.sandbox.net.minecraft.item;

import compat.sandbox.net.minecraft.util.Compat_SoundEvent;
import net.minecraft.item.ArmorMaterial;

public class Compat_ItemArmor_ArmorMaterial {

	private static final Compat_ItemArmor_ArmorMaterial IRON = new Compat_ItemArmor_ArmorMaterial(ArmorMaterial.IRON);

	private final ArmorMaterial original;

	public Compat_ItemArmor_ArmorMaterial(ArmorMaterial original) {
		this.original = original;
	}

	public ArmorMaterial getReal() {
		return original;
	}

	public static Compat_ItemArmor_ArmorMaterial Compat_get_IRON() {
		return IRON;
	}

	public Compat_SoundEvent Compat_func_185017_b() {
		return new Compat_SoundEvent(original.getSoundEvent());
	}
}
