package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.item;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.world.World;

public class CompatReal_EntityItem extends EntityItem implements CompatI_EntityItem {
	@SuppressWarnings("unused")
	private Compat_EntityItem thisFake;

	public CompatReal_EntityItem(Compat_EntityItem thisFake, World world) {
		super(world);
		this.thisFake = thisFake;
	}

	@Override
	public EntityItem get() {
		return this;
	}
}
