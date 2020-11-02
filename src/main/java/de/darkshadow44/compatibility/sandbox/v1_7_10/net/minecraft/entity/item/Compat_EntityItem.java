package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.item;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.world.Compat_World;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.Compat_Entity;
import net.minecraft.entity.item.EntityItem;

public class Compat_EntityItem extends Compat_Entity {
	private CompatI_EntityItem wrapper;

	// When called from Mod
	public Compat_EntityItem(Compat_World world) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityItem.class, this, world.getReal()));
	}

	// When called from child
	protected Compat_EntityItem(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityItem(EntityItem original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityItem.class, original));
	}

	protected void initialize(CompatI_EntityItem wrapper) {
		this.wrapper = wrapper;
	}

	public EntityItem getReal() {
		return wrapper.get();
	}
}
