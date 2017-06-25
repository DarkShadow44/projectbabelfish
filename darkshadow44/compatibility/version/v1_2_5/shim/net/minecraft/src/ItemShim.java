package darkshadow44.compatibility.version.v1_2_5.shim.net.minecraft.src;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemShim extends Item {

	public darkshadow44.compatibility.version.v1_2_5.sandbox.net.minecraft.src.Item itemSandbox;

	public ItemShim(darkshadow44.compatibility.version.v1_2_5.sandbox.net.minecraft.src.Item itemSandbox) {
		this.itemSandbox = itemSandbox;
	}

	public void setItemName(String name) {
		GameRegistry.registerItem(this, name);
		this.setUnlocalizedName(name);
	}

	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		String originalName = super.getItemStackDisplayName(stack);
		if (!originalName.endsWith(".name"))
			return originalName;
		return itemSandbox.d(new darkshadow44.compatibility.version.v1_2_5.sandbox.net.minecraft.src.ItemStack(0, 0, 0));
	}
}
