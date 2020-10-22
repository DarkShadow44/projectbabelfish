package de.darkshadow44.compatibility.core;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class RegistrationInfoItem {
	private Item item;
	private String name;
	private ResourceLocation location;

	public RegistrationInfoItem(Item item, String name, ResourceLocation location) {
		this.item = item;
		this.name = name;
		this.location = location;
	}

	public Item getItem() {
		return item;
	}

	public String getName() {
		return name;
	}

	public ResourceLocation getLocation() {
		return location;
	}
}
