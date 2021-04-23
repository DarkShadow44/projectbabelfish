package compat.core.layer;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class ModelLocationInfo {
	public final Item item;
	public final int metadata;
	public final ModelResourceLocation location;

	public ModelLocationInfo(Item item, int metadata, ModelResourceLocation location) {
		this.item = item;
		this.metadata = metadata;
		this.location = location;
	}
}
