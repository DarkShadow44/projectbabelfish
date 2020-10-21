package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.common.util;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.item.Compat_ItemArmor_ArmorMaterial;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.Compat_SoundEvent;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class Compat_EnumHelper {
	public static Compat_ItemArmor_ArmorMaterial Compat_addArmorMaterial(String name, String textureName, int durability, int[] reductionAmounts, int enchantability, Compat_SoundEvent soundOnEquip, float toughness)
	{
		ArmorMaterial material = EnumHelper.addArmorMaterial(name, textureName, durability, reductionAmounts, enchantability, soundOnEquip.getReal(), toughness);
		return new Compat_ItemArmor_ArmorMaterial(material);
	}
}
