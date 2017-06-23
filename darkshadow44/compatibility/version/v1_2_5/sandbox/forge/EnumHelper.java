package darkshadow44.compatibility.version.v1_2_5.sandbox.forge;

import java.lang.reflect.Field;

import darkshadow44.compatibility.version.v1_2_5.sandbox.net.minecraft.src.EnumAction;
import darkshadow44.compatibility.version.v1_2_5.sandbox.net.minecraft.src.EnumArmorMaterial;
import darkshadow44.compatibility.version.v1_2_5.sandbox.net.minecraft.src.EnumArt;
import darkshadow44.compatibility.version.v1_2_5.sandbox.net.minecraft.src.EnumCreatureAttribute;
import darkshadow44.compatibility.version.v1_2_5.sandbox.net.minecraft.src.EnumCreatureType;
import darkshadow44.compatibility.version.v1_2_5.sandbox.net.minecraft.src.EnumDoor;
import darkshadow44.compatibility.version.v1_2_5.sandbox.net.minecraft.src.EnumEnchantmentType;
import darkshadow44.compatibility.version.v1_2_5.sandbox.net.minecraft.src.EnumMobType;
import darkshadow44.compatibility.version.v1_2_5.sandbox.net.minecraft.src.EnumMovingObjectType;
import darkshadow44.compatibility.version.v1_2_5.sandbox.net.minecraft.src.EnumSkyBlock;
import darkshadow44.compatibility.version.v1_2_5.sandbox.net.minecraft.src.EnumStatus;
import darkshadow44.compatibility.version.v1_2_5.sandbox.net.minecraft.src.EnumToolMaterial;
import darkshadow44.compatibility.version.v1_2_5.sandbox.net.minecraft.src.Material;

public class EnumHelper {

	public static EnumAction addAction(String name) {
		return null;
	}

	public static EnumArmorMaterial addArmorMaterial(String name, int durability, int[] reductionAmounts,
			int enchantability) {
		return null;
	}

	public static EnumArt addArt(String name, String tile, int sizeX, int sizeY, int offsetX, int offsetY) {
		return null;
	}

	public static EnumCreatureAttribute addCreatureAttribute(String name) {
		return null;
	}

	public static EnumCreatureType addCreatureType(String name, Class typeClass, int maxNumber, Material material,
			boolean peaceful) {
		return null;
	}

	public static EnumDoor addDoor(String name) {
		return null;
	}

	public static EnumEnchantmentType addEnchantmentType(String name) {
		return null;
	}

	public static EnumMobType addMobType(String name) {
		return null;

	}

	public static EnumMovingObjectType addMovingObjectType(String name) {
		return null;
	}

	public static EnumSkyBlock addSkyBlock(String name, int lightValue) {
		return null;
	}

	public static EnumStatus addStatus(String name) {
		return null;
	}

	public static EnumToolMaterial addToolMaterial(String name, int harvestLevel, int maxUses, float efficiency,
			int damage, int enchantability) {
		return null;
	}

	public static void setFailsafeFieldValue(Field field, Object target, Object value) throws Exception {

	}

	public static <T extends Enum<?>> T addEnum(Class<T> enumType, String enumName, boolean decompiled) {
		return addEnum(decompiled, enumType, enumName, new Class<?>[] {}, new Object[] {});
	}

	public static <T extends Enum<?>> T addEnum(boolean decompiled, Class<T> enumType, String enumName,
			Class<?>[] paramTypes, Object[] paramValues) {
		return null;
	}
}
