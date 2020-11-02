package compat.sandbox.net.minecraft.item;

import net.minecraft.item.Item.ToolMaterial;

public class Compat_Item_ToolMaterial {

	private static final Compat_Item_ToolMaterial IRON = new Compat_Item_ToolMaterial(ToolMaterial.IRON);
	private static final Compat_Item_ToolMaterial WOOD = new Compat_Item_ToolMaterial(ToolMaterial.WOOD);
	private static final Compat_Item_ToolMaterial GOLD = new Compat_Item_ToolMaterial(ToolMaterial.GOLD);
	private static final Compat_Item_ToolMaterial STONE = new Compat_Item_ToolMaterial(ToolMaterial.STONE);
	private static final Compat_Item_ToolMaterial EMERALD = new Compat_Item_ToolMaterial(ToolMaterial.DIAMOND);

	private final ToolMaterial original;

	public Compat_Item_ToolMaterial(ToolMaterial original) {
		this.original = original;
	}

	public ToolMaterial getReal() {
		return original;
	}

	public static Compat_Item_ToolMaterial Compat_get_IRON() {
		return IRON;
	}

	public static Compat_Item_ToolMaterial Compat_get_WOOD() {
		return WOOD;
	}

	public static Compat_Item_ToolMaterial Compat_get_GOLD() {
		return GOLD;
	}

	public static Compat_Item_ToolMaterial Compat_get_STONE() {
		return STONE;
	}

	public static Compat_Item_ToolMaterial Compat_get_EMERALD() {
		return EMERALD;
	}

	public float Compat_func_78000_c() {
		return original.getAttackDamage();
	}

	public int Compat_func_77997_a() {
		return original.getMaxUses();
	}
}
