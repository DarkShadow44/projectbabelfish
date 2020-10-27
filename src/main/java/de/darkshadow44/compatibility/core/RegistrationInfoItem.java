package de.darkshadow44.compatibility.core;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class RegistrationInfoItem {
	private final Item item;
	private final String name;
	private final ResourceLocation location;

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
