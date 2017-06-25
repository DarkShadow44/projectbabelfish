package darkshadow44.compatibility.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabCompat extends CreativeTabs {

	public CreativeTabCompat(String p_i1853_2_) {
		super(0, p_i1853_2_);
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemById(119);
	}

}
