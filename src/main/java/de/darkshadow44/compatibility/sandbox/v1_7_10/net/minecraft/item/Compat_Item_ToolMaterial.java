package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import net.minecraft.item.Item.ToolMaterial;

public class Compat_Item_ToolMaterial {

	ToolMaterial material;

	public Compat_Item_ToolMaterial(ToolMaterial material) {
		this.material = material;
	}

	public ToolMaterial getReal() {
		return material;
	}

	public static Compat_Item_ToolMaterial Compat_get_IRON() {
		return new Compat_Item_ToolMaterial(ToolMaterial.IRON);
	}

	public static Compat_Item_ToolMaterial Compat_get_WOOD() {
		return new Compat_Item_ToolMaterial(ToolMaterial.WOOD);
	}

	public static Compat_Item_ToolMaterial Compat_get_GOLD() {
		return new Compat_Item_ToolMaterial(ToolMaterial.GOLD);
	}

	public static Compat_Item_ToolMaterial Compat_get_STONE() {
		return new Compat_Item_ToolMaterial(ToolMaterial.STONE);
	}

	public static Compat_Item_ToolMaterial Compat_get_EMERALD() {
		return new Compat_Item_ToolMaterial(ToolMaterial.DIAMOND);
	}

	public float Compat_func_78000_c() {
		return material.getAttackDamage();
	}

	public int Compat_func_77997_a() {
		return material.getMaxUses();
	}
}
