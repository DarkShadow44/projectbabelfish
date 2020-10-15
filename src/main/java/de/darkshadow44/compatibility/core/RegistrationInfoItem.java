package de.darkshadow44.compatibility.core;

import net.minecraft.item.Item;

public class RegistrationInfoItem {
	private Item item;
	private String name;

	public RegistrationInfoItem(Item item, String name) {
		this.item = item;
		this.name = name;
	}

	public Item getItem() {
		return item;
	}

	public String getName() {
		return name;
	}
}
