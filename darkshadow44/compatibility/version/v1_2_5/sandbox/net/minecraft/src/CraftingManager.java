package darkshadow44.compatibility.version.v1_2_5.sandbox.net.minecraft.src;

import java.util.ArrayList;
import java.util.List;

import darkshadow44.compatibility.version.v1_2_5.sandbox.net.minecraft.inventory.InventoryCrafting;
import darkshadow44.compatibility.version.v1_2_5.shim.net.minecraft.src.CraftingManagerShim;

public class CraftingManager {

	CraftingManagerShim craftingManagerShim;

	public CraftingManager() {
		craftingManagerShim = new CraftingManagerShim();
	}

	private static final CraftingManager instance = new CraftingManager();

	public static final CraftingManager getInstance() {
		return instance;
	}

	public ItemStack findMatchingRecipe(InventoryCrafting par1InventoryCrafting) {
		return null;
	}

	public List getRecipeList() {
		return new ArrayList();
	}
}
