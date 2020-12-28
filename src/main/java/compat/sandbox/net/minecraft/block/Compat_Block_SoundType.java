package compat.sandbox.net.minecraft.block;

import net.minecraft.block.SoundType;

public class Compat_Block_SoundType {
	private final SoundType original;

	public Compat_Block_SoundType(SoundType original) {
		this.original = original;
	}

	public SoundType getReal() {
		return original;
	}

	public float Compat_func_150494_d() {
		return original.getPitch();
	}

	public float Compat_func_150497_c() {
		return original.getVolume();
	}

	public String Compat_func_150498_e() {
		throw new RuntimeException();
		//return "step." + original.getStepSound().getSoundName().getResourcePath(); // TODO ?
	}
}
