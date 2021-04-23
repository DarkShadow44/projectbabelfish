package compat.sandbox.net.minecraft.block;

import compat.sandbox.net.minecraft.util.Compat_SoundEvent;
import net.minecraft.block.SoundType;

public class Compat_SoundType {

	private static Compat_SoundType GLASS = new Compat_SoundType(SoundType.GLASS);

	private final SoundType original;

	public Compat_SoundType(SoundType original) {
		this.original = original;
	}

	public SoundType getReal() {
		return original;
	}

	public static Compat_SoundType Compat_get_field_185853_f() {
		return GLASS;
	}

	public Compat_SoundEvent Compat_func_185841_e() {
		return new Compat_SoundEvent(original.getPlaceSound());
	}

	public float Compat_func_185843_a() {
		return original.getVolume();
	}

	public float Compat_func_185847_b() {
		return original.getPitch();
	}
}
