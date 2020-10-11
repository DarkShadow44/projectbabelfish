package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import net.minecraft.block.BlockPressurePlate.Sensitivity;

public class Compat_BlockPressurePlate_Sensitivity {
	Sensitivity original;

	public Compat_BlockPressurePlate_Sensitivity(Sensitivity original) {
		this.original = original;
	}

	Sensitivity getReal() {
		return original;
	}

	public static Compat_BlockPressurePlate_Sensitivity Compat_get_everything() {
		return new Compat_BlockPressurePlate_Sensitivity(Sensitivity.EVERYTHING);
	}

	public static Compat_BlockPressurePlate_Sensitivity Compat_get_mobs() {
		return new Compat_BlockPressurePlate_Sensitivity(Sensitivity.MOBS);
	}
}
