package compat.sandbox.net.minecraft.block;

import net.minecraft.block.BlockDoublePlant.EnumPlantType;

public enum Compat_BlockDoublePlant_EnumPlantType {

	SUNFLOWER(EnumPlantType.SUNFLOWER),
	SYRINGA(EnumPlantType.SYRINGA),
	GRASS(EnumPlantType.GRASS),
	FERN(EnumPlantType.FERN),
	ROSE(EnumPlantType.ROSE),
	PAEONIA(EnumPlantType.PAEONIA);

	private EnumPlantType original;

	private Compat_BlockDoublePlant_EnumPlantType(EnumPlantType original) {
		this.original = original;
	}

	public EnumPlantType getReal() {
		return original;
	}

	public static Compat_BlockDoublePlant_EnumPlantType getFake(EnumPlantType real) {
		switch (real) {
		default:
			throw new RuntimeException("Unhandled " + real.name());
		}
	}

	public static EnumPlantType getFromInt(int value) {
		switch (value) {
		case 0:
			return EnumPlantType.SUNFLOWER;
		case 1:
			return EnumPlantType.SYRINGA;
		case 2:
			return EnumPlantType.GRASS;
		case 3:
			return EnumPlantType.FERN;
		case 4:
			return EnumPlantType.ROSE;
		case 5:
			return EnumPlantType.PAEONIA;
		default:
			throw new RuntimeException("Unhandled value " + value);
		}
	}

}
