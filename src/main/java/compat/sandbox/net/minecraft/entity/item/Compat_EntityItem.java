package compat.sandbox.net.minecraft.entity.item;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.entity.Compat_Entity;
import net.minecraft.entity.item.EntityItem;

public class Compat_EntityItem extends Compat_Entity {
	private CompatI_EntityItem wrapper;

	// When called from Mod
	public Compat_EntityItem() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityItem.class, this));
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
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public EntityItem getReal() {
		return wrapper.get();
	}
}
