package compat.sandbox.net.minecraft.block;

import net.minecraft.block.BlockPressurePlate.Sensitivity;

public class Compat_BlockPressurePlate_Sensitivity {

	private static final Compat_BlockPressurePlate_Sensitivity EVERYTHING = new Compat_BlockPressurePlate_Sensitivity(Sensitivity.EVERYTHING);
	private static final Compat_BlockPressurePlate_Sensitivity MOBS = new Compat_BlockPressurePlate_Sensitivity(Sensitivity.MOBS);

	private final Sensitivity original;

	public Compat_BlockPressurePlate_Sensitivity(Sensitivity original) {
		this.original = original;
	}

	Sensitivity getReal() {
		return original;
	}

	public static Compat_BlockPressurePlate_Sensitivity Compat_get_everything() {
		return EVERYTHING;
	}

	public static Compat_BlockPressurePlate_Sensitivity Compat_get_mobs() {
		return MOBS;
	}
}
