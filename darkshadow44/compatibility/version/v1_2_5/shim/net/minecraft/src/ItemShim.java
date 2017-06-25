package darkshadow44.compatibility.version.v1_2_5.shim.net.minecraft.src;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ItemShim extends Item {

	public void setItemName(String name) {
		GameRegistry.registerItem(this, name);
		this.setUnlocalizedName(name);
	}
}
